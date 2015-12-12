package com.rrh.mobile.bean.req;

import java.util.Date;

import com.rrh.mobile.base.BaseRequest;

/**
 * 创建团队
 * @author jason
 * @data 2015-12-3
 */
public class BusinessCreateTeamRequest extends BaseRequest {

	private String name;// 企业名称
	
	private String teamName;// 团队名称
	
	private String taxesCode;// 税务编号
	
	private int tradeId;// 所属行业编号
	
	private String address;// 公司地址
	
	private String domain;// 公司网站
	
	private String tel;// 公司座机
	
	private String corporateMobile;// 法人手机号码
	
	private Date lastTime;//最后修改时间
	
	private int userId;//用户编号

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTaxesCode() {
		return taxesCode;
	}

	public void setTaxesCode(String taxesCode) {
		this.taxesCode = taxesCode;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCorporateMobile() {
		return corporateMobile;
	}

	public void setCorporateMobile(String corporateMobile) {
		this.corporateMobile = corporateMobile;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
