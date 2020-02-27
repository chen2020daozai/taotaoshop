package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
