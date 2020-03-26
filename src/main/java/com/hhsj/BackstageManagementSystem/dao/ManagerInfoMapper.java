package com.hhsj.BackstageManagementSystem.dao;

import com.hhsj.BackstageManagementSystem.pojo.ManagerInfo;

import java.util.List;

/**
 * Created by XiaoDu on 2019/6/26.
 */
public interface ManagerInfoMapper {
    /**
     * 登录功能
     *
     * @param managerInfo
     * @return
     */
    ManagerInfo findManagerinfo(ManagerInfo managerInfo);

    /**
     * 查询个人信息功能
     *
     * @param id
     * @return
     */
    List<ManagerInfo> findManagerinfoId(Integer id);

    /**
     * 修改管理员密码
     *
     * @param managerInfo
     * @return
     */
    int updatePwdId(ManagerInfo managerInfo);

}
