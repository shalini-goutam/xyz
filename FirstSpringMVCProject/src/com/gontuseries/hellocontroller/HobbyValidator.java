package com.gontuseries.hellocontroller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{
	
	@Override
	public void initialize(IsValidHobby IsValidHobby) {
		
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext txt) {
		if(studentHobby==null) {
			return false;
		}
		
		if(studentHobby.matches("Music|Football|Cricket|Hobby"))
			return true;
		else
			return false;
	}
	
	
	

}
