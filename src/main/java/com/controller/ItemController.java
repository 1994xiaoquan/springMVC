package com.controller;

import com.pojo.Items;
import com.pojo.QueryVo;
import com.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        mav.addObject("itemList",list);
        mav.setViewName("itemList");
        return mav;
    }
    @RequestMapping(value= "/item/itemEdit")
    public ModelAndView itemEdit(/*HttpServletRequest request , HttpServletResponse response , HttpSession session*/ Integer id , Model model){
        //传统方式接受参数
        //1 .String id = request.getParameter("id");
        //2.通过参数直接接受 简单类型参数
        //通过id查询
        Items  item =  itemService.selectItemsById(id);
        ModelAndView  mav = new ModelAndView();
        mav.addObject("item",item);
        mav.setViewName("editItem");
        return mav;
    }
    @RequestMapping(value = "/item/updateitem")
//    public ModelAndView itemUpdateById(Items items ){
    public ModelAndView itemUpdateById(QueryVo queryVo){
        System.out.println(queryVo.getItems().toString());
        itemService.updateItemById(queryVo.getItems());
        ModelAndView  mav = new ModelAndView();
        mav.setViewName("itemList");
        return mav;
    }

}
