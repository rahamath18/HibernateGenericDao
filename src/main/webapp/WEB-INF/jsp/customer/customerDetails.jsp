<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
</head>
<body>

	<spring:url value="/customer/addCustomer" var="addCustomer" />

	<form:form method="post" modelAttribute="customerForm"
		action="${addCustomer}">

		<form:hidden path="id" />

		<table>
			<tr>
				<th colspan="4">Add Customer</th>
			</tr>
			<tr>
				<td><form:label path="customerName">Customer Name:</form:label></td>
				<td colspan="3"><form:input path="customerName" size="30" maxlength="30"></form:input></td>
			</tr>
			
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td colspan="3"><form:input path="email" size="30" maxlength="30"></form:input></td>
			</tr>
			
			<tr>
				<td><form:label path="phoneType">Phone Type1</form:label></td>
				<td><form:input path="phoneType" size="30" maxlength="30"></form:input></td>
				<td><form:label path="phoneNo">Phone No1</form:label></td>
				<td><form:input path="phoneNo" size="30" maxlength="30"></form:input></td>
			</tr>
			
			<tr>
				<td><form:label path="phoneType">Phone Type2</form:label></td>
				<td><form:input path="phoneType" size="30" maxlength="30"></form:input></td>
				<td><form:label path="phoneNo">Phone No2</form:label></td>
				<td><form:input path="phoneNo" size="30" maxlength="30"></form:input></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" class="blue-button" /></td>
			</tr>
			
		</table>
	</form:form>
	</br>
	<h3>Customer List</h3>
	<c:if test="${!empty listOfCustomers}">
		<table>
			<tr>
				<th>Customer Id</th>
				<th>Phone Id</th>
				<th>Customer Name</th>
				<th>Email</th>
				<th>Phone Type</th>
				<th>Phone No#</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${listOfCustomers}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.phoneId}</td>
					<td>${customer.customerName}</td>
					<td>${customer.email}</td>
					<td>${customer.phoneType}</td>
					<td>${customer.phoneNo}</td>
					<td><a href="<c:url value='/updateCustomer/${customer.id}' />">Edit</a></td>
					<td><a href="<c:url value='/deleteCustomer/${customer.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
