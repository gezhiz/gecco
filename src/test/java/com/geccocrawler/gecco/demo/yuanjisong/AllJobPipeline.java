package com.geccocrawler.gecco.demo.yuanjisong;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.apache.commons.lang3.StringUtils;

@PipelineName("allJobPipeline")
public class AllJobPipeline implements Pipeline<AllJobList> {

	@Override
	public void process(AllJobList allJobList) {
		if (StringUtils.isNotBlank(allJobList.getNextPage())) {
			HttpRequest request = allJobList.getRequest();
			request.setUrl(allJobList.getNextPage());
			request.subRequest(allJobList.getNextPage());
			SchedulerContext.into(request.subRequest(allJobList.getNextPage()));
		}
	}

}