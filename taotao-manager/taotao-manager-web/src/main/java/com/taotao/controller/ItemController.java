package com.taotao.controller;

import com.taotao.commom.pojo.EUDataGridResult;
import com.taotao.commom.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品管理Controller
 * Create by 陈刀仔 at 12:24 on 2020/2/23
 */

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemBId(@PathVariable Long itemId) {
        TbItem item = itemService.getItemById(itemId);
        return item;
    }

    //    item-list.jsp中field后面的是分页查询中的“列”，需要跟TbItem的属性相对应
//    web运行去本地仓库找jar，找不到需要安装jar
    @RequestMapping("/item/list")//地址
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows) {
        EUDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }

    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult creatItem(TbItem item, String desc) throws Exception {
        TaotaoResult result = itemService.creatItem(item, desc);
        return result;
    }
}
