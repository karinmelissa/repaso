<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="/css/style.css">
</head>

<body>
    <div class="container">
        <h1>Nuevo Ninja</h1>
        <form:form action="" method="POST" modelAttribute="ninja">
            <input type="hidden" name="_method" value="${method}">
            <p>
                <form:label path="nombre">Dojo</form:label>
                <form:select path="dojo">
                    <form:option value="-1">Selecciones un Dojo:</form:option>
                    <c:forEach items="${dojos}" var="dojo">
                        <form:option value="${dojo}"><c:out value="${dojo.nombre}" /></form:option>
                    </c:forEach>
                </form:select>
            </p>
            <p>
                <form:label path="nombre">Nombre</form:label>
                <form:input path="nombre"/>
                <form:errors path="nombre" class="errorList"/>
            </p>
            <p> 
                <form:label path="apellido">Apellido</form:label>
                <form:input path="apellido"/>
                <form:errors path="apellido" class="errorList"/>
            </p>
            <p> 
                <form:label path="edad">Edad</form:label>
                <form:input path="edad" type="number"/>
                <form:errors path="edad" class="errorList"/>
            </p>
            <p>
                <form:label path="email">Email</form:label>
                <form:input path="email"/>
                <form:errors path="email" class="errorList"/>
            </p>
            <c:if test="${method eq 'POST'}">
                <p>
                    <form:label path="password">Password</form:label>
                    <form:password path="password"/>
                    <form:errors path="password" class="errorList"/>
                </p>
                <p>
                    <form:label path="confirmarPassword">Confirmar Password</form:label>
                    <form:password path="confirmarPassword"/>
                    <form:errors path="confirmarPassword" class="errorList"/>
                </p>
            </c:if> 
            <button>Guardar</button>
            <a href="/dojos">Cancelar</a>
        </form:form>
    </div>
</body>
</html>
