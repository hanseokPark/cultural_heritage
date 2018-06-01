package com.dgit.domain;

public class AreaListVO {
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
    //문화재  종목코드(예: 11)
    private String itemCd;
  //문화재 종목명칭(예: 국보)
    private String itemNm;
  //문화재 리스트 이미지 경로(썸네일 인듯)
    private String listImageUrl;
    private String XCnts;    
    private String YCnts;

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
		return "AreaListVO [crltsNm=" + crltsNm + ", crltsNmChcrt=" + crltsNmChcrt + ", crltsNo=" + crltsNo
				+ ", crltsNoNm=" + crltsNoNm + ", ctrdCd=" + ctrdCd + ", ctrdNm=" + ctrdNm + ", itemCd=" + itemCd
				+ ", itemNm=" + itemNm + ", listImageUrl=" + listImageUrl + ", XCnts=" + XCnts + ", YCnts=" + YCnts
				+ "]";
	}
    
   
}
