package controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.User;
import service.AuthorityService;
import service.InitialDataService;
import service.UserService;

@Controller
public class normalcontroller {
	private Logger log = LoggerFactory.getLogger(logincontroller.class);
	@Autowired  
    private UserService userService;  
	@Autowired  
    private AuthorityService authorityService;   
	@Autowired  
    private InitialDataService initialDataService;   
	
	@RequestMapping(value = {"dashboard"})
	public ModelAndView dashboard(HttpServletResponse response,
			HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {
		Subject currenUser = SecurityUtils.getSubject();
		User user=(User) currenUser.getPrincipal();
		ArrayList<String> authorityList=initialDataService.getAuthority(user.getUsername());
		ModelAndView view =new ModelAndView("dashboard");
        view.addObject("username", user.getUsername());
		return view;
	}
}
