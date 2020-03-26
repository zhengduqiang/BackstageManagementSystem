package com.hhsj.BackstageManagementSystem.service;

import com.hhsj.BackstageManagementSystem.dao.ManagerInfoMapper;
import com.hhsj.BackstageManagementSystem.pojo.ManagerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by XiaoDu on 2019/6/26.
 */
@Service
public class ManagerInfoService {
    @Resource
    private ManagerInfoMapper managerInfoMapper;

    /**
     * 登录功能
     *
     * @param managerInfo
     * @return
     */
    public ManagerInfo findManagerinfo(ManagerInfo managerInfo) {
        ManagerInfo managerinfo = managerInfoMapper.findManagerinfo(managerInfo);
        return managerinfo;
    }

    /**
     * 查看个人信息功能
     *
     * @param id
     * @return
     */
    public List<ManagerInfo> findManagerinfoId(Integer id) {
        List<ManagerInfo> managerinfoId = managerInfoMapper.findManagerinfoId(id);
        return managerinfoId;
    }

    public int updatePwdId(ManagerInfo managerInfo) {
        int i = managerInfoMapper.updatePwdId(managerInfo);
        return i;
    }
}
