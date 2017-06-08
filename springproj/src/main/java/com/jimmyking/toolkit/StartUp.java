package com.jimmyking.toolkit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jimmyking.toolkit.beans.config.ZookeeperPropertiesConfigure;


public class StartUp {

	private static Logger log = LoggerFactory.getLogger(StartUp.class);
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ZookeeperPropertiesConfigure configure = context.getBean(ZookeeperPropertiesConfigure.class);
		log.info("启动完成...");
	}
	
}
