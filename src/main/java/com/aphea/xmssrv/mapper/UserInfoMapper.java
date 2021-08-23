package com.aphea.xmssrv.mapper;

import com.aphea.xmssrv.pojo.UserInfo;
import com.aphea.xmssrv.pojo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserInfoMapper {
    int addUser(UserInfo userInfo);
    int deleteUser(@Param("id") int id);
    int updateUser(UserInfo userInfo);
    List<UserInfoVO> getUserList(@Param("start") int start, @Param("size") int size);
    UserInfoVO getUserById(@Param("id") int id);
    UserInfoVO getUserByAcoount(@Param("account") String account);
    Set<String> getUserRole(@Param("userId") int userId);
}
