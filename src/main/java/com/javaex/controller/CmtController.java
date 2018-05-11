package com.javaex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.CmtService;
import com.javaex.vo.CmtVO;

@Controller
@RequestMapping("/{id}/cmt")
public class CmtController {

	@Autowired
	CmtService service;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addCmt(@ModelAttribute CmtVO vo,
						@RequestParam String writerId) {
		
		
		
		service.addCmt(vo,writerId);
		
	}
	
}
