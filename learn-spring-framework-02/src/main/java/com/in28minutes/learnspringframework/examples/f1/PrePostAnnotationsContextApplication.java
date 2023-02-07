package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("Cleanup");
	}
}

@Component
class SomeDependency {

	public void getReady() {
		System.out.println("Some logic using SomeDependency");
	}
	
}

@Configuration
@ComponentScan 
public class PrePostAnnotationsContextApplication {
	
	
	public static void main(String[] args) {
		
		try (var context =
				new AnnotationConfigApplicationContext(
						PrePostAnnotationsContextApplication.class)) {
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println();
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
	}
}

