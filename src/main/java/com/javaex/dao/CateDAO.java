package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CateVO;


@Repository
public class CateDAO {

	
	@Autowired
	SqlSession sqlSession;
	
	
	public List<CateVO> getList(String id){
		
		return sqlSession.selectList("cateDB.getList",id);
	}


	public String add(CateVO vo) {
		
		sqlSession.insert("cateDB.insert",vo);
		System.out.println(vo.getCateNo());
		return vo.getCateNo();
		
	}
	
	
	public CateVO getCatebyNo(String no) {
		
		System.out.println("다오에서 no"+no);
		CateVO vo =sqlSession.selectOne("cateDB.getCatebyNo",no);
		System.out.println("다오에서 결과값"+vo.toString());
		return vo;
	}
	
	public int delete(CateVO vo) {
		
		int flag =sqlSession.delete("cateDB.delete",vo);
		return flag;
		 
	}
	
	public String countPost(CateVO vo) {
		
		return sqlSession.selectOne("cateDB.countPost",vo);
		 
	}
	
	
}
