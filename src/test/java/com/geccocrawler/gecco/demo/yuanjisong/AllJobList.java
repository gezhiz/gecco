package com.geccocrawler.gecco.demo.yuanjisong;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

@Gecco(matchUrl="https://www.yuanjisong.com/Webpage/Job/listpage/city_id/{cityId}/district_id/{districtId}/role_id/{roleId}/sort_id/{sortId}/pageid/{page}", pipelines={"consolePipeline", "allJobPipeline"})
public class AllJobList implements HtmlBean {

	@Request
	private HttpRequest request;

	@HtmlField(cssPath=".db > .weui_panel")
	private List<Job> jobs;

	@Href
	@HtmlField(cssPath=".button_sp_area a:nth-child(3)")
	private String nextPage;//下一页


	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public static void main(String[] args) {
		//先获取分类列表
		HttpGetRequest start = new HttpGetRequest("https://www.yuanjisong.com/Webpage/Job/listpage/city_id/0/district_id/0/role_id/0/sort_id/1/pageid/1");
		start.setCharset("GBK");
		GeccoEngine.create()
		.classpath("com.geccocrawler.gecco.demo.yuanjisong")
		//开始抓取的页面地址
		.start(start)
		//开启几个爬虫线程
		.thread(1)
		//单个爬虫每次抓取完一个请求后的间隔时间
		.interval(2000)
		.start();
	}
}
