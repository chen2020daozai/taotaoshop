package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.commom.pojo.EUDataGridResult;
import com.taotao.commom.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ItemParamServiceImpl
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/8 下午8:44
 * @Version 1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper itemParamMapper;

    @Override
    public TaotaoResult getParamCid(long cid) {
        TbItemParamExample example=new TbItemParamExample();
        TbItemParamExample.Criteria criteria=example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> list = itemParamMapper.selectByExample(example);
//      查询是否有这个类目，有就返回这个类目
        if (list!=null&&list.size()>0){
            return TaotaoResult.ok(list.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertIemParam(TbItemParam itemParam) {
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());

        itemParamMapper.insert(itemParam);
        return TaotaoResult.ok();
    }

    @Override
    //EUDataGridResult只影响返回类型，getItemParamList传入参数
    public EUDataGridResult getItemParamList(int page, int rows) {
        //查询
        TbItemParamExample example=new TbItemParamExample();
        //封装
        PageHelper.startPage(page, rows);
        //总条数
        List<TbItemParam> list = itemParamMapper.selectByExample(example);
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        PageInfo<TbItemParam> pageInfo=new PageInfo<>(list);
        result.setTotal((int) pageInfo.getTotal());
        return result;
    }
}
