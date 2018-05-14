package com.javaex.service;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	public CmtVO addCmt(CmtVO vo,String id) {
		
		UserVO userVO = userDAO.getUser(id);
		vo.setUserNo(userVO.getUserno());
		dao.addCmt(vo);
		String cmtNo = vo.getCmtNo();
		CmtVO resultVO = dao.getCmt(cmtNo);
		resultVO.setUserName(userVO.getUsername());

		return resultVO;
		
	}
	
	public ArrayList<CmtVO> getList(String postNo){
		
		ArrayList<CmtVO> list = (ArrayList<CmtVO>)dao.getList(postNo);
		for(CmtVO vo: list) {
			
			String userNo = vo.getUserNo();
			UserVO resultVO =userDAO.getUserbyNo(userNo);
			String userName = resultVO.getUsername();
			vo.setUserName(userName);
			
		}
		return list;
		
	}
	
	public String delete(CmtVO vo) {
		
		 int flag =  dao.delete(vo);
		 String result = "false";
		 if(flag>0) {
			 result = "true";
		 }
		 return result;
	}
}
