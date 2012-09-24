package com.jimmyking.springproj;

public class HelloImpl2 implements HelloApi {

	private String message;
	
	public HelloImpl2(){
		this.message="Hello World1";
	}
	
	public HelloImpl2(String message){
		this.message=message;
	}
	public void sayHello() {

		System.out.println(message);
	}

}
