package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in28minutes.springboot.web.springbootfirstwebapplication.service.LoginService;

// /login => "Hello World"
@Controller
/*public class LoginController{
	
	@RequestMapping("/login")
	@ResponseBody
	public String loginMesssage() {
		return "Hello World";
	}
}*/




/*public class LoginController{
	@RequestMapping("/login")
	public String loginMessage() {
		return "login";
	}
}*/
/*we have removed the @ResponseBody because we do not want to
 * display the return as it is, instead we want to redirect it 
 * to view named login.jsp.
 * The argument in @RequestMapping i.e. "/login" is the url
 *  which we have given in the browser.
 * The "login" written with return is the name of the view to
 *  which we want to redirect the controller */




/*public class LoginController{
	@RequestMapping("/login")
	public String loginMessage(@RequestParam String name, ModelMap model) {
	model.put("name",name);
	System.out.println("name is "+ name);
	return "login";
	}
}*/
/*@RequestParam takes the name parameter from the url 
 * and we create a model using ModelMap and put the name 
 * in model using model.put which is then passed to view 
 * for use.
 * model is used to pass data from controller to view*/




public class LoginController{
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}

/*removed @RequestParam because we are no longer using it */


	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValidUser = service.validateUser(name, password);
		
		if(!isValidUser) {
			model.put("errorMessage","Invalid Credentials!!!");
			return "login";
		}
		model.put("name",name);
		model.put("password", password);
		return "welcome";
	}
}
/*see in the notes for description of this method*/

