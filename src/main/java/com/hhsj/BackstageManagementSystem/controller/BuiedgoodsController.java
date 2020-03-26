package com.hhsj.BackstageManagementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhsj.BackstageManagementSystem.pojo.BuiedgoodsCustom;
import com.hhsj.BackstageManagementSystem.service.BuiedgoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JacksonYee on 2019/7/3.
 */
@Controller
public class BuiedgoodsController {
    @Resource
    BuiedgoodsService buiedgoodsService;

    //按条件查询
    @RequestMapping(value = "/goToIndentList")
    public String findIndentList(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, BuiedgoodsCustom bc) {
        PageHelper.startPage(pageNum,10);
        List<BuiedgoodsCustom> buiedgoodsCustoms = buiedgoodsService.selectAll(bc);
        PageInfo<BuiedgoodsCustom> pageInfo = new PageInfo<>(buiedgoodsCustoms);
        model.addAttribute("buiedgoodsCustoms", buiedgoodsCustoms);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("bc", bc);
        return "IndentList";
    }

    //按ID删除
    @ResponseBody
    @RequestMapping("/deleteById")
    public Object deleteById(int deleteId) throws Exception {
        int data = buiedgoodsService.deleteById(deleteId);
        return data;
    }

    //根据ID查找
    @ResponseBody
    @RequestMapping("/selectById")
    public Object selectById(int id) throws Exception {
        BuiedgoodsCustom data = buiedgoodsService.selectById(id);
        return data;
    }
    //修改订单状态
    @ResponseBody
    @RequestMapping("/updateState")
    public Object updateState(Integer id,Integer state)throws Exception{
        Map map=new HashMap<>();
        map.put("id",id);
        map.put("state",state);
        int data=buiedgoodsService.updateState(map);
        return data;
    }

}
