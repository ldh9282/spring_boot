package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello") 
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say-hello-html") 
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>\r\n"
				+ "\r\n"
				+ "    <head>\r\n"
				+ "    <title>My first HTML Page</title>\r\n"
				+ "    </head>\r\n"
				+ "\r\n"
				+ "    <body>\r\n"
				+ "        <h1>\r\n"
				+ "            My first html page with body\r\n"
				+ "        </h1>\r\n"
				+ "    \r\n"
				+ "    </body>\r\n"
				+ "\r\n"
				+ "</html>");
		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp") 
	public String sayHelloJsp() {
		return "sayHello";
	}
	
}


