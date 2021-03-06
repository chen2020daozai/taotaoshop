package com.taotao.controller;

import com.taotao.commom.pojo.EUTreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName ItemCatController
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/2/28 10:29
 * @Version 1.0
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") long parentid){
        List<EUTreeNode> list = itemCatService.getItemCatList(parentid);
        return list;
    }
}


