
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<body>

<link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
<p><a href="/FirstSpringMVCProject/admissionFormNew.html?siteTheme=green">Green</a>
<a href="/FirstSpringMVCProject/admissionFormNew.html?siteTheme=red">Red</a></p>
	<h1>${headerMessage}</h1>
	<h2>STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h2>
	
	<!-- the job of this tag is to display complete info about all binding related errors that occur on server to client -->
	<form:errors path="student1.*"/> 

		<form action="/FirstSpringMVCProject/submitAdmissionFormNew.html" method="post">
		
		<table>
	
		<tr>
			<td> Student Name :</td>   <td><input type="text" name="studentName"/></td>
					
		</tr>
		
		<tr>
			<td> Student Hobby :</td>  <td><input type="text" name="studentHobby"/></td>
				
		</tr>
		
		<tr>
			<td> Student Mobile :</td>  <td><input type="text" name="studentMobile"/></td>
				
		</tr>
		
		<tr>
			<td> Student DOB :</td>  <td><input type="text" name="studentDOB"/></td>
				
		</tr>
		
		<tr>
			<td> Student Skill set :</td>  <td><select name="studentSkills" multiple>
												<option value="Java Core">Java Core</option>
												<option value="Spring Core">Spring Core</option>
												<option value="Spring MVC">Spring MVC</option>
												</select></td>
				
		</tr>
		
	
		</table>
		
		<table>
		
		<tr><td>Student Address : </td></tr>
		<tr>
		<td>country: <input type="text" name="studentAddress.country"/></td>
		<td>city: <input type="text" name="studentAddress.city"/></td>
		<td>street: <input type="text" name="studentAddress.street"/></td>
		<td>pincode: <input type="text" name="studentAddress.pincode"/></td>
		
		
		</tr>
		
		
		
		<tr><td><input type="submit" value="Submit this form by clicking here"/></td></tr>
		
		</table>
		
		

			
			
	</form>

</body>
</html>