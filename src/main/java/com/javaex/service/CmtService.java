package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CmtDAO;
import com.javaex.dao.UserDAO;
import com.javaex.vo.CmtVO;
import com.javaex.vo.UserVO;

@Service
public class CmtService {

	
	@Autowired
	CmtDAO dao;
	@Autowired
	UserDAO userDAO;
	
	
	public void addCmt(CmtVO vo,String id) {
		
		UserVO userVO = userDAO.getUser(id);
		vo.setUserNo(userVO.getUserno());
		System.out.println("코멘트서비스 인서트"+vo.toString());
		dao.addCmt(vo);
	}
}
