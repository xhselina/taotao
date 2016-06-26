package com.taotao.common.utils;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * fastDFS 工具类
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
public class FastDFSClientUtil {
    private TrackerClient trackerClient;
    private TrackerServer trackerServer;
    private StorageClient storageClient;
    private StorageServer storageServer;

    public FastDFSClientUtil(String conf) throws IOException, MyException {
        if (conf.contains("classpath:")){
            conf = conf.replaceAll("classpath:",this.getClass().getResource("/").getPath());
        }
        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = null;
        storageClient = new StorageClient(trackerServer,storageServer);
    }

    /**
     * 文件上传
     * @param fileName 文件路径
     * @param extName 扩展名
     * @param nameValuePairs 文件扩展属性
     * @return
     * @throws IOException
     * @throws MyException
     */
    public String uploadFile(String fileName, String extName, NameValuePair[] nameValuePairs) throws IOException, MyException {
        String[] fileInfo = storageClient.upload_file(fileName,extName,nameValuePairs);
        return fileInfo[0] + "/" + fileInfo[1];
    }

    public String uploadFile(byte[] content,int length,String extName,NameValuePair[] nameValuePairs) throws IOException, MyException {
        String[] fileInfo = storageClient.upload_file(content,0,length,extName,nameValuePairs);
        return fileInfo[0] + "/" + fileInfo[1];
    }

    /**
     * 文件下载
     * @param groupName
     * @param fileName
     * @return
     * @throws IOException
     * @throws MyException
     */
    public byte[] downLoad(String groupName,String fileName) throws IOException, MyException {
       return storageClient.download_file(groupName,fileName);
    }

    public static void main(String[] args) throws Exception{
        String filePath = "D:\\WorkSpace\\taotao-mananger\\taotao-common\\src\\main\\java\\com\\taotao\\common\\utils\\client.conf";
        FastDFSClientUtil fastDFSClientUtil = new FastDFSClientUtil(filePath);

        byte[] buffer = null;
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();

        String result = fastDFSClientUtil.uploadFile(buffer,buffer.length,"conf",null);
        System.out.println(result);

        byte[] downContext = fastDFSClientUtil.downLoad("group1","M00/00/00/wKhCblduqHSAaJM1AAAAIw4AKYc51.conf");
        System.out.println(new String(downContext));
    }
}
