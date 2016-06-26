package com.taotao.service.impl;

import com.taotao.common.PictureResult;
import com.taotao.common.utils.FastDFSClientUtil;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FASTDFS.SERVER.URL}")
    private String FASTDFS_SERVER_URL;
    /**
     * 图片上传
     *
     * @param picFile
     * @return
     */
    @Override
    public PictureResult uploadPic(MultipartFile picFile) {
        PictureResult pictureResult = new PictureResult();
        // 判断图片是否为null
        if (picFile.isEmpty()){
            pictureResult.setError(1);
            pictureResult.setMessage("图片为空");
        }
        // 上传图片到fastDFS服务器
        try {
            //取图片的扩展名
            String extName = picFile.getOriginalFilename().substring(picFile.getOriginalFilename().lastIndexOf(".") + 1);
            FastDFSClientUtil fastDFSClientUtil = new FastDFSClientUtil("classpath:client.conf");
            String path = fastDFSClientUtil.uploadFile(picFile.getBytes(),new Long(picFile.getSize()).intValue(),extName,null);
            pictureResult.setError(0);
            pictureResult.setUrl(FASTDFS_SERVER_URL + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pictureResult;
    }
}
