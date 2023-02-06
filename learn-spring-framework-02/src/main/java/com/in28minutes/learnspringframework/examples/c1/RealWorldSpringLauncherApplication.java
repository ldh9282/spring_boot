package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.examples.a1.DepInjectionLauncherApplication;

@Configuration
@ComponentScan 
public class RealWorldSpringLauncherApplication {
	
	
	public static void main(String[] args) {
		
		try (var context =
				new AnnotationConfigApplicationContext(
						RealWorldSpringLauncherApplication.class)) {
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
	}
}

