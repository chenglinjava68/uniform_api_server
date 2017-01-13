package com.dos.bsapp.conf;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class ShiroConfiguration {

    @Autowired
    private ShiroFilterProperties sp;

     /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
        Filter Chain定义说明
       1、一个URL可以配置多个Filter，使用逗号分隔
       2、当设置多个过滤器时，全部验证通过，才视为通过
       3、部分过滤器可指定参数，如perms，roles
     *
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
       System.out.println("ShiroConfiguration.shirFilter()");
       ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
       shiroFilterFactoryBean.setSecurityManager(securityManager);



       //拦截器.
       Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

       //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
       filterChainDefinitionMap.put("/logout", "logout");

       //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->

       //filterChainDefinitionMap.put("/api/web/*", "authc");
       //filterChainDefinitionMap.put("/mappings", "authc");
        filterChainDefinitionMap.putAll(sp.getFilters());
       // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/need_login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

       shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
       return shiroFilterFactoryBean;
    }


    @Bean
    public SecurityManager securityManager(){
       DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
       securityManager.setRealm((new com.dos.bsapp.shiro.ShiroDbRealm()).setUserService(new com.dos.bsapp.shiro.ShiroUserService()));
       return securityManager;
    }
}


/*
http://412887952-qq-com.iteye.com/blog/2299777
http://412887952-qq-com.iteye.com/blog/2299780
http://412887952-qq-com.iteye.com/blog/2299784
http://412887952-qq-com.iteye.com/blog/2295146

a. Spring-boot connect shiro

b. Spring-boot connect redis
c. Shiro session and cache -> redis
http://www.cnblogs.com/jiangkuan/p/6189136.html
http://www.cnblogs.com/sunshine-2015/p/5686750.html
*/