package com.aphea.xmssrv.config;


import com.aphea.xmssrv.pojo.UserInfoVO;
import com.aphea.xmssrv.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO
 *
 * @author 航
 * @date 2021/8/22 8:27
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        UserInfoVO user = this.userInfoService.getUserByAcoount((String) principalCollection.getPrimaryPrincipal());
        Set<String> userRoleSet = this.userInfoService.getUserRole(user.getId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(userRoleSet);

//        HashSet<String> perSet = new HashSet<>();
//        perSet.add("read");
//
//        info.setStringPermissions(perSet);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UserInfoVO user = this.userInfoService.getUserByAcoount((String) token.getPrincipal());
        if (user != null) {
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(), user.getPassword(), "CustomRealm");
            return info;
        } else {
            return null;
        }

    }
}
