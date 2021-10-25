package com.gontuseries.hellocontroller;

import java.beans.PropertyEditorSupport;


//Custom property editor class
/*when you submit the form, spring MVC will run setAsText function of this class before
performing data binding task for studentName property of student object*/
public class StudentNameEditor extends PropertyEditorSupport {
	
	//Value of student name entered in the form will  get stored in the variable studentName
	@Override
	public void setAsText(String studentName) throws IllegalArgumentException {//studentName is local variable, user can give any name
		
		if(studentName.contains("Mr.")|| studentName.contains("Ms.")) {
			setValue(studentName);// whatever value you provide in setValue function, spring MVC will use same value to perform data binding task for property studentName
		}
		else {
			studentName="Ms."+studentName;
			setValue(studentName);
		}
	}

}
