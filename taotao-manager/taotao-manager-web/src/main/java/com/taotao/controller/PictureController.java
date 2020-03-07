package com.taotao.controller;

import com.taotao.common.Utils.JsonUtils;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @ClassName PictureController
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/5 下午8:15
 * @Version 1.0
 */

@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody

    public String pictureUpload(MultipartFile uploadFile){
        Map result=pictureService.uploadPicture(uploadFile);
//object类型转换成String类型，提高程序兼容性，因为有的浏览器可能不识别object
        String json=JsonUtils.objectToJson(result);
        return json;
    }
}
