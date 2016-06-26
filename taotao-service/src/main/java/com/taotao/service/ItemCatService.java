package com.taotao.service;

import com.taotao.common.TreeResult;

import java.util.List;

/**
 * 目录接口列表
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
public interface ItemCatService {

    public List<TreeResult> getItemCatByParentId(Long parentId);

}
