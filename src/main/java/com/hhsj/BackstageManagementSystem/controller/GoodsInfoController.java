package com.hhsj.BackstageManagementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhsj.BackstageManagementSystem.pojo.GoodsInfoCutom;
import com.hhsj.BackstageManagementSystem.pojo.Goodsinfo;
import com.hhsj.BackstageManagementSystem.service.GoodsInfoService;
import com.hhsj.BackstageManagementSystem.service.UserinfoService;
import com.hhsj.BackstageManagementSystem.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by XiaoDu on 2019/6/30.
 */
@Controller
public class GoodsInfoController {
    @Resource
    private GoodsInfoService goodsInfoService;
    @Resource
    private UserinfoService userinfoService;

    /**
     * 查询所有审核商品信息
     *
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/findGoodsInfoAll")
    public String findGoodsInfoAll(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //pageNum为下标位置，后者为页面容量
        PageHelper.startPage(pageNum, 10);
        List<GoodsInfoCutom> goodsInfoAll = goodsInfoService.findGoodsInfoAll();
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GoodsInfoCutom> pageInfo = new PageInfo<GoodsInfoCutom>(goodsInfoAll);
        model.addAttribute("goodsInfoAll", goodsInfoAll);
        model.addAttribute("pageInfo", pageInfo);
        return "ReviewProduct";
    }

    /**
     * 按条件查询审核商品信息
     *
     * @param model
     * @param goodsInfoCutom
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/findGoodsInfo")
    public String findGoodsInfo(Model model, GoodsInfoCutom goodsInfoCutom,
                                @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, String Name,Integer type) {
        //pageNum为下标位置，后者为页面容量
        PageHelper.startPage(pageNum, 10);
//        goodsInfoCutom.setName(Name);
        String r=Name;
        String tt=  goodsInfoCutom.getName();
        List<GoodsInfoCutom> goodsInfo = goodsInfoService.findGoodsInfo(goodsInfoCutom);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GoodsInfoCutom> pageInfo = new PageInfo<GoodsInfoCutom>(goodsInfo);
        model.addAttribute("goodsInfoAll", goodsInfo);
        model.addAttribute("pageInfo", pageInfo);
        //把查询条件传到页面，实现回显
        model.addAttribute("Name", Name);
        model.addAttribute("type", type);
        return "ReviewProduct";
    }

    //记录点击的id值
    private Integer id1;

    /**
     * 按ID查看商品详情信息
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findGoodsInfoId")
    public GoodsInfoCutom findGoodsInfoId(GoodsInfoCutom id) {
        id1 = id.getId();
        GoodsInfoCutom goodsInfoId = goodsInfoService.findGoodsInfoId(id);
        return goodsInfoId;
    }

    /**
     * 审核商品信息
     *
     * @param goodsinfo
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/updateDisplay")
    public String updateDisplay(Goodsinfo goodsinfo) throws IOException {
        Integer i2 = id1;
        goodsinfo.setId(i2);
        int i = goodsInfoService.updateDisplay(goodsinfo);
        if (i == 1) {
            return "forward:/findGoodsInfoAll";
        } else {
            return "";
        }
    }

    /*以下是订单相关的代码*/

    @RequestMapping(value = "/IndentList")
    public String goToIndentList(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Goodsinfo> indentAll = goodsInfoService.findIndentAll();
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<Goodsinfo> pageInfo = new PageInfo<Goodsinfo>(indentAll);
        model.addAttribute("indentAll", indentAll);
        model.addAttribute("pageInfo", pageInfo);
        return "IndentList";
    }

    @RequestMapping(value = "/findIndentList")
    public String findIndentList(Model model, Goodsinfo goodsinfo
            , @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Goodsinfo> indentAll = goodsInfoService.findIndentList(goodsinfo);

        PageInfo<Goodsinfo> pageInfo = new PageInfo<Goodsinfo>(indentAll);
        model.addAttribute("indentAll", indentAll);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("Name", goodsinfo.getName());
        model.addAttribute("Id", goodsinfo.getId());
        model.addAttribute("Display", goodsinfo.getDisplay());
        return "IndentList";
    }

    @ResponseBody
    @RequestMapping(value = "/findIndentById")
    public Object findGoodsInfoId(int id) throws Exception {
        int s = id;
        System.out.println(s);
        Goodsinfo data = goodsInfoService.findById(id);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/UpdateGoodSale")
    public Object UpdateGoodSale(Goodsinfo goodsinfo) throws Exception {
        Integer id = goodsinfo.getId();
        Integer sales = goodsinfo.getDisplay();
        return goodsInfoService.UpdateGoodSale(goodsinfo);
    }


    /*以下是商品列表相关的代码*/


    @RequestMapping(value = "/findGoods")
    public String findGoods(Model model,
                            @RequestParam(defaultValue = "10") int display,
                            @RequestParam(defaultValue = "0") int type,
                            @RequestParam(defaultValue = "") String name,
                            @RequestParam(defaultValue = "1") int pageNum,
                            @RequestParam(defaultValue = "10") int pageSize) {
        List<GoodsInfoCutom> goods = goodsInfoService.findGoods(display, type, name, pageNum, pageSize);
        int count = goodsInfoService.findGoodCount(display, type, name);
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalCount(count);
        pageUtil.setPageNum(pageNum);
        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("goods", goods);
        model.addAttribute("display", display);
        model.addAttribute("type", type);
        model.addAttribute("name", name);
        return "ProductList";
    }


    @ResponseBody
    @RequestMapping(value = "/findGoodById")
    public Object findGoodById(@RequestParam(value = "id") Integer id) {
        GoodsInfoCutom custom = goodsInfoService.findGoodById(id);
        return custom;
    }

    @RequestMapping(value = "/updateGood")
    public String updateGood(GoodsInfoCutom custom, HttpSession session, String userName) {
        int uId = userinfoService.findUserIdByName(userName);
        custom.setModify(new Date());
        custom.setUid(uId);
        custom.setLevel(5);
        goodsInfoService.updateGood(custom);
        return "redirect:findGoods";
    }

    @RequestMapping(value = "/delGood")
    public String delGood(int id) {
        goodsInfoService.delGood(id);
        return "forward:findGoods";
    }

}
