package com.gontuseries.hellocontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
/*@RequestMapping("/greet")*/
public class HelloControllerAnnotation {
	
	/*@RequestMapping("/welcomeAnnotation")
	public ModelAndView helloWorld() {
		ModelAndView model=new ModelAndView("HelloPageAnnotation");
		model.addObject("msg","Hello World");
		
		return model;
	}*/
	
	
	
	
	//@PathVariable annotation would bind the value of userName which is coming from the incoming url request with the name variable
	/*@RequestMapping("/welcomeAnnotation/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable("userName") String name,@PathVariable("countryName") String country) {
		ModelAndView model=new ModelAndView("HelloPageAnnotation");
		model.addObject("msg","Hello "+name+" You are from "+country);
		
		return model;
	}*/
	
	
	//put all these path variables in curly braces in this map as name value pairs. retrieve particular path variable by providing its name as a key to the map 
	@RequestMapping("/welcomeAnnotation/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable Map<String, String>  pathVars) {
		
		String name=pathVars.get("userName");
		String country=pathVars.get("countryName");
		ModelAndView model=new ModelAndView("HelloPageAnnotation");
		model.addObject("msg","Hello "+name+" You are from "+country);
		
		return model;
	}
	
	
	

	@RequestMapping("/welcomeAnnotationNew")
	public ModelAndView helloWorldNew() {
		ModelAndView model=new ModelAndView("HelloPageAnnotation");
		model.addObject("msg","Hello World New");
		
		return model;
	}

}
