package com.taotao.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 *@ClassName testPagehelper
 *@Description TODO
 *@Author 陈刀仔
 *@Date 2020/2/25 21:10
 *@Version 1.0
 */


public class testPagehelper {
    @Test
    public void testphelp(){
        //创建spring容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //获取mapper代理对象
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
        //查询
        TbItemExample example=new TbItemExample();
        //分页处理
        PageHelper.startPage(1,10);
        List<TbItem> list = mapper.selectByExample(example);
        for (TbItem item:list
             ) {
            System.out.println(item.getTitle());
        }
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        long total = pageInfo.getTotal();
        System.out.println(total);
    }
}
