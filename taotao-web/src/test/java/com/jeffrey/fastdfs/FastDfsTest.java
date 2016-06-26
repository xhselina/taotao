package com.jeffrey.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import javax.sound.midi.Track;
import java.io.IOException;

/**
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
public class FastDfsTest {
    public static void main(String[] args) throws Exception {
        fastDfsTest();
    }
    public static void fastDfsTest() throws IOException, MyException {
        ClientGlobal.init("D:\\WorkSpace\\taotao-mananger\\taotao-web\\target\\test-classes\\client.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        String[] strs = storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\QQ图片20160625211111.jpg","jpg",null);
        for (String str : strs){
            System.out.println(str);
        }
    }
}
