package com.javaex.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVO;

@Repository
public class BlogDAO {

	@Autowired
	SqlSession sqlSession;
	
	public void restore(BlogVO vo){
		
		sqlSession.update("blogDB.update",vo);
	
	}
	
	public BlogVO getBasic(String id) {
		
		BlogVO vo =  sqlSession.selectOne("blogDB.getBasic",id);
		return vo;
		
	}
	
	public List<BlogVO> getBasicByKeyword(BlogVO vo) {
		
		List<BlogVO> list =  sqlSession.selectList("blogDB.getBasicByKeyword",vo);
		return list;
		
	}
	
	
}
