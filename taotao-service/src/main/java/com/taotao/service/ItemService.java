package com.taotao.service;

import com.taotao.common.PageResult;

/**
 * 商品列表接口
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
public interface ItemService {
    public PageResult getItemList(int page,int rows);
}
