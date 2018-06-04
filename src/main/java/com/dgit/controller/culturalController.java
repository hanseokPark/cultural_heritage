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
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("=================home====================");
		
		
				
		
		return "home";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public void search(Model model){
		logger.info("=================search 문화재 분류 및 검색 클릭====================");
		
		
		
		
		
	}
	
	@RequestMapping(value="/AreaList", method = RequestMethod.GET)
	public void AreaList(Model model, int ctrdCd, Criteria cri) throws UnsupportedEncodingException{
		logger.info("=================AreaList 지역별 목록====================");
		
		List<AreaListVO> cnt = SendSoap.sendSoap3(ctrdCd);
		List<AreaListVO> result = SendSoap.sendSoap2(ctrdCd, cri);
		for(AreaListVO vo:result){
		/*	logger.info("========================" + vo.toString());*/
			
			
		}
		/*logger.info("========================" + cnt.size());*/
		
	/*	int totcnt = Integer.parseInt(result.get(0).getTotCnt());*/
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(cnt.size());
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("selected", ctrdCd);		
		model.addAttribute("result", result);		
		
		
		
	}
	
}
