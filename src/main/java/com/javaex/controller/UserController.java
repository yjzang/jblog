package com.javaex.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/joinform",method=RequestMethod.GET)
	public String joinForm() {
		
		
		return "user/joinForm";
		
		
	}
	
	@RequestMapping(value="/loginform",method=RequestMethod.GET)
	public String loginForm() {
		
		
		return "user/loginForm";
		
	}

	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute UserVO vo) {
		
		service.join(vo);
		return "user/joinSuccess";
		
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute UserVO vo,HttpSession session,Model model) {
		
		String url="";
		 
		UserVO resultVO= service.login(vo);
		
		
		if (resultVO == null) {
			System.out.println("로그인 실패");
			String result="fail";
			model.addAttribute("result",result);
			url="user/loginForm";

		}else {
			session.setAttribute("authVO",resultVO);
			 url="redirect:/main";
		}
		
		return url;

		
	}

	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		
		session.removeAttribute("authVO");
		session.invalidate();
		return "redirect:/main";
		
	}
	

	@ResponseBody
	@RequestMapping(value="/idcheck",method=RequestMethod.POST)
	public boolean idcheck(@RequestParam("id") String id) {
		
		System.out.println("ajax 아이디체크" + id);
		boolean isExist = false;
		
		isExist = service.idCheck(id);
		System.out.println(isExist);
		return isExist;
	}
	
	
}
