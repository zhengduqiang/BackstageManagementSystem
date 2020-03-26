package com.hhsj.BackstageManagementSystem.dao;

import com.hhsj.BackstageManagementSystem.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfoMapper {
    List<Userinfo> findUserList(Userinfo userinfo) throws Exception;

    Userinfo findUser(@Param(value = "id") Integer id) throws Exception;

    int updateUserinfo(Userinfo userinfo) throws Exception;

    //根据用户姓名查询用户id
    int findUserIdByName(@Param("userName") String userName);
}