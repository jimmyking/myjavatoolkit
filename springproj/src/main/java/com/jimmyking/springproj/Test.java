package com.jimmyking.springproj;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BeanFactory beanFactory=new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		HelloApi bean1=beanFactory.getBean("bean1",HelloApi.class);
		bean1.sayHello();
		
		HelloApi bean2=beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();
		
		HelloApi bean3=beanFactory.getBean("bean3",HelloApi.class);
		bean3.sayHello();
		
		HelloApi bean4=beanFactory.getBean("bean4",HelloApi.class);
		bean4.sayHello();
	}

}
