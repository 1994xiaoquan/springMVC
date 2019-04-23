package com.service;

import com.dao.ItemsMapper;
import com.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


//增加注解
@Service
public class ItenServiceImpl implements  ItemService {
    @Autowired
    private ItemsMapper itemsMapper;
    public List<Items> selectItems(){
        return itemsMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public Items selectItemsById(Integer id) {
        return itemsMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public void updateItemById(Items items) {
        items.setCreatetime(new Date());
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }
}
