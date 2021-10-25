package com.gontuseries.hellocontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	
	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		
		ModelAndView model=new ModelAndView("AdmissionForm");
		
		return model;
	}
	
	//@RequestParam annotation is used to bind value received in from like studentName to string variable name
	//If studentName is not provided in the UI, then blank string will be displayed and we can provide some default value by using defaultValue as shown
	/*@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName" ,defaultValue="MrXYZ") String name, @RequestParam("studentHobby") String hobby) {
		
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "Details submitted by you:: Name: "+name+ ", Hobby: " +hobby);
		
		return model;
	}*/
	
	
	//RequestParam using Map
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam Map<String, String> reqPar) {
		String name=reqPar.get("studentName");
		String hobby=reqPar.get("studentHobby");
		
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "Details submitted by you:: Name: "+name+ ", Hobby: " +hobby);
		
		return model;
	}
	
	
	

}
