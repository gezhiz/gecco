package com.geccocrawler.gecco.demo.yuanjisong;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by gezz on 2017/12/13.
 */
public class Job implements HtmlBean {

    @Href
    @HtmlField(cssPath="a")
    private String url;

    @Text
    @HtmlField(cssPath="a .weui_panel_hd .topic_title")
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
