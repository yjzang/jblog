package com.javaex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.PostService;
import com.javaex.vo.PostVO;

@Controller
@RequestMapping("/{id}")
public class PostController {
	
	@Autowired
	PostService service;
	
	
	@RequestMapping(value="/admin/write/add",method=RequestMethod.POST)
	public String addPost(@PathVariable("id") String id,@ModelAttribute PostVO vo) {

		System.out.println("포스트 컨트롤러에서 찍어보는 아이디 "+ id);
		service.addPost(vo);
		
		
		return "redirect:/"+id+"/admin/write";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getPostList",method=RequestMethod.POST)
	public List<PostVO> getPostList(@PathVariable("id") String id,
						  @ModelAttribute PostVO vo) {

		System.out.println("포스트 컨트롤러에서 찍어보는 아이디 "+ id);
		System.out.println("포스트 컨트롤러에서 찍어보는 카테넘버 "+ vo.getCateNo());
		List<PostVO> list= service.getPostList(vo);
		
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getPost",method=RequestMethod.POST)
	public List<PostVO> getPost(@PathVariable("id") String id,
						  @ModelAttribute PostVO postVO) {

		String postNo = postVO.getPostNo();
		System.out.println("포스트 컨트롤러에서 찍어보는 아이디 "+ id);
		System.out.println("포스트 컨트롤러에서 찍어보는 포스트넘버 "+ postNo);
		List<PostVO> list= service.getPost(postVO);
		
		return list;
	}
	
}
