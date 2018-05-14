package com.javaex.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BlogService;
import com.javaex.service.UserService;
import com.javaex.vo.BlogVO;

@Controller
public class MainController {

	@Autowired
	BlogService service;
	
	
	@RequestMapping(value="/main" ,method=RequestMethod.GET)
	public String main() {
		
		return "main/index";
	}
	
	@RequestMapping(value="/search" ,method=RequestMethod.POST)
	public String  search(@RequestParam String which, String keyword,
						 Model model) {
		
		System.out.println("잘 오냐"+which+keyword);
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("which", which);
		map.put("keyword", keyword);
		ArrayList<BlogVO> list=service.getBasicByKeyword(map);
		for(BlogVO vo : list) {
			System.out.println(vo.toString());
		}
		model.addAttribute("list",list);
		model.addAttribute("kwd",keyword);
		
		return "main/index";
	}
	
	


}
