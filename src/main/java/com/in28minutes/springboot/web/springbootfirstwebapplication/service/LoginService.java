package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;

//Spring Bean
@Component
public class LoginService {
	public boolean validateUser(String userid, String password) {
		//userid=Aastha, password=123
		return userid.equalsIgnoreCase("Aastha") && password.equalsIgnoreCase("123");
	}

}
