package com.itany.conf;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.LinkedHashMap;

/**
 * Author:wenlixu
 * Date:2019/4/12 10:17
 * Description:
 * Version:1.0
 */
@Configuration
public class ShiroConfig {

    /**
     * 配置shiro过滤器
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            @Qualifier("securityManager") SecurityManager securityManager){

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        //设置登陆失败后跳转的页面
        bean.setLoginUrl("/manager/login");
        //设置认证失败后跳转的页面
        bean.setUnauthorizedUrl("/manager/login");

        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        //权限url 和 permission中的sname
        map.put("/manager/bookList","authc,perms[manager:bookList]");
        map.put("/manager/supplierExamine","authc,perms[manager:supplierExamine]");
        map.put("/manager/supplierPlatform","authc,perms[manager:supplierPlatform]");
        map.put("/manager/permission","authc,perms[manager:permission]");
        map.put("/manager/role","authc,perms[manager:role]");
        map.put("/manager/manager","authc,perms[manager:manager]");


        bean.setFilterChainDefinitionMap(map);
        return bean;
    }

    @Bean(name = "securityManager")
    public SecurityManager securityManager(@Qualifier("jdbcRealm") JdbcRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean(name = "jdbcRealm")
    public JdbcRealm authRealm(@Qualifier("dataSource") DataSource dataSource){
        System.out.println("----------jdbcRealm----------");
        JdbcRealm realm = new JdbcRealm();
        System.out.println("----------jdbcRealm已加载------");


        String authenticationSql = new StringBuffer()
                .append(" select ")
                .append("   password ")
                .append(" from  ")
                .append("   t_manager_user ")
                .append(" where ")
                .append("   username = ? ")
                .toString();

        String roleSql = new StringBuffer()
                .append(" select ")
                .append("   r.name ")
                .append(" from ")
                .append("   t_role r ")
                .append(" left join ")
                .append("   t_user_role ur ")
                .append(" on  ")
                .append("   ur.roleid = r.id ")
                .append(" left join ")
                .append("   t_manager_user u ")
                .append(" on ")
                .append("   u.id = ur.userid ")
                .append(" where ")
                .append("   u.username = ? ")
                .toString();

        String permissionSql = new StringBuffer()
                .append(" select ")
                .append("   p.sname ")
                .append(" from ")
                .append("   t_permission p ")
                .append(" left join ")
                .append("   t_role_permission rp ")
                .append(" on  ")
                .append("   rp.permissionid = p.id ")
                .append(" left join ")
                .append("   t_role r ")
                .append(" on ")
                .append("   r.id = rp.roleid ")
                .append(" where ")
                .append("   r.name = ? ")
                .toString();


        //设置数据源
        realm.setDataSource(dataSource);
        //设置权限查找可见？？
        realm.setPermissionsLookupEnabled(true);
        realm.setAuthenticationQuery(authenticationSql);
        realm.setUserRolesQuery(roleSql);
        realm.setPermissionsQuery(permissionSql);

        return realm;
    }



}
