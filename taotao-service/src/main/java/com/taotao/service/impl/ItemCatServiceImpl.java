package com.taotao.service.impl;

import com.taotao.common.TreeResult;
import com.taotao.dao.ItemCatMapper;
import com.taotao.pojo.ItemCat;
import com.taotao.pojo.ItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;
    @Override
    public List<TreeResult> getItemCatByParentId(Long parentId) {
        List<TreeResult> treeResults = null;
        ItemCatExample condition = new ItemCatExample();
        condition.createCriteria().andParentIdEqualTo(parentId);
        List<ItemCat> itemCats = itemCatMapper.selectByExample(condition);
        if (itemCats != null && !itemCats.isEmpty()){
            treeResults = new ArrayList<>();
            for (ItemCat itemCat : itemCats){
                TreeResult treeResult = new TreeResult();
                treeResult.setId(itemCat.getId());
                treeResult.setText(itemCat.getName());
                treeResult.setState(itemCat.getIsParent() ? "closed":"open");
                treeResults.add(treeResult);
            }
        }

        return treeResults;
    }
}
