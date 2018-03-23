package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.UserService;

@Controller
public class testcontroller {  
	@Autowired  
    private UserService otherService;   
	
	@RequestMapping(value = {"","sign_in"})
	public String signIn(HttpServletResponse response,
			HttpServletRequest request,HttpSession session) {
		otherService.getstaffList();
		return "home";
	}
}
