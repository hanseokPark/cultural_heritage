package com.dgit.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.util.StringUtils;

import com.dgit.domain.AreaEachVO;
import com.dgit.domain.AreaListVO;
import com.dgit.domain.Criteria;


public class SendSoap {
	
	//페이지 번호
	public static int sendSoap3(int ctrdCd, int itemCd) throws UnsupportedEncodingException {
			
		int occurance = 0;
			
			
		Object item;
		Object ctrd;
			
		if(ctrdCd == 46){
			ctrd = "ZZ";
		}else{
			ctrd = ctrdCd;
		}			
		if(itemCd == 0){
			item = "";
		}else{
			item = itemCd;
		}
			
			
		String message = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' "
				+ "xmlns:head='http://apache.org/headers' xmlns:ser='http://service.areacrlts.crlts.cha/'>"
				+ " <soapenv:Header><head:ComMsgHeader>"
				+ "<RequestMsgID>fe1b03a0-bc90-11df-b991-0002a5d5c51b</RequestMsgID>"
				+ "<ServiceKey>M8c6Xf7lFeytSRHsiDgEH+GRsqwRxxu6cLTcC5qwyTaq87zwogTXF6gFQinVcU5Lyh9o4INPyMQGO4FGI5BjmA==</ServiceKey>"
				+ "<!--Optional:-->" + "<RequestTime>?</RequestTime><CallBackURI>?</CallBackURI>"
				+ "</head:ComMsgHeader></soapenv:Header><soapenv:Body><ser:getAreaCrltsList>" + "<arg0> "
				+ "<RequestMsgID></RequestMsgID><ServiceKey></ServiceKey>" + "<!--Optional:-->"
				+ "<RequestTime>?</RequestTime>" + "<!--Optional:-->" + "<CallBackURI></CallBackURI>"
				+ "<nowPageNo>1</nowPageNo>" 
				+ "<pageMg>2000</pageMg>" 
				+ "<ctrdCd>"+ctrd+"</ctrdCd>" + "<!--Optional:-->"
				+ "<itemCd>"+ item +"</itemCd>" + "<!--Optional:-->" + "<itemNm></itemNm>" + "<!--Optional:-->"
				+ " <crltsNo></crltsNo>" + "<!--Optional:-->" + "<crltsNoNm></crltsNoNm>" + "<!--Optional:-->"
				+ "<crltsNm></crltsNm>" + "<!--Optional:-->" + "<xCntsBegin></xCntsBegin>" + " <!--Optional:-->"
				+ "<xCntsEnd></xCntsEnd>" + "<!--Optional:-->" + "<yCntsBegin></yCntsBegin>" + "<!--Optional:-->"
				+ "<yCntsEnd></yCntsEnd>" + "</arg0> " + "</ser:getAreaCrltsList></soapenv:Body></soapenv:Envelope>";

		String strURL = "http://openapi.cha.go.kr:80/openapi/soap/crlts/AreaCrltsService";

		HttpClient httpclient = HttpClientBuilder.create().build();

		HttpPost post = new HttpPost(strURL);
		StringEntity entity = new StringEntity(message);
		post.setEntity(entity);
		post.setHeader("Content-Type", "text/xml;charset=UTF-8");
		post.setHeader("Connection", "Keep-Alive");

		
		try {
			HttpResponse response = httpclient.execute(post);
			BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));

			/*String inputLine;*/
				
				

		/*	// 페이지의 정보를 저장한다.
			while ((inputLine = in.readLine()) != null) {
				System.out.println("---------------------문자열 :"+inputLine);			
				
				buffer = inputLine.trim();
			}*/
			occurance = StringUtils.countOccurrencesOf(in.readLine(), "<item>");
		
	
			/*System.out.println(occurance);*/
		
