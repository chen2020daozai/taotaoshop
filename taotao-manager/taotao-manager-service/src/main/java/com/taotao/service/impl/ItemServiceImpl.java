package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.commom.pojo.EUDataGridResult;
import com.taotao.commom.pojo.TaotaoResult;
import com.taotao.common.Utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Create by 陈刀仔 at 23:24 on 2020/2/21
 */
//商品管理service
@Service
public class ItemServiceImpl implements ItemService {
    /**
     * @Autowired Dao层的注入
     * Settings - Editor - Inspections - Spring - Spring Core - Code - Autowiring for Bean Class - disable（把√去掉）。
     */
    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Override
    public TbItem getItemById(Long itemId) {

//        TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
//      根据主键查询
        TbItemExample example = new TbItemExample();
        //添加查询条件
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);

        List<TbItem> list = itemMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            TbItem item = list.get(0);
            return item;
        }

        
        return null;
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        //查询商品列表
        TbItemExample example = new TbItemExample();
        //分页
        PageHelper.startPage(page, rows);
        List<TbItem> list = itemMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //封装list，取记录总条数
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        result.setTotal((int) pageInfo.getTotal());

        return result;
    }

    @Override
    public TaotaoResult creatItem(TbItem item, String desc) throws Exception {
//        item补全(表单中没有的）
        long id = IDUtils.genItemId();
        item.setId(id);
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
//        插入到数据库
        itemMapper.insert(item);

        //添加商品描述信息
        TaotaoResult result = insertItemDesc(id, desc);
        if (result.getStatus()!=200){
            throw new Exception();
        }
        return TaotaoResult.ok();
    }
    private TaotaoResult insertItemDesc(long itemId, String desc){
        TbItemDesc itemDesc=new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDesc.setItemDesc(desc);
        itemDescMapper.insert(itemDesc);
        return TaotaoResult.ok();
    }

}
