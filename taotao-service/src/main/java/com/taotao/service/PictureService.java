package com.taotao.service;

import com.taotao.common.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传service
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
public interface PictureService {
    /**
     * 图片上传
     * @param picFile
     * @return
     */
    PictureResult uploadPic(MultipartFile picFile);
}
