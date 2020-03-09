package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @ClassName PictureService
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/5 下午3:51
 * @Version 1.0
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
