package security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;
import service.UserService;


public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
         User user = (User) principalCollection.getPrimaryPrincipal();
         info.addRole(user.getRole());
         return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    	 System.out.println(123);
    	UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
          String username = token.getUsername();
          String password = new String(token.getPassword());
          User user = new User(username, password);
          user=userService.login(user);
          if(user!=null) {
        	  return new SimpleAuthenticationInfo(user,user.getPassword(), getName());
          }
          return null;
    }
}
