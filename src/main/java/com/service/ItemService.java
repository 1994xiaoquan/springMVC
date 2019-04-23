package com.service;

import com.pojo.Items;

import java.util.List;

public interface ItemService {
    public List<Items> selectItems();
    public Items selectItemsById(Integer id);
    public void updateItemById(Items items);
    public void deleteItemById(Integer [] ids);
}
