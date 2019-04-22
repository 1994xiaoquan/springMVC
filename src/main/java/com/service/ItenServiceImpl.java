package com.service;

import com.dao.ItemsMapper;
import com.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//增加注解
@Service
public class ItenServiceImpl implements  ItemService {
    @Autowired
    private ItemsMapper itemsMapper;
    public List<Items> selectItems(){
        return itemsMapper.selectByExample(null);
    }

}
