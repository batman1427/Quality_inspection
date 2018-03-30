package controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import model.Authority;
import model.User;
import service.AuthorityService;
import service.InitialDataService;
import service.UserService;

@Controller
public class logincontroller {  
	
	private Logger log = LoggerFactory.getLogger(logincontroller.class);
	@Autowired  
    private UserService userService;   
	
	@RequestMapping(value = {"","login"})
	public String signIn(HttpServletResponse response,
			HttpServletRequest request,HttpSession session) {
		
		return "login";
	}
	
	@RequestMapping(value = {"logout"})
	public String logout(HttpServletResponse response,
			HttpServletRequest request,HttpSession session) {
		Subject currenUser = SecurityUtils.getSubject();
	 	currenUser.logout();
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value = {"Authentication"},method = RequestMethod.POST)
	public  Map<String, Object> Authentication(HttpServletResponse response,
			HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	    Map<String, Object> map = new HashMap<String, Object>();
	    User user=shiroLogin(username,password);
	    if(user==null) {
	    	  map.put("code", "0");
	    }else {
	    	  map.put("code", "1");
	    }
	    //用户检测的产品类型，检测步骤，产品列表
	    return map;
	}
	
	private User shiroLogin(String username,String password) {  
		 	Subject currenUser = SecurityUtils.getSubject();
		 	currenUser.logout();
	        if(!currenUser.isAuthenticated()){
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
	            log.info("用户 "+ ((User)currenUser.getPrincipal()).getUsername()+" 登录成功");
	        }
	        //是否有role1这个角色
	        if(currenUser.hasRole("admin")){
	            log.info("具有管理员权限");
	            return (User)currenUser.getPrincipal();
	        }else if(currenUser.hasRole("normal")){
	            log.info("具有普通用户权限");
	            return (User)currenUser.getPrincipal();
	        }else {
	        	log.info("无权限");
	        }
	        
			return null;
	}  
}
