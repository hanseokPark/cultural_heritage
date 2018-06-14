package com.dgit.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.AreaEachVO;
import com.dgit.domain.AreaListVO;
import com.dgit.domain.Criteria;
import com.dgit.domain.PageMaker;
import com.dgit.util.SendSoap;

/**
 * Handles requests for the application home page.
 */

@Controller
public class culturalController {	
	private static final Logger logger = LoggerFactory.getLogger(culturalController.class);
	
	private static int TOTALCOUNT = 0;
	private static int AREA_NUMBER = 0;
	private static int ITEM_NUMBER = 0;
	private static int NUMBER = 0;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("=================home====================");
		
		
				
		
		return "home";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)  //, int ctrdCd, int itemCd, String culName
	public void searchGET(Model model, Criteria cri) throws UnsupportedEncodingException{
		logger.info("=================search 문화재 분류 및 검색 클릭 GET====================");
		
		// itemCd 종목번호  ctrdCd 지역번호 culName(itemNm) 이름
		
		/*if(culName != null){
			List<AreaListVO> result = SendSoap.sendSoap4(ctrdCd, itemCd, culName);			
			TOTALCOUNT = SendSoap.sendSoap3(ctrdCd, itemCd, culName);
		
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(TOTALCOUNT);
			
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("areaselected", ctrdCd);		
			model.addAttribute("eventselected", itemCd);		
			model.addAttribute("result", result);
			
		}else{
			String result = null;
			model.addAttribute("result", result);
		}
		*/
		
		
		
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)  //
	public void searchPOST(Model model, Criteria cri, int itemCd, int ctrdCd, String culName) throws UnsupportedEncodingException{
		logger.info("=================search 문화재 분류 및 검색 클릭 POST====================");
		logger.info("================종목번호================="+ itemCd);
		logger.info("================ 지역번호 ================="+ctrdCd );
		logger.info("================이름================="+ culName);
		
		
		// itemCd 종목번호  ctrdCd 지역번호 culName(itemNm) 이름
		
		if(culName != null){
			List<AreaListVO> result = SendSoap.sendSoap4(ctrdCd, itemCd, culName);
			System.out.println(result);
			TOTALCOUNT = SendSoap.sendSoap3(ctrdCd, itemCd, culName);
		
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(TOTALCOUNT);
			
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("areaselected", ctrdCd);		
			model.addAttribute("eventselected", itemCd);		
			model.addAttribute("result", result);
			
		}else{
			String result = null;
			model.addAttribute("result", result);
		}
		
		
		
		
	}
	
	@RequestMapping(value="/areaList", method = RequestMethod.GET)
	public void AreaList(Model model, int ctrdCd, Criteria cri, int itemCd) throws UnsupportedEncodingException{
		logger.info("=================AreaList 우리 지역 문화재====================");		
		
		
		if(AREA_NUMBER == 0){			
			logger.info("=================처음====================");		
			AREA_NUMBER = ctrdCd;
			ITEM_NUMBER = itemCd;
			if(TOTALCOUNT == 0){
				TOTALCOUNT = SendSoap.sendSoap3(ctrdCd, itemCd);
				NUMBER = TOTALCOUNT;
			}
		}else if(AREA_NUMBER != ctrdCd){ //지역이 다르면
			logger.info("=================지역 선택====================");		
			AREA_NUMBER = ctrdCd;
			ITEM_NUMBER = itemCd;
			TOTALCOUNT = 0;
			if(TOTALCOUNT == 0){
				TOTALCOUNT = SendSoap.sendSoap3(ctrdCd, itemCd);
			}
		}else if(AREA_NUMBER == ctrdCd){  //지역이 같으면
			logger.info("=================종목 선택====================");		
			AREA_NUMBER = ctrdCd;
			
			if(ITEM_NUMBER == itemCd){ //종목이 같음
				logger.info("=================?????1 지역이 같으면서  종목이 같음===================");	
				
				
			}else if(ITEM_NUMBER != itemCd){
				logger.info("=================?????2 지역이 같으면서  종목이 다름===================");	
				TOTALCOUNT = SendSoap.sendSoap3(ctrdCd, itemCd);
				ITEM_NUMBER = itemCd;
			}			
			
		}
		
		List<AreaListVO> result = SendSoap.sendSoap2(ctrdCd, cri, itemCd);
		
		for(AreaListVO vo:result){
		/*	logger.info("========================" + vo.toString());*/			
		}
		
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(TOTALCOUNT);
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("areaselected", ctrdCd);		
		model.addAttribute("eventselected", itemCd);		
		model.addAttribute("result", result);		
			
	}
	
	
	
	@RequestMapping(value="/detailView", method = RequestMethod.GET)
	public void DetailView(Model model, int ctrdCd, int itemCd, String crltsNo) throws Exception{
		logger.info("================= 명칭 클릭시 상세 보기 ====================");		
		
		
		AreaEachVO result = SendSoap.AreaCrltsDtls(ctrdCd, itemCd, crltsNo);
		
		model.addAttribute("cultural", result);
	}
	
	
	@RequestMapping(value="/introductionView", method = RequestMethod.GET)
	public void introductionView(Model model) throws Exception{
		logger.info("================= 사이트 소개 ====================");		
		
		
		
	}
	
	

	
}
