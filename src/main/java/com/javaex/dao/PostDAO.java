package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVO;

@Repository
public class PostDAO {

	
	@Autowired
	SqlSession sqlSession;
	
	public void addPost(PostVO vo) {
		
		sqlSession.insert("postDB.insert",vo);
	}
	
	public List<PostVO> getPostList(PostVO vo){
		
		return sqlSession.selectList("postDB.getPostList",vo);
	}
	
	public List<PostVO> getPost(PostVO vo){
		
		return sqlSession.selectList("postDB.getPost",vo);
	}
}
