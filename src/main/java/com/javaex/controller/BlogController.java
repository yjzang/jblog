package com.javaex.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CateService;
import com.javaex.service.PostService;
import com.javaex.vo.BlogVO;
import com.javaex.vo.CateVO;
import com.javaex.vo.PostVO;

@Controller
@RequestMapping(value="/{id}")
public class BlogController {
	
	@Autowired
	BlogService service;
	@Autowired
	CateService cateService;
	@Autowired
	PostService postService;
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String main(@PathVariable("id") String id,Model model) {
		
		System.out.println(id);
		BlogVO vo = new BlogVO();
		ArrayList<CateVO> cateList = new ArrayList<CateVO>();
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		vo = service.getBasic(id);
		cateList = cateService.getList(id);
		postList = postService.getPostList_default(id);
		model.addAttribute("vo",vo);
		model.addAttribute("cateList", cateList);
		model.addAttribute("postList", postList);
		return "blog/blog-main";
		
	}


	@RequestMapping(value="/admin/basic",method=RequestMethod.GET)
	public String basic(@PathVariable("id") String id,Model model) {
		
		BlogVO vo = service.getBasic(id);
		model.addAttribute("vo",vo);
		return "blog/admin/blog-admin-basic";
	}

	@RequestMapping(value="/admin/category",method=RequestMethod.GET)
	public String cate(@PathVariable("id") String id,Model model) {
		
		BlogVO vo = service.getBasic(id);
		model.addAttribute("vo",vo);
		return "blog/admin/blog-admin-cate";
	}
	@RequestMapping(value="/admin/write",method=RequestMethod.GET)
	public String write(@PathVariable("id") String id,Model model) {
		
		BlogVO vo = service.getBasic(id);
		ArrayList<CateVO> cateList = cateService.getList(id);
		
		model.addAttribute("vo",vo);
		model.addAttribute("cateList",cateList);
		return "blog/admin/blog-admin-write";
	}
	
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String fileUpload(@PathVariable("id") String id,
							@RequestParam("file") MultipartFile file ,
							 @ModelAttribute BlogVO vo,
							 Model model) {
		
		System.out.println("컨트롤러 :" + vo.getId());
		System.out.println("블로그타이틀"+vo.getBlogtitle());
		System.out.println("받아지는지 보자" +file.getOriginalFilename());
			
				
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("vo", vo);
				map.put("file",file);
				service.restore(map);

	
		return "redirect:/"+id+"/admin/basic";
	}
	
}
