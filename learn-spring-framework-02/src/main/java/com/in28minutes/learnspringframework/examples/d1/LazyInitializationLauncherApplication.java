package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Component
@Lazy
class ClassB {
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do something");
	}
}


@Configuration
@ComponentScan 
public class LazyInitializationLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context =
				new AnnotationConfigApplicationContext(
						LazyInitializationLauncherApplication.class)) {
			System.out.println("Initailization of context is completed");
			
			context.getBean(ClassB.class).doSomething();
			
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
	}
}

