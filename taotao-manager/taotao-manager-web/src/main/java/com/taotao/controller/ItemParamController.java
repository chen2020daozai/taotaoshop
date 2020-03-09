package com.taotao.controller;

import com.taotao.commom.pojo.EUDataGridResult;
import com.taotao.commom.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName itemParamController
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/8 下午8:56
 * @Version 1.0
 */

@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/item/param/list")
    @ResponseBody
    public EUDataGridResult getItemParamList(Integer page,Integer rows){
        EUDataGridResult result = itemParamService.getItemParamList(page, rows);
        return result;
    }

    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult getItemParamByCid(@PathVariable long itemCatId){
//        下面这个getParamCid是service层，因为itemParamService是service层
        TaotaoResult result = itemParamService.getParamCid(itemCatId);
        return result;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
//    从路径中取cid
    public TaotaoResult insertItemParem(@PathVariable long cid,String paramData){
        //创建pojo对象操作Controller层，在这就是itemParam
        TbItemParam itemParam=new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
//        不用传creat  update因为那个在service层
        TaotaoResult result = itemParamService.insertIemParam(itemParam);
        return result;
    }

}
