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
        <h1>Lista de Dojos </h1>
        <a href="dojos/nuevo">Agregar Dojo</a>
        <a href="ninjas">Ninjas</a>
        <a href="/">Index</a>

        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Creado</th>
                    <th scope="col">Actualizado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${dojos}" var="dojo">
                    <tr>
                        <th scope="row"><c:out value="${dojo.nombre}"/></th>
                        <th ><c:out value="${dojo.createdAt}"/></th>
                        <th ><c:out value="${dojo.updatedAt}"/></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>

</html>

<!-- MODELO
REPOSITORIO
SERVICIO
CONTROLADOR -->