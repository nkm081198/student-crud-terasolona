<form:form action="${pageContext.request.contextPath}/student/insert" method="post">
	<fieldset>

		<p>
			<h3>name</h3>
			<input type="text" name="name">
		</p>
		<p>
		<h3>age</h3>
			<input type="number" name="age">
		</p>
		<p>
		<h3>date of birth</h3>
			<input type="text" name="dateOfBirth">
		</p>

		<p>
			<button type="submit">add</button>
		</p>

	</fieldset>
</form:form>