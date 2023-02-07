package com.in28minutes.learnspringframework.examples.h1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;

public class XmlConfigurationLauncherApplication {
	
	
	public static void main(String[] args) {
		
		try (var context = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
	}
}

