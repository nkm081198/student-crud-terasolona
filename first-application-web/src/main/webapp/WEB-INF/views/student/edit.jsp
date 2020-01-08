<form:form action="${pageContext.request.contextPath}/student/update" method="post">
	<fieldset>
		
		<p>
			<h3>name</h3>
			<input type="text" name="name" value="${model.name}">
		</p>
		<p>
		<h3>age</h3>
			<input type="number" name="age" value="${model.age}">
		</p>
		<p>
		<h3>date of birth</h3>
			<input type="text" name="dateOfBirth" value="${model.dateOfBirth}">
		</p>
		<input type="hidden" name="id" value="${model.id}" />

		<p>
			<button type="submit" >update!</button>
		</p>

	</fieldset>
</form:form>