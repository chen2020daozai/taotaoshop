package com.taotao.controller;

import com.taotao.commom.pojo.EUDataGridResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**页面跳转Controller
 * Create by 陈刀仔 at 19:49 on 2020/2/24
 */

/**
 * springmvc有前缀后缀，只需要“index”字符串就行
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }


}
