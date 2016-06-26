package com.taotao.controller;

import com.taotao.common.PageResult;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.Item;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    /**
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public PageResult getItemList(Integer page,Integer rows){// Integer 可以为null
        return  itemService.getItemList(page,rows);
    }

    @RequestMapping("/item/save")
    @ResponseBody
    public TaotaoResult saveItem(Item item,String desc){
        return itemService.saveItem(item,desc);
    }
}
