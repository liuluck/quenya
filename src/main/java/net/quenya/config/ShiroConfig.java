package net.quenya.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //访问的是后端url地址为 /login的接口
        shiroFilterFactoryBean.setLoginUrl("/");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/templates/views/main");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/easyui/**", "anon");
        filterChainDefinitionMap.put("/imgs/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/style/**", "anon");

        filterChainDefinitionMap.put("/login/sign", "anon");

        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");

        //配置某个url需要某个权限码

        filterChainDefinitionMap.put("/hello", "perms[how_are_you]");

        // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/", "user");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }


     //* 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     //@return
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm myShiroRealm = new ShiroRealm();
        return myShiroRealm;
    }

}
