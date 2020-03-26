package com.hhsj.BackstageManagementSystem.controller;

import com.hhsj.BackstageManagementSystem.pojo.ManagerInfo;
import com.hhsj.BackstageManagementSystem.service.ManagerInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

/**
 * Created by XiaoDu on 2019/6/26.
 */
@Controller
public class ManagerInfoController {

    @Resource
    private ManagerInfoService managerInfoService;

    /**
     * 登录功能
     *
     * @param managerInfo
     * @param session
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/findLogin")
    public String index(ManagerInfo managerInfo, HttpSession session, Model model, HttpServletRequest request) {
        ManagerInfo managerinfo2 = managerInfoService.findManagerinfo(managerInfo);
        if (managerinfo2 != null) {
            session.setAttribute("managerList", managerinfo2);
            return "index";
        } else {
            int n = 4;
            String string = "a2b3cd4ef5ghij6kl7mnop8qrst1uvwxy9z";//保存数字0-9 和 大小写字母
            char[] ch = new char[n]; //声明一个字符数组对象ch 保存 验证码
            for (int i = 0; i < n; i++) {
                Random random = new Random();//创建一个新的随机数生成器
                int index = random.nextInt(string.length());//返回[0,string.length)范围的int值    作用：保存下标
                ch[i] = string.charAt(index);//charAt() : 返回指定索引处的 char 值   ==》保存到字符数组对象ch里面
            }
            //将char数组类型转换为String类型保存到result
            //String result = new String(ch);//方法一：直接使用构造方法      String(char[] value) ：分配一个新的 String，使其表示字符数组参数中当前包含的字符序列。
            String result = String.valueOf(ch);//方法二： String方法   valueOf(char c) ：返回 char 参数的字符串表示形式。
            model.addAttribute("yzm", result);
            request.setAttribute("dlsb", "账号或密码错误请重新登录！");
            return "login";
        }
    }

    /**
     * 查询个人信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/findManagerinfoId")
    public String findManagerinfoId(Integer id, Model model) {
        List<ManagerInfo> managerinfoId = managerInfoService.findManagerinfoId(id);
        model.addAttribute("managerinfo", managerinfoId);
        return "PersonalInformation";
    }


    /**
     * 修改用户密码
     *
     * @param managerInfo
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/updatePwdId")
    public String updatePwdId(ManagerInfo managerInfo, Model model, HttpSession session) {
        int i2 = managerInfoService.updatePwdId(managerInfo);
        if (i2 == 1) {
            //修改密码成功清空session
            session.invalidate();
            //跳转login页面并且进行修改密码成功提示。
            model.addAttribute("xgcg", "修改密码成功，请重新登录");
            int n = 4;
            String string = "a2b3cd4ef5ghij6kl7mnop8qrst1uvwxy9z";//保存数字0-9 和 大小写字母
            char[] ch = new char[n]; //声明一个字符数组对象ch 保存 验证码
            for (int i = 0; i < n; i++) {
                Random random = new Random();//创建一个新的随机数生成器
                int index = random.nextInt(string.length());//返回[0,string.length)范围的int值    作用：保存下标
                ch[i] = string.charAt(index);//charAt() : 返回指定索引处的 char 值   ==》保存到字符数组对象ch里面
            }
            //将char数组类型转换为String类型保存到result
            //String result = new String(ch);//方法一：直接使用构造方法      String(char[] value) ：分配一个新的 String，使其表示字符数组参数中当前包含的字符序列。
            String result = String.valueOf(ch);//方法二： String方法   valueOf(char c) ：返回 char 参数的字符串表示形式。
            model.addAttribute("yzm", result);
            return "login";
        } else {
            //修改密码失败刷新页面并给出提示。
            model.addAttribute("xgsb", "修改密码失败，原密码输入错误！");
            return "ChangePassword";
        }
    }
}
