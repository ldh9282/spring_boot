package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
class BusinessService {
	private DataService dataService;
	
	@Inject 
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	public DataService getDataService() {
		return dataService;
	}


	
	
}

@Named
class DataService {
	
}


@Configuration
@ComponentScan 
public class CdiContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context =
				new AnnotationConfigApplicationContext(
						CdiContextLauncherApplication.class)) {
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessService.class).getDataService());
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
	}
}

