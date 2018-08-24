package com.guigu.cglib_proxy.service;

import org.springframework.cglib.proxy.Enhancer;

/**
 * 获得代理类对象
 * @author TX401JS
 *
 */
public class CglibProxyFactory {
	
	//真实对象
	private PersonService personService ;
	public CglibProxyFactory(PersonService personService) {
		this.personService = personService;
	}
	
	/**
	 * 产生代理类对象
	 * @return
	 */
	public  PersonService createProxy() {
		//获得核心类
		Enhancer  enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(PersonService.class);
		//设置回调函数
		//调用真实类对象的时候  添加的其他的方法 
		enhancer.setCallback(new MyCallBack(personService));
		//返回代理类对象
		return (PersonService) enhancer.create();
	}

}
