package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaex.dao.UserDAO;
import com.javaex.vo.UserVO;

@Service
public class UserService {

	
	@Autowired
	UserDAO dao;
	
	@Transactional
	public void join(UserVO vo) {
		
		System.out.println("유저서비스까진 왔나보자구"+vo.toString());
		dao.join(vo);
		dao.setBlogId(vo);
		dao.setCateId(vo);
	
		

	}
	
	public UserVO login(UserVO vo) {
		
		UserVO resultVO = dao.login(vo);
		return resultVO;
	}

	public UserVO getUser(String id) {
		
		UserVO resultVO = dao.getUser(id);
		System.out.println(resultVO.toString());
		return resultVO;
	}
	
	public boolean idCheck(String id) {
		
		String no = null;
		boolean flag = false;
		no = dao.idCheck(id);
		if(no==null) {
			
			flag = true;
			System.out.println(flag);
			
		} 
		return flag; 
		
	}
}
