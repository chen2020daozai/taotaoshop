package com.taotao.Controller;

import com.taotao.common.Utils.FtpUtil;
import org.junit.Test;

/**
 * @ClassName testFTP
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/3 下午7:41
 * @Version 1.0
 */
public class testFtp {
//    @Test
//    public void testFtpClient() throws IOException {
//        //创建一个ftpClient对象
//        FTPClient client=new FTPClient();
//        //创建ftp连接
//        client.connect("192.168.171.128",22);
//        //登录ftp服务器
//        client.login("ftpuser","2242877026");
//        //上传文件
//        //本地文件
//        FileInputStream local=new FileInputStream(new File("E:\\定格\\矢量图\\git.png"));
//        //远程路径
//        client.changeWorkingDirectory("/home/ftpuser/index");
//        client.storeFile("git.png",local);
//        //关闭连接
//        client.logout();
//    }
    @Test
    public void testFtpUtil() throws Exception{

        FtpUtil.uploadFile("192.168.171.128",22,"ftpuser","2242877026",
                "E:\\定格\\矢量图\\git.png","/home/ftpuser/index","/0304","hello.png");
    }
}
