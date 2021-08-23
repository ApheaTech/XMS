package com.aphea.xmssrv.service;

import com.aphea.xmssrv.pojo.UserInfo;
import com.aphea.xmssrv.pojo.UserInfoVO;

import java.util.List;
import java.util.Set;

public interface UserInfoService {
    boolean login(String account, String password);
    void logout();
    int addUser(UserInfo userInfo);
    int deleteUser(int id);
    int updateUser(UserInfo userInfo);
    List<UserInfoVO> getUserList(int start, int size);
    UserInfoVO getUserById(int id);
    UserInfoVO getUserByAcoount(String account);
    Set<String> getUserRole(int id);
}
