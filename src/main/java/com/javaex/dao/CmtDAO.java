package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CmtVO;

@Repository
public class CmtDAO {

	@Autowired
	SqlSession sqlSession;
	
	
	public void addCmt(CmtVO vo) {
		System.out.println("코멘트 다오 인서트"+vo.toString());
		sqlSession.insert("cmtDB.insert",vo);
	}

}
