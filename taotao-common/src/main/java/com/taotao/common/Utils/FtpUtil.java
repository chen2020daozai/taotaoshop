package com.taotao.common.Utils;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName FTPUtil
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/4 下午6:31
 * @Version 1.0
 */
public class FtpUtil {
    private static ChannelSftp sftp = null;
//属性
//    //账号
//    private static String user = "ftpuser";
//    //主机ip
//    private static String host =  "192.168.78.128";
//    //密码
//    private static String password = "ftpuser";
//    //端口
//    private static int port = 22;
//    //上传地址
//    private static String directory = "/home/www/imgs";
//    //下载目录
//    private static String saveFile = "D:\\VMware\\XuNiJi\\imgs";
//, InputStream input
    public static boolean uploadFile(String host, int port, String username, String password, String localFile,
                                     String basePath, String filePath, String fileName) {
        boolean result = false;
        File file = null;
        try {
            JSch jsch = new JSch();

            //获取sshSession  账号-ip-端口
            Session sshSession = jsch.getSession(username, host, port);
            //添加密码
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            //严格主机密钥检查
            sshConfig.put("StrictHostKeyChecking", "no");

            sshSession.setConfig(sshConfig);
            //开启sshSession链接
            sshSession.connect();
            //获取sftp通道
            Channel channel = sshSession.openChannel("sftp");
            //开启
            channel.connect();
            sftp = (ChannelSftp) channel;
//文件上传到服务器的路径
            String path=basePath + filePath;
            try {
                sftp.cd(path);

            } catch (SftpException e) {
//创建路径
                sftp.mkdir(path);
                sftp.cd(path);

            }
            file = new File(localFile);
            sftp.put(new FileInputStream(file), fileName);
            channel.disconnect();//断开信道
            sshSession.disconnect();//断开ssh连接释放内存资源
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
