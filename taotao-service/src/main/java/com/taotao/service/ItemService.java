package com.taotao.service;

import com.taotao.common.PageResult;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.Item;

/**
 * 商品列表接口
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
public interface ItemService {
    public PageResult getItemList(int page,int rows);

    /**
     * 添加商品和商品描述
     * @param item
     * @param desc
     * @return
     */
    public TaotaoResult saveItem(Item item,String desc);
}
