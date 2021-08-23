package com.aphea.xmssrv.service;

import com.aphea.xmssrv.mapper.UserInfoMapper;
import com.aphea.xmssrv.pojo.UserInfo;
import com.aphea.xmssrv.pojo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * TODO
 *
 * @author 航
 * @date 2021/8/22 8:21
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public boolean login(String account, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        try {
            currentUser.login(token);
            log.info(this.userInfoMapper.getUserByAcoount(account).getFullName()+" 登录成功");
            return true;
        } catch (UnknownAccountException uae) {
            log.error("无 "+account+" 用户");
        } catch (IncorrectCredentialsException ice) {
            log.error("密码错误");
        } catch (LockedAccountException lae) {
            log.error("账户已锁定");
        } catch (Exception e) {
            log.error("登录其他错误");
        }

        return false;
    }

    @Override
    public void logout() {
        Subject currentUser = SecurityUtils.getSubject();
        String account = (String) currentUser.getPrincipal();

        currentUser.logout();

        log.info(this.userInfoMapper.getUserByAcoount(account).getFullName()+" 退出登录");
    }

    @Override
    public int addUser(UserInfo userInfo) {
        return this.userInfoMapper.addUser(userInfo);
    }

    @Override
    public int deleteUser(int id) {
        return this.userInfoMapper.deleteUser(id);
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        return this.userInfoMapper.updateUser(userInfo);
    }

    @Override
    public List<UserInfoVO> getUserList(int start, int size) {
        return this.userInfoMapper.getUserList(start, size);
    }

    @Override
    public UserInfoVO getUserById(int id) {
        return this.userInfoMapper.getUserById(id);
    }

    @Override
    public UserInfoVO getUserByAcoount(String account) {
        return this.userInfoMapper.getUserByAcoount(account);
    }

    @Override
    public Set<String> getUserRole(int id) {
        return this.userInfoMapper.getUserRole(id);
    }
}
