package com.hhsj.BackstageManagementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhsj.BackstageManagementSystem.pojo.GoodsmessageCutom;
import com.hhsj.BackstageManagementSystem.service.GoodsmessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by XiaoDu on 2019/7/3.
 */
@Controller
public class GoodsmessageController {
    @Resource
    private GoodsmessageService goodsmessageService;

    /**
     * 查询所有用户评论
     *
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/findGoodsMessageList")
    public String findGoodsMessageList(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //pageNum为下标位置，后者为页面容量
        PageHelper.startPage(pageNum, 10);
        List<GoodsmessageCutom> goodsMessageList = goodsmessageService.findGoodsMessageList();
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GoodsmessageCutom> pageInfo = new PageInfo<GoodsmessageCutom>(goodsMessageList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("goodsMessageAll", goodsMessageList);
        return "UserCommentList";
    }

    @RequestMapping("/findGoodsMessage")
    public String findGoodsMessageList1(Model model, GoodsmessageCutom goodsmessageCutom, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //pageNum为下标位置，后者为页面容量
        PageHelper.startPage(pageNum, 10);
        List<GoodsmessageCutom> goodsMessageList = goodsmessageService.findGoodsMessage(goodsmessageCutom);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GoodsmessageCutom> pageInfo = new PageInfo<GoodsmessageCutom>(goodsMessageList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("goodsMessageAll", goodsMessageList);
        //把查询条件传到页面，实现回显
        model.addAttribute("content", goodsmessageCutom.getContent());
        model.addAttribute("name", goodsmessageCutom.getName());
        model.addAttribute("type", goodsmessageCutom.getType());
        return "UserCommentList";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteGoodsMessageId")
    public Object deleteGoodsMessageId(Integer id) {
        int i = goodsmessageService.deleteGoodsMessageId(id);
        return i;
    }
}
