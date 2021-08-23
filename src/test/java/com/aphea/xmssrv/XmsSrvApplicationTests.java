package com.aphea.xmssrv;

import com.aphea.xmssrv.mapper.UserInfoMapper;
import com.aphea.xmssrv.pojo.UserInfoVO;
import com.aphea.xmssrv.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
class XmsSrvApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test01() {
        this.userInfoService.login("xuhang1", "123456");
    }

    @Autowired
    UserInfoService userInfoService;

    @Test
    void test02() {
        List<UserInfoVO> userList = this.userInfoService.getUserList(0, 10);
        for (UserInfoVO userInfoVO:
             userList) {
            System.out.println(userInfoVO);
        }
        System.out.println(userList);
    }

    @Test
    void test03() {
        UserInfoVO user = this.userInfoService.getUserByAcoount("xuhang1");
        System.out.println(user);
    }

    @Test
    void test04() {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("libai", "123456"));
        System.out.println(subject.hasRole("4"));
    }

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    void test05() {
//        List<Integer> userRoles = this.userInfoService.getUserRole(1);
//        for (Integer userRole : userRoles) {
//            System.out.println(userRole.toString());
//        }
        Set<String> userRole = this.userInfoMapper.getUserRole(1);
        System.out.println(userRole);
    }
}
