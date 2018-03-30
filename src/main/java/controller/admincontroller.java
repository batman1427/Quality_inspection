package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admincontroller {

	@RequestMapping(value = {"admin"})
	public String signIn(HttpServletResponse response,
			HttpServletRequest request,HttpSession session) {
		
		return "admin";
	}
}
