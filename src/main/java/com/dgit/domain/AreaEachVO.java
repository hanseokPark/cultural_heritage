package com.dgit.domain;

public class AreaEachVO {
	//문화재 설명
    private String critdDc;
    //문화재 이름(한글 예:서울 숭례문)
    private String crltsNm;
    //문화재 이름(한자 예:서울 崇禮門)
    private String crltsNmChcrt;
    //문화재 지정번호(예: 00010000)
    private String crltsNo;
    //문화재 지정번호명(예: 1        (숫자 1은 숭례문이 1호라서 인듯))
    private String crltsNoNm;
    //문화재 지역(소재지)코드 (예: 11)
    private String ctrdCd;
    //문화재 소재지 지역(예: 서울)
    private String ctrdNm;
    //문화재 대표이미지경로(메인)
    private String imageUrl;
    //문화재 이미지 여부(예: Y)
    private String imageYn;
    //문화재  종목코드(예: 11)
    private String itemCd;
    //문화재 종목명칭(예: 국보)
    private String itemNm;
    //문화재 리스트 이미지 경로(썸네일 인듯)
    private String listImageUrl;
    //문화재 소재지 시군구 코드(예: 12)
    private String signguCd;
    //문화재 소재지 시군구 명칭(예: 중구)
    private String signguNm;
    //문화재 x좌표값
    private String XCnts;
    //문화재 y좌표값
    private String YCnts;
    
    
    
    
    
	public String getCritdDc() {
		return critdDc;
	}
	public void setCritdDc(String critdDc) {
		this.critdDc = critdDc;
	}
	public String getCrltsNm() {
		return crltsNm;
	}
	public void setCrltsNm(String crltsNm) {
		this.crltsNm = crltsNm;
	}
	public String getCrltsNmChcrt() {
		return crltsNmChcrt;
	}
	public void setCrltsNmChcrt(String crltsNmChcrt) {
		this.crltsNmChcrt = crltsNmChcrt;
	}
	public String getCrltsNo() {
		return crltsNo;
	}
	public void setCrltsNo(String crltsNo) {
		this.crltsNo = crltsNo;
	}
	public String getCrltsNoNm() {
		return crltsNoNm;
	}
	public void setCrltsNoNm(String crltsNoNm) {
		this.crltsNoNm = crltsNoNm;
	}
	public String getCtrdCd() {
		return ctrdCd;
	}
	public void setCtrdCd(String ctrdCd) {
		this.ctrdCd = ctrdCd;
	}
	public String getCtrdNm() {
		return ctrdNm;
	}
	public void setCtrdNm(String ctrdNm) {
		this.ctrdNm = ctrdNm;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageYn() {
		return imageYn;
	}
	public void setImageYn(String imageYn) {
		this.imageYn = imageYn;
	}
	public String getItemCd() {
		return itemCd;
	}
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}
	public String getListImageUrl() {
		return listImageUrl;
	}
	public void setListImageUrl(String listImageUrl) {
		this.listImageUrl = listImageUrl;
	}
	public String getSignguCd() {
		return signguCd;
	}
	public void setSignguCd(String signguCd) {
		this.signguCd = signguCd;
	}
	public String getSignguNm() {
		return signguNm;
	}
	public void setSignguNm(String signguNm) {
		this.signguNm = signguNm;
	}
	public String getXCnts() {
		return XCnts;
	}
	public void setXCnts(String xCnts) {
		XCnts = xCnts;
	}
	public String getYCnts() {
		return YCnts;
	}
	public void setYCnts(String yCnts) {
		YCnts = yCnts;
	}
	
	
	@Override
	public String toString() {
		return "AreaEachVO [critdDc=" + critdDc + ", crltsNm=" + crltsNm + ", crltsNmChcrt=" + crltsNmChcrt
				+ ", crltsNo=" + crltsNo + ", crltsNoNm=" + crltsNoNm + ", ctrdCd=" + ctrdCd + ", ctrdNm=" + ctrdNm
				+ ", imageUrl=" + imageUrl + ", imageYn=" + imageYn + ", itemCd=" + itemCd + ", itemNm=" + itemNm
				+ ", listImageUrl=" + listImageUrl + ", signguCd=" + signguCd + ", signguNm=" + signguNm + ", XCnts="
				+ XCnts + ", YCnts=" + YCnts + "]";
	} 
	
	
	
    
    
    
    
}
