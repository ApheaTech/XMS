package com.aphea.xmssrv.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * TODO
 *
 * @author 航
 * @date 2021/8/22 8:23
 */
@Configuration
public class ShiroConfig {

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        LinkedHashMap<String , String > filterMap = new LinkedHashMap<>();
        filterMap.put("/user/login/**", "anon");
        filterMap.put("/**", "authc");

        factoryBean.setFilterChainDefinitionMap(filterMap);

        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager getSecurityManager(Realm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }

    @Bean
    public Realm customRealm() {
        return new CustomRealm();
    }
}
