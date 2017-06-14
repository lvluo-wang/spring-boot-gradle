package com.yx.statistics.common;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//可用于项目启动时候加载缓存文件
@Component
public class ApplicationInit implements ApplicationListener<ContextRefreshedEvent>{

	private Logger logger = Logger.getLogger(ApplicationInit.class);
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		logger.info("--------------------------------------------------MyApplicationInit------------------------------------------------------\n\n");
	}

}
