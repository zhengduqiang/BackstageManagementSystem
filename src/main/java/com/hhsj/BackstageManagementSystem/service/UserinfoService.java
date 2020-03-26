package com.hhsj.BackstageManagementSystem.service;

import com.hhsj.BackstageManagementSystem.dao.UserinfoMapper;
import com.hhsj.BackstageManagementSystem.pojo.Userinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 12789 on 2019/7/1.
 */
@Service
public class UserinfoService {
    @Resource
    private UserinfoMapper userinfoMapper;

    public List<Userinfo> findUserList(Userinfo userinfo) throws Exception {
        List<Userinfo> user = userinfoMapper.findUserList(userinfo);
        return user;
    }

    public Userinfo findUser(Integer id) throws Exception {
        Userinfo user = userinfoMapper.findUser(id);
        return user;
    }

    public int UpdateUserinfo(Userinfo userinfo) throws Exception {
        int i = userinfoMapper.updateUserinfo(userinfo);
        return i;
    }

    public int findUserIdByName(String userName) {
        return userinfoMapper.findUserIdByName(userName);
    }
}
