package com.rrh.mobile.bean.res;

import com.rrh.mobile.base.BaseResponse;

/**
 *图片
 * @author jason
 * @data 2015-12-18
 */
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
