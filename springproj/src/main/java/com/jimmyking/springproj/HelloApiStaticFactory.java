package com.jimmyking.springproj;

public class HelloApiStaticFactory {

	public static HelloApi newInstance(String message){
		return new HelloImpl2(message);
	}
}
