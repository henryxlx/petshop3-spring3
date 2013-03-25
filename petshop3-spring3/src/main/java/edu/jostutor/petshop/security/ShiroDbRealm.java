package edu.jostutor.petshop.security;

import edu.jostutor.petshop.entity.*;
import edu.jostutor.petshop.entity.Account;
import edu.jostutor.petshop.service.AccountManager;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-12
 * Time: 下午11:46
 * To change this template use File | Settings | File Templates.
 */
public class ShiroDbRealm extends AuthorizingRealm {

    private AccountManager accountManager;

    /**
     * 使用setter方法注入，因为是通过XML传统的配置方式注入
     * @param accountManager
     */
    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.fromRealm(getName()).iterator().next();
        if (username != null) {
            Account account = accountManager.getUserByUsername(username);
            if (account != null) {
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                info.addRole("user");
                return info;
            }
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String userName = token.getUsername();
        if (userName != null && !"".equals(userName)) {
            Account account = accountManager.getUserByUsername(userName);
            if (account != null) {
                return new SimpleAuthenticationInfo(account.getUserId(), account.getPassword(), getName());
            }
        }
        return null;
    }
}
