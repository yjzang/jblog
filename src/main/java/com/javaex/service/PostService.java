package com.javaex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CateDAO;
import com.javaex.dao.PostDAO;
import com.javaex.vo.CateVO;
import com.javaex.vo.PostVO;

@Service
public class PostService {

	@Autowired
	PostDAO dao;
	@Autowired
	CateDAO cateDAO;
	
	public void addPost(PostVO vo) {
		
		dao.addPost(vo);
	}
	
	public ArrayList<PostVO> getPostList_default(String id){
		
		ArrayList<CateVO> cateList =(ArrayList<CateVO>)cateDAO.getList(id);
		String cateNo=cateList.get(0).getCateNo();
		PostVO vo = new PostVO();
		vo.setCateNo(cateNo);
		ArrayList<PostVO> list = (ArrayList<PostVO>)dao.getPostList(vo);
		if(list.isEmpty()) {
			PostVO postVO= new PostVO();
			postVO.setPostNo("-1");
			list.add(postVO);
		}
		return list;
	}

	public ArrayList<PostVO> getPostList(PostVO vo){
		
		ArrayList<PostVO> list = (ArrayList<PostVO>)dao.getPostList(vo);
		/*System.out.println("포스트 서비스:" +list.get(0).toString());*/
		return list;
	}
	
	public ArrayList<PostVO> getPost(PostVO vo){
		
		ArrayList<PostVO> list = (ArrayList<PostVO>)dao.getPost(vo);
/*		System.out.println("포스트 서비스:" +list.get(0).toString());*/
		return list;
	}
	

}
