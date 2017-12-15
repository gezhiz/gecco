package com.geccocrawler.gecco.demo.yuanjisong;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl="https://www.yuanjisong.com/Webpage/Job/detail/jobid/{jobId}", pipelines={"consolePipeline", "JobDetailPipeline"})
public class JobDetail implements HtmlBean {

	private String price;
	private String prospectTime;
	private String prospectAmount;
	private String desc;
	private String address;


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProspectTime() {
		return prospectTime;
	}

	public void setProspectTime(String prospectTime) {
		this.prospectTime = prospectTime;
	}

	public String getProspectAmount() {
		return prospectAmount;
	}

	public void setProspectAmount(String prospectAmount) {
		this.prospectAmount = prospectAmount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
