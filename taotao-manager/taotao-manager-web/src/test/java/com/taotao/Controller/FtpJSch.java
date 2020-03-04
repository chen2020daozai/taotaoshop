package com.taotao.Controller;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.UUID;

/**
 * @ClassName FtpJSch
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/4 下午5:08
 * @Version 1.0
 */
public class FtpJSch {

    private static ChannelSftp sftp = null;
    //账号
    private static String user = "ftpuser";
    //主机ip
    private static String host = "192.168.171.128";
    //密码
    private static String password = "2242877026";
    //端口
    private static int port = 22;
    //上传地址
    private static String directory = "/home/ftpuser/index";
    //下载目录
    private static String saveFile = "E:\\定格\\矢量图\\git.png";

    @org.jetbrains.annotations.NotNull
    @Test
    public void getConnect() {
        FtpJSch ftp = new FtpJSch();
        File file = null;
        String fileName = null;
        try {
            JSch jsch = new JSch();

            //获取sshSession  账号-ip-端口
            Session sshSession = jsch.getSession(user, host, port);
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
            sftp.cd(directory);
            file = new File(saveFile);
            fileName = "hello1.jpg";
            sftp.put(new FileInputStream(file), fileName);
            channel.disconnect();//断开信道
            sshSession.disconnect();//断开ssh连接释放内存资源
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
