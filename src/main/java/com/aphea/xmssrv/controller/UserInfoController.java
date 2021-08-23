package com.aphea.xmssrv.controller;

import com.aphea.xmssrv.pojo.UserInfo;
import com.aphea.xmssrv.pojo.UserInfoVO;
import com.aphea.xmssrv.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author 航
 * @date 2021/8/22 8:20
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/login/{account}/{password}", method = RequestMethod.GET)
    public boolean login(@PathVariable("account") String account, @PathVariable("password") String password) {
        return this.userInfoService.login(account, password);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout() {
        this.userInfoService.logout();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int addUser(@RequestBody UserInfo userInfo) {
        return this.userInfoService.addUser(userInfo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable("id") int id) {
        return this.userInfoService.deleteUser(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public int updateUser(@RequestBody UserInfo userInfo) {
        return this.userInfoService.updateUser(userInfo);
    }

    @RequiresRoles("super_admin")
    @RequestMapping(value = "/list/{start}/{size}", method = RequestMethod.GET)
    public List<UserInfoVO> getUserList(@PathVariable("start") int start, @PathVariable("size") int size) {
        return this.userInfoService.getUserList(start, size);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public UserInfoVO getUserById(@PathVariable("id") int id) {
        return this.userInfoService.getUserById(id);
    }

    @RequestMapping(value = "/account/{account}", method = RequestMethod.GET)
    public UserInfoVO getUserByAcoount(@PathVariable("account") String account) {
        return this.userInfoService.getUserByAcoount(account);
    }
}
