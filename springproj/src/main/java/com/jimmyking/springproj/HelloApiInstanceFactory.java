package com.jimmyking.springproj;

public class HelloApiInstanceFactory {

	public HelloApi newInstance(String message){
		return new HelloImpl2(message);
	}
}
