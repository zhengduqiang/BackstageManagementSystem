package com.hhsj.BackstageManagementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhsj.BackstageManagementSystem.pojo.WantgoodsCustom;
import com.hhsj.BackstageManagementSystem.service.WantGoodsService;
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
 * Created by JacksonYee on 2019/7/2.
 */
@Controller
public class PurchaseInformationController {
    @Resource(name = "WantGoodsService")
    WantGoodsService wantGoodsService;

    //    按条件查询
    @RequestMapping("/gotoPurchaseInformation")
    public String goToPurchaseInformation(Model model, String UserName, String gName, String wName, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        Map map = new HashMap<>();
        map.put("UserName", UserName);
        map.put("gName", gName);
        map.put("wName", wName);
        PageHelper.startPage(pageNum, 10);
        List<WantgoodsCustom> wantgoodses = wantGoodsService.selectWantGoodList(map);
        PageInfo<WantgoodsCustom> pageInfo = new PageInfo<WantgoodsCustom>(wantgoodses);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("wantgoodses", wantgoodses);
        model.addAttribute("UserName", UserName);
        model.addAttribute("gName", gName);
        model.addAttribute("wName", wName);
        return "PurchaseInformation";
    }

    //按ID删除
    @ResponseBody
    @RequestMapping("/deleteWantGoodById")
    public Object deleteWantGoodById(Integer deleteId, Integer wid) throws Exception {
        int result = 0;
        int i = wantGoodsService.deleteMywantgood(deleteId);
        int i2 = wantGoodsService.deleteWantgoodsMessage(deleteId);
        int i3 = wantGoodsService.deleteWantGoodById(deleteId);
        if (i3 == 1) {
            result = 1;
        }
        return result;
    }
}
