package com.javaex.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CmtService;
import com.javaex.vo.CmtVO;

@Controller
@RequestMapping("/{id}/cmt")
public class CmtController {

	@Autowired
	CmtService service;
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public CmtVO addCmt(@ModelAttribute CmtVO vo,
						@RequestParam String writerId) {
		
		CmtVO resultVO = service.addCmt(vo,writerId);
		return resultVO;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/getList",method= RequestMethod.POST)
	public ArrayList<CmtVO> getList(@RequestParam("postNo") String postNo,
									HttpSession session ) {
		
		ArrayList<CmtVO> list = service.getList(postNo);
		return list;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method= RequestMethod.POST)
	public String cmtDel(@ModelAttribute CmtVO vo) {
		
		return service.delete(vo);
		
	}
	
}
