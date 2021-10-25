<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h1>

		<form action="/FirstSpringMVCProject/submitAdmissionForm.html" method="post">

			<p>
				Student Name:<input type="text" name="studentName"/>
			</p>

			<p>
				Student Hobby:<input type="text" name="studentHobby"/>
			</p>
			
			<input type="submit" value="Submit this form by clicking here"/>

		</form>

</body>
</html>