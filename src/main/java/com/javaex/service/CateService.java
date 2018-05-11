package com.javaex.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CateDAO;
import com.javaex.vo.CateVO;

@Service
public class CateService {

	
	@Autowired
	CateDAO dao;
	
	public ArrayList<CateVO> getList(String id){
		
		ArrayList<CateVO> list = (ArrayList<CateVO>)dao.getList(id);
		
		for(CateVO vo : list ) {
			
			String count = dao.countPost(vo);
			vo.setPostCount(count);
			
		}
		 
		return list;
		
	}
	
	public CateVO add(CateVO vo) {
		
		 String cateNo = dao.add(vo);
		 CateVO resultVO=dao.getCatebyNo(cateNo);
		 resultVO.setPostCount("0");
		 return resultVO;
		 
	}
	
	public String delete(CateVO vo) {
		
		String result ="false";
		String count =dao.countPost(vo);
			
		if(count.equals("0")) {
			
			int flag = dao.delete(vo);
			if(flag>0) {
				result="true";
			}
		}
		
		
		 return result;
		 
	}
	
	
	
}
