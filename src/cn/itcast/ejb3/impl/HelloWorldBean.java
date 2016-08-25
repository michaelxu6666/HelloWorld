package cn.itcast.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import cn.itcast.ejb3.HelloWorld;

@Stateless
@Remote(HelloWorld.class)
public class HelloWorldBean implements HelloWorld {
	
	public String sayHello(String name) {
		return name + " 说， 你好 世界";
	}
	
}
