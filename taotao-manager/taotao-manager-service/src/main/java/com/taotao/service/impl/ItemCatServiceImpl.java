package com.taotao.service.impl;

import com.taotao.commom.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ItemCatServiceImpl
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/2/28 9:39
 * @Version 1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EUTreeNode> getItemCatList(long parentid) {
        //创建查询条件  创建example，创建example的条件criteria
        TbItemCatExample example=new TbItemCatExample();
        TbItemCatExample.Criteria criteria=example.createCriteria();
        criteria.andParentIdEqualTo(parentid);
        //根据条件查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        List<EUTreeNode> resultList=new ArrayList<>();
        //列表转换成treeNodeList
        for (TbItemCat tbitemcat:list
             ) {
            EUTreeNode node=new EUTreeNode();
            node.setId(tbitemcat.getId());
            node.setText(tbitemcat.getName());
            node.setState(tbitemcat.getIsParent()?"closed":"open");
            resultList.add(node);
        }
        //返回结果
        return resultList;
    }
}
