package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDAO;
import com.javaex.dao.UserDAO;
import com.javaex.vo.BlogVO;
import com.javaex.vo.UserVO;

@Service
public class BlogService {

	
	@Autowired
	BlogDAO dao;
	@Autowired
	UserDAO userDAO;
	
	public BlogVO getBasic(String id) {
		BlogVO vo =  dao.getBasic(id);
		return vo;
	}
	
	public void restore(HashMap<String, Object> map) {
		
		MultipartFile file = (MultipartFile)map.get("file");
		BlogVO vo =(BlogVO)map.get("vo");
		
		String saveDir = "D:\\javaStudy\\upload_jblog";
		
		if (!file.isEmpty()) {

			//오리지날 파일명
			String orgName = file.getOriginalFilename();
 		    System.out.println("orgName: "+ orgName);
			
			
			// 확장자
			String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			System.out.println("exName: "+ exName);
						
			// 저장파일명
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString()+exName;
			System.out.println("saveName: " + saveName);
				
			// 파일패스
			String filePath = saveDir+"\\"+saveName;
			System.out.println("filePath: " + filePath);
			
		
			// 파일사이즈
			long fileSize = file.getSize();
			System.out.println("fileSize: "+fileSize);
			
			
			vo.setLogofile(saveName);
			System.out.println("서비스: " + vo.toString());
			dao.restore(vo);
			
							
			try {
				byte[] fileData = file.getBytes();               //메모리에 있는 파일을 서버로 내보낸다. --> outStream
				OutputStream out = new FileOutputStream(filePath);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				
				bout.write(fileData);
				
				if(bout != null) {
					bout.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		      
		 
	  } else {
			
		  	System.out.println("서비스 블로그타이틀:"+vo.getBlogtitle());
			String blogtitle = vo.getBlogtitle();
			vo.setBlogtitle(blogtitle);
			dao.restore(vo);
	  }
		
	}
	
	public ArrayList<BlogVO> getBasicByKeyword(HashMap<String,String> map) {
		
		String keyword = map.get("keyword");
		String which = map.get("which");
		ArrayList<BlogVO> list = new ArrayList<BlogVO>();
		BlogVO vo = new BlogVO(); 
				
		if("blog-title".equals(which)) {
			vo.setBlogtitle(keyword);
			list = (ArrayList<BlogVO>)dao.getBasicByKeyword(vo);	
			for(BlogVO blogVO : list) {
				 
				String id = blogVO.getId();
				UserVO userVO=userDAO.getUser(id);
				blogVO.setUsername(userVO.getUsername());
			}
		} else if ("blog-user".equals(which)) {
			
			vo.setId(keyword);
			list = (ArrayList<BlogVO>)dao.getBasicByKeyword(vo);
			for(BlogVO blogVO : list) {
				 
				String id = blogVO.getId();
				UserVO userVO=userDAO.getUser(id);
				blogVO.setUsername(userVO.getUsername());
			}
			
		} else {
			
			
			 
		}
		
		return list;
	}
	

}
