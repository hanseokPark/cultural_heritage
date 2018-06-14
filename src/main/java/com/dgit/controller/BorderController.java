package com.dgit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dgit.domain.BoardVO;
import com.dgit.domain.PageMaker;
import com.dgit.domain.SearchCriteria;
import com.dgit.service.BoardService;
import com.dgit.util.MediaUtils;

/**
 * Handles requests for the application home page.
 */



@Controller
public class BorderController {	
	private static final Logger logger = LoggerFactory.getLogger(BorderController.class);	
	
	private List<String> DBSAVENAME = new ArrayList<String>();
	private static int COUNT = 0;  //증가식
	private static int AREA_NUMBER = 0; //
	
	
	
	
	@Autowired
	private BoardService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public void boardViewGET(Model model, @ModelAttribute("cri")SearchCriteria cri) throws Exception{
		logger.info("================= 게시판  ====================");		
		logger.info("============cri================="+cri.toString());	
		
		/*List<BoardVO> list = service.listAll();
		
		model.addAttribute("list",list);*/
		List<BoardVO> list = service.listSearch(cri);
		model.addAttribute("list",list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	
	
	
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public void registerGet(){
		logger.info("================= 게시판 글쓰기  GET ====================");		
		
		DBSAVENAME.clear();
	}
	
	@ResponseBody
	@RequestMapping(value="/imgupload", method= RequestMethod.POST)
	public String imgupload(MultipartFile file ) throws IOException{
		logger.info("================= imgupload ====================");		
		UUID uid = UUID.randomUUID(); //중복되지 않는 고유한 키값을 설정할 때 사용
		String savedName = uid.toString() + "_" + file.getOriginalFilename();
		logger.info("================= 이미지이름 ===================="+ savedName);
		
		
		DBSAVENAME.add(savedName);
		
		
		logger.info("================= DB이미지이름 ===================="+ DBSAVENAME.toString());
		
		
		File target = new File(uploadPath + "/" + savedName);
		FileCopyUtils.copy(file.getBytes(), target);
		
		return savedName;
	}
	
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String registerPOST(BoardVO vo, List<MultipartFile> imageFiles) throws Exception{
		logger.info("================= 게시판 글쓰기 POST ====================");		
		logger.info("================= 게시판 글쓰기 POST 이미지 ====================" + imageFiles.toString());		
		
		DBSAVENAME.clear();
		service.regist(vo);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value="/readPage", method=RequestMethod.GET)/*  , String mod*/
	public void readPageGET(Model model, int bno, @ModelAttribute("cri")SearchCriteria cri) throws Exception{
		logger.info("================= 게시판 상세내용 ====================");	
		logger.info("bno : " + bno);
		logger.info(cri.toString());
	
		/*if(mod == null || mod.equals("mod") == false){
			service.boardviewcnt(bno);
		}
		*/
		
		BoardVO vo = service.read(bno);
		model.addAttribute("readPage", vo);
	}
	
	
	
	
	
	//@ResponseBody 데이터만 가는경우
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displyFile(String filename) throws Exception{
		ResponseEntity<byte[]> entity = null;
				
		InputStream in = null;
				
		logger.info("[displayFile] filename : " + filename);
				
		try{
					
			String format = filename.substring(filename.lastIndexOf(".") +1);  //확장자만
			MediaType mType = MediaUtils.getMediaType(format);
			HttpHeaders headers = new  HttpHeaders();
			headers.setContentType(mType);
				
			in = new FileInputStream(uploadPath + "/" + filename);
			// IOUtils 바이트 배열로 뽑아줌
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
				
		return entity;
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.GET)
	public void deleteGET(Model model,  String[] imgs, int bno, SearchCriteria cri, BoardVO vo) throws Exception{
		logger.info("================= 게시판 삭제 비밀번호 입력 GET ====================");
		
		List<String> list = new ArrayList<>();
		
		
		
		
		for(int i= 0; i<imgs.length; i++){				
			list.add(imgs[i]);
		}
		
		
		String list2 =  list.toString().substring(1, list.toString().lastIndexOf("]"));		
			
		
		logger.info("=================List===================="+list2);		
		
		model.addAttribute("bno", bno);
		model.addAttribute("imgs", list2);
		model.addAttribute("page", cri.getPage());
		model.addAttribute("perPageNum", cri.getPerPageNum());
		model.addAttribute("keyword", cri.getKeyword());
		model.addAttribute("searchType", cri.getSearchType());
		
		
	}
	
	
	@RequestMapping(value="/removePage", method=RequestMethod.GET)
	public String remove(Model model, String[] imgs, int bno, String pass, SearchCriteria cri, BoardVO vo) throws Exception{
		logger.info("========================게시물 삭제==========================");

		
	/*	if(!imgs[0].equals("")){
			logger.info("=========================== 삭제 게시물에 사진이 있음 ===========================");
			for(String file : imgs){
				logger.info(file.toString()+"======================================");
				deleteFile(uploadPath, file);
							
			}
			
			vo.setBno(bno);
			vo.setUr_pass(Integer.parseInt(pass));
			
			service.remove(vo);
			
		}else{
			logger.info("===========================삭제 게시물에 사진이 없음 ===========================");
			
			vo.setBno(bno);
			vo.setUr_pass(Integer.parseInt(pass));
			
			service.remove(vo);
			
		}*/
		
	/*	imgs.toString().substring(1, imgs.toString().lastIndexOf("]"));*/
		
		int pass1 = Integer.parseInt(pass);
		BoardVO pass2 = service.selectPass(bno);
		
		
		
		logger.info("======================================="+pass2);
		if(pass2.getUr_pass() == pass1){
			logger.info("===============삭제===================");
			for(String file : imgs){
				logger.info("===============삭제 이미지명==================="+file);
			
				deleteFile(uploadPath, file);							
			}
			
			vo.setBno(bno);
			vo.setUr_pass(pass1);
			
			service.remove(vo);
		}else{
			return "redirect:/delete?bno="+bno+"&page="+cri.getPage()+"&searchType="+cri.getSearchType()+"&keyword="+cri.getKeyword();
			
		}
		
		
		
		model.addAttribute("page", cri.getPage());
		model.addAttribute("perPageNum", cri.getPerPageNum());
		model.addAttribute("keyword", cri.getKeyword());
		model.addAttribute("searchType", cri.getSearchType());
		
		return "redirect:/board";
	
	
	}
	
	
	
	public static void deleteFile(String uploadPath, String filename){
		
		File file2 = new File(uploadPath +"/"+ filename);
	
		//원본 삭제
		if(file2.exists()){
			file2.delete();
		}
		
	}

}