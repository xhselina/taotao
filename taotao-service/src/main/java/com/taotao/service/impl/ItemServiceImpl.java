package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.PageResult;
import com.taotao.common.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.dao.ItemDescMapper;
import com.taotao.dao.ItemMapper;
import com.taotao.pojo.Item;
import com.taotao.pojo.ItemDesc;
import com.taotao.pojo.ItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private ItemDescMapper itemDescMapper;

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

    /**
     * 添加商品和商品描述
     *
     * @param item
     * @param desc
     * @return
     */
    @Override
    public TaotaoResult saveItem(Item item, String desc) {
        Long itemId = IDUtils.genItemId();
        item.setId(itemId);
        // '商品状态，1-正常，2-下架，3-删除'
        item.setStatus((byte)1 );
        // 创建时间和更新时间
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        itemMapper.insert(item);
        // 商品描述
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        // 插入商品描述数据
        itemDescMapper.insert(itemDesc);

        return TaotaoResult.ok();
    }
}
