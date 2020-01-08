<div id="wrapper">
	<h1 id="title">Hello world!</h1>


	<form:form method="get"
		action="${pageContext.request.contextPath}/student/insert">
		<div class="span-5">
			<button name="form" style="width: 50px; height: 50px">insert</button>
		</div>
	</form:form>
	
	
	<table style="width: 100%">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>DATE OF BIRTH</th>
			<th>ACTION</th>
		</tr>

		<c:forEach var="student" items="${listStudent}">
			<tr>
				<td><c:out value="${student.id}"></c:out></td>
				<td><c:out value="${student.name}"></c:out></td>
				<td><c:out value="${student.age}"></c:out></td>
				<td><c:out value="${student.dateOfBirth}"></c:out></td>
				<td>
				<form:form method="get"
						action="${pageContext.request.contextPath}/student/get/${student.id}">
						<button id="btnEdit">Update</button>
					</form:form>
					
					<form:form method="post"
						action="${pageContext.request.contextPath}/student/delete/${student.id}">
						<button id="btnDelete">Delete</button>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

