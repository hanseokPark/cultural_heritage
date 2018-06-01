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
	public void AreaList(Model model,int ctrdCd) throws UnsupportedEncodingException{
		logger.info("=================AreaList 지역별 목록====================");
		
		logger.info("test2");
		
		List<AreaListVO> result = SendSoap.sendSoap2(ctrdCd);
		for(AreaListVO vo:result){
			logger.info("========================" + vo.toString());
		}
		model.addAttribute("selected", ctrdCd);		
		model.addAttribute("result", result);		
		
		
		
	}
	
}
