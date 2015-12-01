package com.rrh.bean.res;

import com.rrh.base.BaseResponse;

public class UserImgResponse extends BaseResponse {

	private String smallImg;
	private String bigImg;
	public String getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	public String getBigImg() {
		return bigImg;
	}
	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}
	
}
