package com.amdocs.training.controller;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.amdocs.training.model.User;


public class UserController {

	public static void main(String[] args) {
		//Using the Bran Factory Container
//		Scanner sc = new Scanner(System.in);
//		Resource resource = new ClassPathResource("users.xml");
//		BeanFactory beanFactory = new XmlBeanFactory(resource);
//		
//		User user = (User) beanFactory.getBean("user");
//		
//		System.out.println(user.getAddress());
		
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		
//		User user = (User)context.getBean("user2");
//		System.out.println(user);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.amdocs.training");
		context.refresh();
		
		User user = context.getBean(User.class);
		System.out.println(user.getUsername());
		
		
	}

}
