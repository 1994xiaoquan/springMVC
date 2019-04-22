package com.controller;

import com.pojo.Items;
import com.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping(value = "/item/itemlist.action")
    public ModelAndView itemList(){
        ModelAndView  mav = new ModelAndView();
        // 创建页面需要显示的商品数据
        List<Items> list = new ArrayList<Items>();
        //数据库中读取list
        list = itemService.selectItems();
        mav.addObject("itemList",list);
        mav.setViewName("itemList");
        return mav;
    }
}
