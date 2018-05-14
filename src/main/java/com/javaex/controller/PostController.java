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

		service.addPost(vo);
		
		
		return "redirect:/"+id+"/admin/write";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getPostList",method=RequestMethod.POST)
	public List<PostVO> getPostList(@PathVariable("id") String id,
						  @ModelAttribute PostVO vo) {

		List<PostVO> list= service.getPostList(vo);
		
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getPost",method=RequestMethod.POST)
	public List<PostVO> getPost(@PathVariable("id") String id,
						  @ModelAttribute PostVO postVO) {

		List<PostVO> list= service.getPost(postVO);
		
		return list;
	}
	
}
