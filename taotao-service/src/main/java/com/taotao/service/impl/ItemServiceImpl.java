package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.PageResult;
import com.taotao.dao.ItemMapper;
import com.taotao.pojo.Item;
import com.taotao.pojo.ItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public PageResult getItemList(int page, int rows) {
        // 用pageHelper开始分页
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(page,rows);
        // 查询结果
        ItemExample itemExample = new ItemExample();
        List<Item> items = itemMapper.selectByExample(itemExample);

        PageInfo<Item> pageInfo = new PageInfo<>(items);

        return new PageResult().setRows(pageInfo.getList()).setTotal(pageInfo.getTotal());
    }
}
