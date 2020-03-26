package com.hhsj.BackstageManagementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhsj.BackstageManagementSystem.pojo.Userinfo;
import com.hhsj.BackstageManagementSystem.service.UserinfoService;
import com.hhsj.BackstageManagementSystem.util.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 12789 on 2019/7/1.
 */
@Controller
public class UserinfoController {
    @Resource
    private UserinfoService userinfoService;

    /*
    首页分页查询根据昵称QQ手机号模糊查询还有状态查询
     */
    @RequestMapping(value = "/UserList")
    public String findUserList(Userinfo userinfo, Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) throws Exception {
        //pageNum为下标位置，后者为页面容量
        PageHelper.startPage(pageNum, 10);
        List<Userinfo> userinfoList;
        if (userinfo == null) {
            userinfoList = userinfoService.findUserList(null);
        } else {
            userinfoList = userinfoService.findUserList(userinfo);
        }
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<Userinfo> pageInfo = new PageInfo<Userinfo>(userinfoList);
        model.addAttribute("userList", userinfoList);
        model.addAttribute("pageInfo", pageInfo);
        //把查询条件传到页面，实现回显
        model.addAttribute("phone", userinfo.getPhone());
        model.addAttribute("userName", userinfo.getUserName());
        model.addAttribute("qq", userinfo.getQq());
        model.addAttribute("status", userinfo.getStatus());
        return "UserList";
    }

    /*
    查看用户详情
     */
    private Integer id1;

    @ResponseBody
    @RequestMapping(value = "/findUser")
    public Object findUser(Integer id) throws Exception {
        id1 = id;
        Userinfo user = userinfoService.findUser(id1);
        return user;
    }

    /*
    修改用户状态
     */
    @RequestMapping(value = "UpdateUserinfo")
    public String UpdateUserinfo(Userinfo userinfo) throws Exception {
        Integer id = id1;
        userinfo.setId(id);
        Date date = new Date();//获取当前系统时间
        if (userinfo.getStatus() == 1) {
            userinfo.setDateTime(DateTime.getNextDay(date, 36500));//禁用100年
        }
        if (userinfo.getStatus() == 2) {
            userinfo.setStatus(1);
            userinfo.setDateTime(DateTime.getNextDay(date, 1));//禁用1天
        }
        if (userinfo.getStatus() == 3) {
            userinfo.setStatus(1);
            userinfo.setDateTime(DateTime.getNextDay(date, 3));//禁用3天
        }
        if (userinfo.getStatus() == 4) {
            userinfo.setStatus(1);
            userinfo.setDateTime(DateTime.getNextDay(date, 7));
        }
        if (userinfo.getStatus() == 5) {
            userinfo.setStatus(1);
            userinfo.setDateTime(DateTime.getNextDay(date, 30));
        }
        if (userinfo.getStatus() == 6) {
            userinfo.setDateTime(DateTime.getNextDay(date, 90));
            userinfo.setStatus(1);
        }
        if (userinfo.getStatus() == 7) {
            userinfo.setStatus(1);
            userinfo.setDateTime(DateTime.getNextDay(date, 365));
        }
        if (userinfo.getStatus() == 0) {
            userinfo.setDateTime(new Date());
        }
        int i = userinfoService.UpdateUserinfo(userinfo);
        if (i == 1) {
            return "redirect:UserList";
        } else {
            return "findUserId";
        }
    }
}
