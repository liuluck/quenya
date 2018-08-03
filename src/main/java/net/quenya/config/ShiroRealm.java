package net.quenya.config;

import net.quenya.model.entity.Menu;
import net.quenya.model.entity.Role;
import net.quenya.model.entity.User;
import net.quenya.service.MenuService;
import net.quenya.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    MenuService menuService;
    /**
     * 为当前登录的Subject授予角色和权限 经测试:本例中该方法的调用时机为需授权资源被访问时
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        User user = (User)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        User userDB = userService.getUserByLoginName(user.loginName);

        List<String> roleNameList = new ArrayList<String>();

        List<Role> roleList = userDB.getRoleList();
        List<String> permissionList = new ArrayList<String>();
        /* 构建用户的角色集合 */
        for (Role role : roleList) {
            roleNameList.add(role.getRoleName());
            info.addRoles(roleNameList);
            String menus = role.getMenus();
            List<Menu> menuList = menuService.getMenuByIds(menus);
//			List<Menu> menuList = menuService.selectMenuByRoleId(role.getId());

            /* 构建用户的权限代码集合 */
            for (Menu menu : menuList) {
                if (!menu.getPermission().isEmpty()) {
                    permissionList.add(menu.getPermission());
                }
            }
        }
        info.addStringPermissions(permissionList);
        return info;
    }

    /**
     * 验证当前登录的Subject
     * 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        String brand="";
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        System.out.println(token.toString());
        String userName = token.getUsername();
        User user = userService.getUserByLoginName(userName);
        if(brand!=null && !brand.equals("")){
            setSession("brand", brand);
            //System.out.println("brand:"+brand);
        }
        if (user != null && user.isEnabled()) {
            setSession("id", user.getId());
            setSession("username", userName);

            return new SimpleAuthenticationInfo(user, user.password, getName());
        }
        return null;

    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            //session.setTimeout(1800000);
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            session.setAttribute(key, value);
        }
    }

    private User getUser() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        //User user = (User) session.getAttribute(Global.GLOBAL_USER);
        return null;//user;
    }
}
