package com.hhsj.BackstageManagementSystem.pojo;

/**
 * Created by JacksonYee on 2019/7/2.
 */
public class WantgoodsCustom extends Wantgoods{
    //商品类别
    public String gName;
    //求购人姓名
    public String UserName;

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
