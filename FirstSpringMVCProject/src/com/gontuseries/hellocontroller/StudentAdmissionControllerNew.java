package com.gontuseries.hellocontroller;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentAdmissionControllerNew {
	
	//Used for customizing the data binding feature for a particular controller class. Method name can be anything.
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setDisallowedFields(new String[] {"studentMobile"}); //ignoring student mobile while data binding
		
		/*Spring MVC has many built in classes which it calls as property editors and CustomDateEditor is one example. 
		  Spring uses these property editor classes in order to perform type conversion while data binding.
		  propertyEditor date will accepted in dateFormat when binding happens for student DOB
		  these property editor classes are provided to customize data binding for a particular type*/
		SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY/MM/DD");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat,false));
		
		binder.registerCustomEditor(String.class,"studentName", new StudentNameEditor());
		
		
	}
	
	/*Spring MVC says if you add a method like this in the controller class with @ModelAttribute annotation on its top, then whatever object your will
	add to its model object, spring MVC will automatically add that object to model and view object for each request handler method in this controller
	class. Spring MVC call this method first before making call to any of the request handler methods in that controller.*/
	@ModelAttribute
	public void addingCommonObjects(Model model1) {
		model1.addAttribute("headerMessage","Gontu college of Engineering, India");
		//model1.addAttribute(arg0, arg1);can be used for adding more objects to model and view object
	}
	
	
	@RequestMapping(value="/admissionFormNew.html", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		
		ModelAndView model=new ModelAndView("AdmissionFormNew");
		
		//model.addObject("headerMessage","Gontu college of Engineering, India");
		
		return model;
	}
	
	/*@RequestMapping(value="/submitAdmissionFormNew.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name, @RequestParam("studentHobby") String hobby) {
		
		Student student1=new Student();
		student1.setStudentName(name);
		student1.setStudentHobby(hobby);
		ModelAndView model=new ModelAndView("AdmissionSuccessNew");
		model.addObject("headerMessage","Gontu college of Engineering, India");
		model.addObject("student1", student1);
		
		return model;
	
	}*/
	
	//@ModelAttribute binds all the request parameter/form elements to the corresponding with corresponding properties of student objects
	/*BindingResult catch all binding related error and put them in result reference.
	If only BindingResult is provided as argument and not hasErrors method then output will be null for the attribute for which binding failed.
	Adding hasError method will return to the same admissionForm page with no error displayed 
	but adding (<form:errors path="student1.*"/> ) in admission form xml will show the error also.*/
	
	/*@Valid annotation says to Spring MVC that whenever you are performing data binding task for student, 
	you consider all those form validation related annotation present in the student object*/
	@RequestMapping(value="/submitAdmissionFormNew.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid@ModelAttribute("student1") Student student, BindingResult result) {
		/*This method returns the same html(AdmissionFormNew) form back to client as a response to client if any binding related error occurs 
		on the server*/
		if(result.hasErrors()) {
			ModelAndView model=new ModelAndView("AdmissionFormNew");
			return model;
		}
		
		
		ModelAndView model=new ModelAndView("AdmissionSuccessNew");
		//model.addObject("headerMessage","Gontu college of Engineering, India");
		
		
		return model;
	
	}
	
	
	

}
