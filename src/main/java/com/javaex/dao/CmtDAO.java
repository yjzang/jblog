package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CateVO;
import com.javaex.vo.CmtVO;

@Repository
public class CmtDAO {

	@Autowired
	SqlSession sqlSession;
	
	
	public void addCmt(CmtVO vo) {
		System.out.println("코멘트 다오 인서트"+vo.toString());
		sqlSession.insert("cmtDB.insert",vo);
	}

	
	public List<CmtVO> getList(String postNo){
		
		return sqlSession.selectList("cmtDB.getList",postNo);
		
	}
	
	public CmtVO getCmt(String cmtNo){
		
		return sqlSession.selectOne("cmtDB.getCmt",cmtNo);
		
	}
	
	public int delete(CmtVO vo) {
		
		System.out.println("다오 삭제할 cmt 번호: "+ vo.getCmtNo());
		return sqlSession.delete("cmtDB.delete",vo);
		 
	}
	
	public String getCmtCount(String postNo) {
		
		String count = sqlSession.selectOne("cmtDB.getCmtCount",postNo);
		return count;
		
	}
}
