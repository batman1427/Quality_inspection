package controller;

import java.io.UnsupportedEncodingException;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.UserService;

@Controller
public class logincontroller {  
	
	private Logger log = LoggerFactory.getLogger(logincontroller.class);
	@Autowired  
    private UserService otherService;   
	
	@RequestMapping(value = {"","sign_in"})
	public String signIn(HttpServletResponse response,
			HttpServletRequest request,HttpSession session) {
		
		return "home";
	}
	
	@RequestMapping(value = {"login"})
	public String login(HttpServletResponse response,
			HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(1);
	    shiroLogin(username,password);
		return "test";
	}
	
	private String shiroLogin(String username,String password) {  
		System.out.println(2);
		 	Subject currenUser = SecurityUtils.getSubject();
		 	currenUser.logout();
	        if(!currenUser.isAuthenticated()){
	        	System.out.println(3);
	        	UsernamePasswordToken token = new UsernamePasswordToken(username,password);
	            //token.setRememberMe(true);
	            try {
	                currenUser.login(token);
	            } catch (UnknownAccountException uae) {
	                log.info("没有该用户： " + token.getPrincipal());
	            } catch (IncorrectCredentialsException ice) {
	                log.info( token.getPrincipal() + " 的密码不正确!");
	            } catch (LockedAccountException lae) {
	                log.info( token.getPrincipal() + " 被锁定 ，请联系管理员");
	            }
	        }
	        if(currenUser.isAuthenticated()) {
	        	System.out.println("用户 "+currenUser.getPrincipal() +" 登录成功");
	            log.info("用户 "+currenUser.getPrincipal() +" 登录成功");
	        }
	        //是否有role1这个角色
	        if(currenUser.hasRole("role1")){
	            log.info("有角色role1");
	        }else{
	            log.info("没有角色role1");
	        }
			return null;
	}  
}
