package com.javaex.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CateService;
import com.javaex.vo.CateVO;


@Controller
@RequestMapping(value="/{id}/admin/category")
public class CateController {

	
	@Autowired
	CateService service;
	
	
	@ResponseBody
	@RequestMapping(value="/getList",method= RequestMethod.POST)
	public ArrayList<CateVO> getList(@PathVariable("id") String id) {
		
		ArrayList<CateVO> list = service.getList(id);
		return list;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/add",method= RequestMethod.POST)
	public CateVO cateAdd(@ModelAttribute CateVO vo) {
		
		System.out.println("컨트롤러 오긴오냐"+vo.toString());
		CateVO resultVO = service.add(vo);
		return resultVO;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method= RequestMethod.POST)
	public String cateDel(@ModelAttribute CateVO vo) {
		
		System.out.println("del에 온 no : " + vo.getCateNo());
		String result = service.delete(vo);
		System.out.println("최종 result"+result);
		return result;
		
	}
	
	
}
