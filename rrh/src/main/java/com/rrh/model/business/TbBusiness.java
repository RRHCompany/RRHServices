package com.rrh.model.business;

import java.util.Date;

public class TbBusiness {
   
    private Integer businessId;

    private String name;
    
    private String teamName;

    private String taxesCode;

    private Integer tradeId;

    private String address;

    private String domain;

    private String tel;

    private String corporateMobile;

    private String checkReport;

    private String passCertificate;

    private String serviceTel;

    private String complaintTel;

    private Integer userId;

    private Date lastTime;

    private Integer status;

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

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

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
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

	public String getCheckReport() {
		return checkReport;
	}

	public void setCheckReport(String checkReport) {
		this.checkReport = checkReport;
	}

	public String getPassCertificate() {
		return passCertificate;
	}

	public void setPassCertificate(String passCertificate) {
		this.passCertificate = passCertificate;
	}

	public String getServiceTel() {
		return serviceTel;
	}

	public void setServiceTel(String serviceTel) {
		this.serviceTel = serviceTel;
	}

	public String getComplaintTel() {
		return complaintTel;
	}

	public void setComplaintTel(String complaintTel) {
		this.complaintTel = complaintTel;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
   
}