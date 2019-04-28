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
        if(items.getCreatetime()==null){
            items.setCreatetime(new Date());
        }

        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }
    @Override
    public void deleteItemById(Integer [] ids) {
        for (int i =0; i<ids.length;i++ ){
            itemsMapper.deleteByPrimaryKey(ids[i]);
        }

    }
    @Override
    public void updatesItemById(List<Items> itemsList) {
        for (int i =0; i<itemsList.size();i++ ){
            itemsMapper.updateByPrimaryKeyWithBLOBs(itemsList.get(i));
        }
    }
}
