package com.hhsj.BackstageManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

/**
 * Created by XiaoDu on 2019/6/26.
 */
@Controller
public class controller {
    @RequestMapping(value = "/index")
    public String show(Model model) {
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
    }

    @RequestMapping(value = "/SPLB")
    public String show1() {
        return "ProductList";
    }

    @RequestMapping(value = "/SY")
    public String shwo3() {
        return "index";
    }

    @RequestMapping(value = "/XGMM")
    public String updatePwdId() {
        return "ChangePassword";
    }
}