			in.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
		}
		
		return occurance;

	}
	
	
	//지역 문화재 목록 검색
	public static List<AreaListVO> sendSoap2(int ctrdCd,Criteria cri, int itemCd) throws UnsupportedEncodingException {
		
		
		Object item;
		Object ctrd;
		
		if(ctrdCd == 46){
			ctrd = "ZZ";
		}else{
			ctrd = ctrdCd;
		}
		
		if(itemCd == 0){
			item = "";
		}else{
			item = itemCd;
		}		
		
		
		List<AreaListVO> strList = new ArrayList<>();

		String message = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' "
				+ "xmlns:head='http://apache.org/headers' xmlns:ser='http://service.areacrlts.crlts.cha/'>"
				+ " <soapenv:Header><head:ComMsgHeader>"
				+ "<RequestMsgID>fe1b03a0-bc90-11df-b991-0002a5d5c51b</RequestMsgID>"
				+ "<ServiceKey>M8c6Xf7lFeytSRHsiDgEH+GRsqwRxxu6cLTcC5qwyTaq87zwogTXF6gFQinVcU5Lyh9o4INPyMQGO4FGI5BjmA==</ServiceKey>"
				+ "<!--Optional:-->" + "<RequestTime>?</RequestTime><CallBackURI>?</CallBackURI>"
				+ "</head:ComMsgHeader></soapenv:Header><soapenv:Body><ser:getAreaCrltsList>" + "<arg0> "
				+ "<RequestMsgID></RequestMsgID><ServiceKey></ServiceKey>" + "<!--Optional:-->"
				+ "<RequestTime>?</RequestTime>" + "<!--Optional:-->" + "<CallBackURI></CallBackURI>"
				+ "<nowPageNo>"+ cri.getPage() +"</nowPageNo>" 
				+ "<pageMg>"+ cri.getPerPageNum() +"</pageMg>" 
				+ "<ctrdCd>"+ ctrd +"</ctrdCd>" + "<!--Optional:-->"
				+ "<itemCd>"+ item +"</itemCd>" + "<!--Optional:-->" + "<itemNm></itemNm>" + "<!--Optional:-->"
				+ " <crltsNo></crltsNo>" + "<!--Optional:-->" + "<crltsNoNm></crltsNoNm>" + "<!--Optional:-->"
				+ "<crltsNm></crltsNm>" + "<!--Optional:-->" + "<xCntsBegin></xCntsBegin>" + " <!--Optional:-->"
				+ "<xCntsEnd></xCntsEnd>" + "<!--Optional:-->" + "<yCntsBegin></yCntsBegin>" + "<!--Optional:-->"
				+ "<yCntsEnd></yCntsEnd>" + "</arg0> " + "</ser:getAreaCrltsList></soapenv:Body></soapenv:Envelope>";

		String strURL = "http://openapi.cha.go.kr:80/openapi/soap/crlts/AreaCrltsService";

		HttpClient httpclient = HttpClientBuilder.create().build();

		HttpPost post = new HttpPost(strURL);
		StringEntity entity = new StringEntity(message);
		post.setEntity(entity);
		post.setHeader("Content-Type", "text/xml;charset=UTF-8");
		post.setHeader("Connection", "Keep-Alive");

		String buffer = null;
		try {
			HttpResponse response = httpclient.execute(post);
			BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));

			String inputLine;

			// 페이지의 정보를 저장한다.
			while ((inputLine = in.readLine()) != null) {			
				buffer = inputLine.trim();

			}
			 
			
			 
			    
			String[] str = buffer.split("<item>");
			
		
			
			for(int i=1;i<str.length;i++){
				/*logger.info("stringBuilder item = " + sttr.toString());*/
				AreaListVO area = new AreaListVO();
				
				//문화재 이름(한글 예:서울 숭례문)
				area.setCrltsNm(str[i].substring(str[i].indexOf("<crltsNm>")+9, str[i].indexOf("</crltsNm>")));		
				

				if(str[i].contains("<crltsNmChcrt>")){					
					//문화재 이름(한자 예:서울 崇禮門) 
					area.setCrltsNmChcrt(str[i].substring((str[i].indexOf("<crltsNmChcrt>")+14),str[i].indexOf("</crltsNmChcrt>")));
				}else{
					area.setCrltsNmChcrt(null);	
				}
				
				
				
				//문화재 지정번호(예: 00010000)
				area.setCrltsNo(str[i].substring((str[i].indexOf("<crltsNo>")+9), str[i].indexOf("</crltsNo>")));				
				//문화재 지정번호명(예: 1 (숫자 1은 숭례문이 1호라서인듯))
				area.setCrltsNoNm(str[i].substring((str[i].indexOf("<crltsNoNm>")+11),str[i].indexOf("</crltsNoNm>")));
				//문화재 지역(소재지)코드 (예: 11)
				area.setCtrdCd(str[i].substring((str[i].indexOf("<ctrdCd>")+8), str[i].indexOf("</ctrdCd>")));				
				//문화재 소재지 지역(예: 서울) 
				area.setCtrdNm(str[i].substring((str[i].indexOf("<ctrdNm>")+8), str[i].indexOf("</ctrdNm>")));				
				//문화재 종목코드(예: 11)
				area.setItemCd(str[i].substring((str[i].indexOf("<itemCd>")+8), str[i].indexOf("</itemCd>")));				
				//문화재 종목명칭(예: 국보)
				area.setItemNm(str[i].substring((str[i].indexOf("<itemNm>")+8), str[i].indexOf("</itemNm>")));
				
				
				if(str[i].contains("<listImageUrl>")){					
					//문화재 리스트 이미지 경로(썸네일 인듯) 
					area.setListImageUrl(str[i].substring((str[i].indexOf("<listImageUrl>")+14), str[i].indexOf("</listImageUrl>")));
				}else{
					area.setListImageUrl(null);	
				}
				
				
				if(str[i].contains("<XCnts>")){
				/*	logger.info("=========================있는경우=========================");*/					
					
					//문화재 x좌표값 					
					area.setXCnts(str[i].substring((str[i].indexOf("<XCnts>")+7), str[i].indexOf("</XCnts>")));				
					//문화재 y좌표값 
					area.setYCnts(str[i].substring((str[i].indexOf("<YCnts>")+7), str[i].indexOf("</YCnts>")));					
				
				}else{  
				/*	logger.info("=========================없는경우=========================");*/
					
					//문화재 x좌표값 
					area.setXCnts(null);				
					//문화재 y좌표값 
					area.setYCnts(null);					
				}
				  
			
				
				strList.add(area);
				
			}
			
			

			// 종목코드
			// 11 : 국보 12 : 보물 13 : 사적 14 : 사적및명승 15 : 명승
			// 16 : 천연기념물 17 : 중요무형문화재 18 : 중요민속문화재 21 : 시도유형문화재
			// 22 : 시도무형문화재 23 : 시도기념물 24 : 시도민속문화재 31 : 문화재자료
			// 79 : 등록문화재 80 : 이북5도 무형문화재

			// 시도코드
			// 11 : 서울 21 : 부산 22 : 대구 23 : 인천 24 : 광주 25 : 대전 26 : 울산 45 : 세종
			// 31 : 경기 32 : 강원
			// 33 : 충북 34 : 충남 35 : 전북 36 : 전남 37 : 경북 38 : 경남 39 : 제주  40:황해도 이북5도 ZZ : 전국일원

			// 문화재 이름(한글 예:서울 숭례문)
			

			in.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
		}

		return strList;

	}

	
	
	
	//지역 문화재 1개 검색
	public static AreaEachVO AreaCrltsDtls(int ctrd, int item, String crltsNo2) throws Exception {
		 AreaEachVO areaEachVO = new AreaEachVO();
		 
		 
		/* System.out.println("1 :"+ ctrd);
		 System.out.println("2 :"+ item);
		 System.out.println("3 :"+ crltsNo2);*/
		 
        String message = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' " +
                "xmlns:head='http://apache.org/headers' xmlns:ser='http://service.areacrlts.crlts.cha/'>"
                + "<soapenv:Header><head:ComMsgHeader>"
                + "<RequestMsgID>fe1b03a0-bc90-11df-b991-0002a5d5c51b</RequestMsgID>"
                + "<ServiceKey>M8c6Xf7lFeytSRHsiDgEH+GRsqwRxxu6cLTcC5qwyTaq87zwogTXF6gFQinVcU5Lyh9o4INPyMQGO4FGI5BjmA==</ServiceKey>"
                + "</head:ComMsgHeader></soapenv:Header>"
                + "<soapenv:Body>"
                + "<ser:getAreaCrltsDtls><arg0>"
                + "<RequestMsgID></RequestMsgID>"
                + "<ServiceKey></ServiceKey>"
                + "<RequestTime>?</RequestTime>"
                + "<CallBackURI>?</CallBackURI>"
                + "<itemCd>"+ item +"</itemCd>"
                + "<crltsNo>"+ crltsNo2 +"</crltsNo>"
                + "<ctrdCd>"+ ctrd +"</ctrdCd></arg0>"
                + "</ser:getAreaCrltsDtls>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";

        String strURL = "http://openapi.cha.go.kr:80/openapi/soap/crlts/AreaCrltsService";
        
        HttpClient httpclient = HttpClientBuilder.create().build();
        
        HttpPost post = new HttpPost(strURL);
        StringEntity entity = new StringEntity(message);
        post.setEntity(entity);
        post.setHeader("Content-Type", "text/xml;charset=UTF-8");
        post.setHeader("Connection", "Keep-Alive");

        String buffer = "";
       try {
       	 HttpResponse response = httpclient.execute(post);
       	 BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"utf-8"));
            
            String inputLine;
             
            // 페이지의 정보를 저장한다.
             while ((inputLine = in.readLine()) != null){
                  buffer += inputLine.trim();
                 
            }
            /* System.out.println(buffer);*/
             
            // 종목코드
            // 11 : 국보  12 : 보물  13 : 사적  14 : 사적및명승  15 : 명승 
            // 16 : 천연기념물 17 : 중요무형문화재 18 : 중요민속문화재 21 : 시도유형문화재 
            // 22 : 시도무형문화재 23 : 시도기념물 24 : 시도민속문화재 31 : 문화재자료 
            // 79 : 등록문화재 80 : 이북5도 무형문화재
            
             
            // 시도코드
            // 11 : 서울 21 : 부산 22 : 대구 23 : 인천 24 : 광주 25 : 대전 26 : 울산 45 : 세종 31 : 경기 32 : 강원 
            // 33 : 충북 34 : 충남 35 : 전북 36 : 전남 37 : 경북 38 : 경남 50 : 제주 ZZ : 전국일원
            
             String crltsDc;
             
             if(buffer.contains("<crltsDc>")){	
            	//문화재 설명
            	 crltsDc = buffer.substring((buffer.indexOf("<crltsDc>")+9), buffer.indexOf("</crltsDc>"));
             }else{
            	 crltsDc = null;
             }
             System.out.println(crltsDc);
            
            //문화재 이름(한글 예:서울 숭례문)
            String crltsNm = buffer.substring((buffer.indexOf("<crltsNm>")+9), buffer.indexOf("</crltsNm>"));
            String crltsNmChcrt;
            if(buffer.contains("<crltsNmChcrt>")){					
            	//문화재 이름(한자 예:서울 崇禮門)
                crltsNmChcrt = buffer.substring((buffer.indexOf("<crltsNmChcrt>")+14), buffer.indexOf("</crltsNmChcrt>"));
			}else{
				crltsNmChcrt = null;
			}
			
           
            
            
            //문화재 지정번호(예: 00010000)
            String crltsNo = buffer.substring((buffer.indexOf("<crltsNo>")+9), buffer.indexOf("</crltsNo>"));
            //문화재 지정번호명(예: 1        (숫자 1은 숭례문이 1호라서 인듯))
            String crltsNoNm = buffer.substring((buffer.indexOf("<crltsNoNm>")+11), buffer.indexOf("</crltsNoNm>"));
            //문화재 지역(소재지)코드 (예: 11)
            String ctrdCd = buffer.substring((buffer.indexOf("<ctrdCd>")+8), buffer.indexOf("</ctrdCd>"));
            //문화재 소재지 지역(예: 서울)
            String ctrdNm = buffer.substring((buffer.indexOf("<ctrdNm>")+8), buffer.indexOf("</ctrdNm>"));
            
            
            String imageUrl;
            
            if(buffer.contains("<imageUrl>")){		
            //문화재 대표이미지경로(메인)
            	imageUrl = buffer.substring((buffer.indexOf("<imageUrl>")+10), buffer.indexOf("</imageUrl>"));
            }else{
            	imageUrl = null;
            }
            
            
            
            //문화재 이미지 여부(예: Y)
            String imageYn = buffer.substring((buffer.indexOf("<imageYn>")+9), buffer.indexOf("</imageYn>"));
            //문화재  종목코드(예: 11)
            String itemCd = buffer.substring((buffer.indexOf("<itemCd>")+8), buffer.indexOf("</itemCd>"));
            //문화재 종목명칭(예: 국보)
            String itemNm = buffer.substring((buffer.indexOf("<itemNm>")+8), buffer.indexOf("</itemNm>"));
            
            String listImageUrl;
            if(buffer.contains("<listImageUrl>")){		
            	//문화재 리스트 이미지 경로(썸네일 인듯)
            	listImageUrl= buffer.substring((buffer.indexOf("<listImageUrl>")+14), buffer.indexOf("</listImageUrl>"));
            }else{
            	listImageUrl = null;
            }
            
            
            
            //문화재 소재지 시군구 코드(예: 12)
            String signguCd = buffer.substring((buffer.indexOf("<signguCd>")+10), buffer.indexOf("</signguCd>"));
            //문화재 소재지 시군구 명칭(예: 중구)
            String signguNm = buffer.substring((buffer.indexOf("<signguNm>")+10), buffer.indexOf("</signguNm>"));
            //문화재 x좌표값
            String XCnts = buffer.substring((buffer.indexOf("<XCnts>")+7), buffer.indexOf("</XCnts>"));
            //문화재 y좌표값
            String YCnts  = buffer.substring((buffer.indexOf("<YCnts>")+7), buffer.indexOf("</YCnts>"));
            
            
            
            
            areaEachVO.setCrltsDc(crltsDc);
            areaEachVO.setCrltsNm(crltsNm);
            areaEachVO.setCrltsNmChcrt(crltsNmChcrt);
            areaEachVO.setCrltsNo(crltsNo);
            areaEachVO.setCrltsNoNm(crltsNoNm);
            areaEachVO.setCtrdCd(ctrdCd);
            areaEachVO.setCtrdNm(ctrdNm);
            areaEachVO.setImageUrl(imageUrl);
            areaEachVO.setImageYn(imageYn);
            areaEachVO.setItemCd(itemCd);
            areaEachVO.setItemNm(itemNm);
            areaEachVO.setListImageUrl(listImageUrl);
            areaEachVO.setSignguCd(signguCd);
            areaEachVO.setSignguNm(signguNm);
            areaEachVO.setXCnts(XCnts);
            areaEachVO.setYCnts(YCnts);
            
            
            in.close();
            
            
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
       finally {
			// TODO: handle finally clause
		}
       
       return areaEachVO;
       
	 }
	
	
	
	
		//문화재 이름검색
		public static List<AreaListVO> sendSoap4(int ctrdCd, int itemCd, String culName) throws UnsupportedEncodingException {
			
			String name = culName;
			Object item;
			Object ctrd;
			
			if(ctrdCd == 46){
				ctrd = "ZZ";
			}else{
				ctrd = ctrdCd;
			}
			
			if(itemCd == 0){
				item = "";
			}else{
				item = itemCd;
			}
			System.out.println(ctrd);
			System.out.println(item);
			System.out.println(name);
			
			List<AreaListVO> strList = new ArrayList<>();

			String message ="<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:head='http://apache.org/headers' xmlns:ser='http://service.kndcrlts.crlts.cha/'>"
							+ "<soapenv:Header>"
									+ "<head:ComMsgHeader>"
										+ "<RequestMsgID>fe1b03a0-bc90-11df-b991-0002a5d5c51b</RequestMsgID>"
										+ "<ServiceKey>M8c6Xf7lFeytSRHsiDgEH+GRsqwRxxu6cLTcC5qwyTaq87zwogTXF6gFQinVcU5Lyh9o4INPyMQGO4FGI5BjmA==</ServiceKey>"
										+ "<RequestTime></RequestTime>"
										+ "<CallBackURI></CallBackURI>"
									+ "</head:ComMsgHeader>"
								+ "</soapenv:Header>"
								+ "<soapenv:Body>"
									+ "<ser:getKndCrltsList>"
										+ "<arg0> "
											+ "<RequestMsgID></RequestMsgID>"
											+ "<ServiceKey></ServiceKey>"
											+ "<!--Optional:-->"
											+ "<RequestTime></RequestTime>"
											+ "<!--Optional:-->" 
											+ "<CallBackURI></CallBackURI>"
											+ "<nowPageNo>1</nowPageNo>" 
											+ "<pageMg>100</pageMg>"
											+ "<!--Optional:-->"
											+ "<ctrdCd></ctrdCd>"
											+ "<!--Optional:-->"
											+ "<itemCd></itemCd>"
											+ "<!--Optional:-->"
											+ "<itemNm>숭례문</itemNm>"
											+ "<!--Optional:-->"
											+ "<crltsNo></crltsNo>"
											+ "<!--Optional:-->"
											+ "<crltsNoNm></crltsNoNm>"
											+ "<!--Optional:-->"
											+ "<crltsNm></crltsNm>"
											+ "<!--Optional:-->"
											+ "<xCntsBegin></xCntsBegin>"
											+ "<!--Optional:-->"
											+ "<xCntsEnd></xCntsEnd>"
											+ "<!--Optional:-->"
											+ "<yCntsBegin></yCntsBegin>"
											+ "<!--Optional:-->"
											+ "<yCntsEnd></yCntsEnd>"
										+ "</arg0>"
									+ "</ser:getKndCrltsList>"
								+ "</soapenv:Body>"
							+ "</soapenv:Envelope>";
			        
			       
			           
					
					
					/*"<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:head='http://apache.org/headers' xmlns:ser='http://service.kndcrlts.crlts.cha/'><soapenv:Header><head:ComMsgHeader><RequestMsgID>fe1b03a0-bc90-11df-b991-0002a5d5c51b</RequestMsgID><ServiceKey>M8c6Xf7lFeytSRHsiDgEH+GRsqwRxxu6cLTcC5qwyTaq87zwogTXF6gFQinVcU5Lyh9o4INPyMQGO4FGI5BjmA==</ServiceKey><RequestTime></RequestTime><CallBackURI></CallBackURI></head:ComMsgHeader></soapenv:Header><soapenv:Body><ser:getKndCrltsList>"
					+"<arg0><RequestMsgID></RequestMsgID><ServiceKey></ServiceKey><RequestTime></RequestTime><CallBackURI></CallBackURI><nowPageNo>1</nowPageNo><pageMg>1000</pageMg>"
					+"<itemCd>"+item+"</itemCd><itemNm>"+name+"</itemNm><crltsNo></crltsNo><crltsNoNm></crltsNoNm><ctrdCd>"+ctrd+"</ctrdCd>"
					+"<crltsNm></crltsNm><xCntsBegin></xCntsBegin><xCntsEnd></xCntsEnd><yCntsBegin></yCntsBegin><yCntsEnd></yCntsEnd></arg0></ser:getKndCrltsList></soapenv:Body></soapenv:Envelope>";*/
					
			
			System.out.println(message.toString());
			
			String strURL = "http://openapi.cha.go.kr:80/openapi/soap/crlts/KndCrltsService";

			HttpClient httpclient = HttpClientBuilder.create().build();

			HttpPost post = new HttpPost(strURL);
			StringEntity entity = new StringEntity(message);
			post.setEntity(entity);
			post.setHeader("Content-Type", "text/xml;charset=UTF-8");
			post.setHeader("Connection", "Keep-Alive");

			String buffer = null;
			try {
				HttpResponse response = httpclient.execute(post);
				BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));

				String inputLine;

				// 페이지의 정보를 저장한다.
				while ((inputLine = in.readLine()) != null) {		
					
					buffer = inputLine.trim();

				}
				System.out.println(buffer.toString());
				
				 
				    
				String[] str = buffer.split("<item>");
				
			
				
				for(int i=1;i<str.length;i++){
					/*logger.info("stringBuilder item = " + sttr.toString());*/
					AreaListVO area = new AreaListVO();
					
					//문화재 이름(한글 예:서울 숭례문)
					area.setCrltsNm(str[i].substring(str[i].indexOf("<crltsNm>")+9, str[i].indexOf("</crltsNm>")));		
					

					if(str[i].contains("<crltsNmChcrt>")){					
						//문화재 이름(한자 예:서울 崇禮門) 
						area.setCrltsNmChcrt(str[i].substring((str[i].indexOf("<crltsNmChcrt>")+14),str[i].indexOf("</crltsNmChcrt>")));
					}else{
						area.setCrltsNmChcrt(null);	
					}
					
					
					
					//문화재 지정번호(예: 00010000)
					area.setCrltsNo(str[i].substring((str[i].indexOf("<crltsNo>")+9), str[i].indexOf("</crltsNo>")));				
					//문화재 지정번호명(예: 1 (숫자 1은 숭례문이 1호라서인듯))
					area.setCrltsNoNm(str[i].substring((str[i].indexOf("<crltsNoNm>")+11),str[i].indexOf("</crltsNoNm>")));
					//문화재 지역(소재지)코드 (예: 11)
					area.setCtrdCd(str[i].substring((str[i].indexOf("<ctrdCd>")+8), str[i].indexOf("</ctrdCd>")));				
					//문화재 소재지 지역(예: 서울) 
					area.setCtrdNm(str[i].substring((str[i].indexOf("<ctrdNm>")+8), str[i].indexOf("</ctrdNm>")));				
					//문화재 종목코드(예: 11)
					area.setItemCd(str[i].substring((str[i].indexOf("<itemCd>")+8), str[i].indexOf("</itemCd>")));				
					//문화재 종목명칭(예: 국보)
					area.setItemNm(str[i].substring((str[i].indexOf("<itemNm>")+8), str[i].indexOf("</itemNm>")));
					
					
					if(str[i].contains("<listImageUrl>")){					
						//문화재 리스트 이미지 경로(썸네일 인듯) 
						area.setListImageUrl(str[i].substring((str[i].indexOf("<listImageUrl>")+14), str[i].indexOf("</listImageUrl>")));
					}else{
						area.setListImageUrl(null);	
					}
					
					
					if(str[i].contains("<XCnts>")){
					/*	logger.info("=========================있는경우=========================");*/					
						
						//문화재 x좌표값 					
						area.setXCnts(str[i].substring((str[i].indexOf("<XCnts>")+7), str[i].indexOf("</XCnts>")));				
						//문화재 y좌표값 
						area.setYCnts(str[i].substring((str[i].indexOf("<YCnts>")+7), str[i].indexOf("</YCnts>")));					
					
					}else{  
					/*	logger.info("=========================없는경우=========================");*/
						
						//문화재 x좌표값 
						area.setXCnts(null);				
						//문화재 y좌표값 
						area.setYCnts(null);					
					}
					  
				
					
					strList.add(area);
					
				}
				
				

				// 종목코드
				// 11 : 국보 12 : 보물 13 : 사적 14 : 사적및명승 15 : 명승
				// 16 : 천연기념물 17 : 중요무형문화재 18 : 중요민속문화재 21 : 시도유형문화재
				// 22 : 시도무형문화재 23 : 시도기념물 24 : 시도민속문화재 31 : 문화재자료
				// 79 : 등록문화재 80 : 이북5도 무형문화재

				// 시도코드
				// 11 : 서울 21 : 부산 22 : 대구 23 : 인천 24 : 광주 25 : 대전 26 : 울산 45 : 세종
				// 31 : 경기 32 : 강원
				// 33 : 충북 34 : 충남 35 : 전북 36 : 전남 37 : 경북 38 : 경남 39 : 제주  40:황해도 이북5도 ZZ : 전국일원

				// 문화재 이름(한글 예:서울 숭례문)
				

				in.close();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
			}

			return strList;

		}
	
	
	
		//문화재 검색 페이지 번호
		public static int sendSoap3(int ctrdCd, int itemCd, String culName) throws UnsupportedEncodingException {
				
			int occurance = 0;
				
				
			Object item;
			Object ctrd;
				
			if(ctrdCd == 46){
				ctrd = "ZZ";
			}else{
				ctrd = ctrdCd;
			}			
			if(itemCd == 0){
				item = "";
			}else{
				item = itemCd;
			}
				
				
			String message = /*"<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:head='http://apache.org/headers' xmlns:ser='http://service.kndcrlts.crlts.cha/'>"
					+"<soapenv:Header><head:ComMsgHeader><RequestMsgID>fe1b03a0-bc90-11df-b991-0002a5d5c51b</RequestMsgID><ServiceKey>M8c6Xf7lFeytSRHsiDgEH+GRsqwRxxu6cLTcC5qwyTaq87zwogTXF6gFQinVcU5Lyh9o4INPyMQGO4FGI5BjmA==</ServiceKey>"
					+"<RequestTime>?</RequestTime><CallBackURI>?</CallBackURI></head:ComMsgHeader></soapenv:Header><soapenv:Body><ser:getKndCrltsList>"
					+"<arg0><RequestMsgID></RequestMsgID><ServiceKey></ServiceKey><RequestTime></RequestTime><CallBackURI>?</CallBackURI><nowPageNo>1</nowPageNo><pageMg>1000</pageMg><itemCd>11</itemCd>"
					+"<itemNm>숭례문</itemNm><crltsNo></crltsNo><crltsNoNm></crltsNoNm><ctrdCd>11</ctrdCd> <crltsNm></crltsNm><xCntsBegin></xCntsBegin><xCntsEnd></xCntsEnd><yCntsBegin></yCntsBegin><yCntsEnd></yCntsEnd>"
					+"</arg0></ser:getKndCrltsList></soapenv:Body></soapenv:Envelope>";*/
					"<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' "
					+ "xmlns:head='http://apache.org/headers' xmlns:ser='http://service.areacrlts.crlts.cha/'>"
					+ " <soapenv:Header><head:ComMsgHeader>"
					+ "<RequestMsgID>fe1b03a0-bc90-11df-b991-0002a5d5c51b</RequestMsgID>"
					+ "<ServiceKey>M8c6Xf7lFeytSRHsiDgEH+GRsqwRxxu6cLTcC5qwyTaq87zwogTXF6gFQinVcU5Lyh9o4INPyMQGO4FGI5BjmA==</ServiceKey>"
					+ "<!--Optional:-->" + "<RequestTime>?</RequestTime><CallBackURI>?</CallBackURI>"
					+ "</head:ComMsgHeader></soapenv:Header><soapenv:Body><ser:getAreaCrltsList>" + "<arg0> "
					+ "<RequestMsgID></RequestMsgID><ServiceKey></ServiceKey>" + "<!--Optional:-->"
					+ "<RequestTime>?</RequestTime>" + "<!--Optional:-->" + "<CallBackURI></CallBackURI>"
					+ "<nowPageNo>1</nowPageNo>" 
					+ "<pageMg>100</pageMg>" 
					+ "<ctrdCd>"+ ctrd +"</ctrdCd>" + "<!--Optional:-->"
					+ "<itemCd>"+ item +"</itemCd>" + "<!--Optional:-->" + "<itemNm>"+ culName +"</itemNm>" + "<!--Optional:-->"
					+ " <crltsNo></crltsNo>" + "<!--Optional:-->" + "<crltsNoNm></crltsNoNm>" + "<!--Optional:-->"
					+ "<crltsNm></crltsNm>" + "<!--Optional:-->" + "<xCntsBegin></xCntsBegin>" + " <!--Optional:-->"
					+ "<xCntsEnd></xCntsEnd>" + "<!--Optional:-->" + "<yCntsBegin></yCntsBegin>" + "<!--Optional:-->"
					+ "<yCntsEnd></yCntsEnd>" + "</arg0> " + "</ser:getAreaCrltsList></soapenv:Body></soapenv:Envelope>";
					
					

			String strURL = "http://openapi.cha.go.kr/openapi/soap/crlts/KndCrltsService?wsdl";
			

			HttpClient httpclient = HttpClientBuilder.create().build();

			HttpPost post = new HttpPost(strURL);
			StringEntity entity = new StringEntity(message);
			post.setEntity(entity);
			post.setHeader("Content-Type", "text/xml;charset=UTF-8");
			post.setHeader("Connection", "Keep-Alive");

			
			try {
				HttpResponse response = httpclient.execute(post);
				BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));

				/*String inputLine;*/
					
					

			/*	// 페이지의 정보를 저장한다.
				while ((inputLine = in.readLine()) != null) {
					System.out.println("---------------------문자열 :"+inputLine);			
					
					buffer = inputLine.trim();
				}*/
				occurance = StringUtils.countOccurrencesOf(in.readLine(), "<item>");
			
		
				/*System.out.println(occurance);*/
			
				in.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
			}
			
			return occurance;

		}
	
	
}
