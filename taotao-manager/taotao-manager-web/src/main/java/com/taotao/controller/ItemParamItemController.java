package com.taotao.controller;

import com.taotao.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName ItemParamItemController
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/10 下午2:49
 * @Version 1.0
 */

@Controller
public class ItemParamItemController {

    @Autowired
    private ItemParamItemService itemParamItemService;

    @RequestMapping("/showParam/{id}")
    @ResponseBody
//    这个字符串是一个逻辑视图
//    这个字符串要传递给jsp所以用Model
    public String showParam(@PathVariable long id) {
        String string = itemParamItemService.showItemParam(id);
        //itemParam传递给item.jsp
        ModelAndView model=new ModelAndView();
        model.setViewName("item");
        model.addObject("itemParam",string);
        return string;
    }
}
