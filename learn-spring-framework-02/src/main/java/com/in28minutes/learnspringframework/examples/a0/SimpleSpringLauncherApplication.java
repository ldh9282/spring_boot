package com.in28minutes.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.examples.a1.DepInjectionLauncherApplication;

@Configuration
@ComponentScan 
public class SimpleSpringLauncherApplication {
	
	
	public static void main(String[] args) {
		
		try (var context =
				new AnnotationConfigApplicationContext(
						DepInjectionLauncherApplication.class)) {
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
	}
}

