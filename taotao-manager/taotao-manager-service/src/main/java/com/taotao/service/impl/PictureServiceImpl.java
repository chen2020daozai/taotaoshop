package com.taotao.service.impl;

import com.taotao.common.Utils.FtpUtil;
import com.taotao.common.Utils.IDUtils;
import com.taotao.service.PictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PictureServiceImpl
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/5 下午3:53
 * @Version 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {
    //    spring 容器自动注入值
    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USER_NAME}")
    private String FTP_USER_NAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public Map uploadPicture(MultipartFile uploadFile) {
//        什么意思
        Map resultMap = new HashMap<>();
        try {
            String oldName = uploadFile.getOriginalFilename();
            String newName = IDUtils.genImageName();
//        加上扩展名
            newName += oldName.substring(oldName.lastIndexOf("."));
            //图片上传
            String filePath = new DateTime().toString("/yyyy/MM/dd");
            System.out.println(filePath);
            boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, FTP_BASE_PATH,
                    filePath, newName, (FileInputStream) uploadFile.getInputStream());
            System.out.println(result);
            if (!result) {
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传失败");
                return resultMap;
            }
            resultMap.put("error", 0);
            resultMap.put("url", IMAGE_BASE_URL + filePath + "/" + newName);
            return resultMap;
        } catch (Exception e) {
            resultMap.put("error", 1);
            resultMap.put("message", "出错");
            return resultMap;
        }

    }
}
