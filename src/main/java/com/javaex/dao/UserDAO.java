package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVO;

@Repository
public class UserDAO {

	
	@Autowired
	SqlSession sqlSession;
	
	public void join(UserVO vo) {
		
		System.out.println(" 가입 정보 : "+ vo.toString());
		sqlSession.insert("userDB.insert",vo);
		
	}

	public void setBlogId(UserVO vo) {
		
		System.out.println("블로그에 넣는 정보 : "+ vo.toString());
		sqlSession.insert("userDB.insert_blog",vo);
	}
	
	
	public void setCateId(UserVO vo) {
		
		System.out.println("카테고리에 넣는 정보 : "+ vo.toString());
		sqlSession.insert("userDB.insert_cate",vo);
	}
	
	public UserVO login(UserVO vo) {
		
		return sqlSession.selectOne("userDB.getAuth",vo);
		
	}
	
	public UserVO getUser(String id) {
		
		 UserVO resultVO = sqlSession.selectOne("userDB.getUser",id);
		 return resultVO;
	}
	
	public UserVO getUserbyNo(String userNo) {
		
		 UserVO resultVO = sqlSession.selectOne("userDB.getUserbyNo",userNo);
		 return resultVO;
	}
	

	public String idCheck (String id) {
		
		return sqlSession.selectOne("userDB.idCheck", id);
	}
	
}
