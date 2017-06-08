package com.jimmyking.toolkit.beans.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ZookeeperPropertiesConfigure extends PropertyPlaceholderConfigurer {

	private static Logger logger = LoggerFactory.getLogger(ZookeeperPropertiesConfigure.class);

	private static final int SESSION_TIMEOUT = 3600 * 1000 * 10;

	private static ZookeeperClient zkCli = new ZookeeperClient();

	private String getPropertiesFromZk(String placeholder) {
		// String zkServerUrl = System.getProperty("zk.server.url");
		String zkServerUrl = "127.0.0.1:2181/jinming";

		if (!StringUtils.isEmpty(zkServerUrl)) {
			logger.info("从System.properties加载配置zk.server.url=" + zkServerUrl);
		} else {
			logger.error("无法找到zk.server.url配置信息");
		}
		String connectionString = zkServerUrl.substring(0, zkServerUrl.indexOf("/"));
		zkCli.createConnection(connectionString, SESSION_TIMEOUT);
		String zkPath = zkServerUrl.substring(zkServerUrl.indexOf("/"));
		logger.debug("zkPath===" + zkPath);
		
		String zkPathKey = String.format("%s/%s", zkPath, placeholder);
        String value = zkCli.readDataNoERROR(zkPathKey);
        logger.info(String.format("\nfinded from zk...................... key[%s] =====[%s]", zkPathKey,value));
		return value;
	}

	@Override
	protected String resolvePlaceholder(String placeholder, Properties props) {
		logger.info("searching " + placeholder);
		return getPropertiesFromZk(placeholder);
	}
}
