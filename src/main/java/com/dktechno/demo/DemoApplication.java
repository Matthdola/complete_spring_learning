package com.dktechno.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Collections;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(DemoApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		//var ctx = SpringApplication.run(DemoApplication.class, args);
		var ctx = app.run(args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile2());
		System.out.println(myFirstService.getCustomProperty());
		System.out.println(myFirstService.getCustomPropertyInt());

//		System.out.println(myFirstService.getJavaVersion());
//		System.out.println(myFirstService.getOsName());
//		System.out.println(myFirstService.readProp());
	}

}
