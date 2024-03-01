package com.shounoop.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		Doctor doctor = new Doctor();
		doctor.setQualification("A");
		System.out.println(doctor.getQualification());
//		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
