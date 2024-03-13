<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of States</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Set your desired background color here */
        }
        .container {
            margin-top: 50px;
        }
        .table {
            margin-top: 20px;
        }
        .btn {
            padding: .375rem .75rem;
            font-size: 1rem;
            line-height: 1.5;
            border-radius: .25rem;
        }
        .btn-primary {
            color: #fff;
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            color: #fff;
            background-color: #0069d9;
            border-color: #0062cc;
        }
        .btn-danger {
            color: #fff;
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-danger:hover {
            color: #fff;
            background-color: #c82333;
            border-color: #bd2130;
        }
        /* Hover effect on table rows */
        .table-striped tbody tr:hover {
            background-color: rgba(0, 0, 0, 0.075);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
        	
            <div class="col-md-6">
           	 <sec:authorize  access="hasRole('ADMIN')">
                <a class="btn btn-primary mb-3" href="addStateForm">Add a new State</a>
                </sec:authorize>
            </div>
            
            <div class="col-md-6 text-right">
                <a class="btn btn-danger mb-3" href="logout">Logout</a>
            </div>
        </div>
        <br>
        
        <h3 style="color: blue; font-size: 20px;"> Welcome <sec:authentication property="principal.username" /> </h3>
		 <h3 style="color: blue; font-size: 20px;"> Your Permissions : <sec:authentication property="principal.authorities" /> </h3>
        <h3>List of States</h3>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>State ID</th>
                    <th>State Name</th>
                    <th>Abbreviation</th>
                    <th>Population</th>
                    <th>Capital</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="st" items="${states}">
                    <tr>
                        <td><c:out value="${st.state_id}"/></td>
                        <td><c:out value="${st.name}"/></td>
                        <td><c:out value="${st.abbrevation}"/></td>
                        <td><c:out value="${st.popultion}"/></td>
                        <td><c:out value="${st.capital}"/></td>
                         <sec:authorize  access="hasRole('ADMIN')">
                        <td><a class="btn btn-sm btn-primary" href="updateStatesForm?state_id=<c:out value="${st.state_id}"/>">Edit</a></td>
                        
                        <td><a class="btn btn-sm btn-danger" href="deleteStateForm?state_id=<c:out value="${st.state_id}"/>">Delete</a></td>
                          </sec:authorize>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
