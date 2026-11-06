<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Productos - I.T.R.</title>
    <!-- Aquí puedes enlazar tus estilos CSS existentes -->
    <style>
        table { border-collapse: collapse; width: 80%; margin: 20px auto; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #2980b9; color: white; }
    </style>
</head>
<body>
    <h2 style="text-align: center;">Sistema de Inventario I.T.R.</h2>

    <!-- Aquí se muestra la tabla con los datos de la base de datos -->
    <table>
        <thead>
            <tr>
                <th>ID</th><th>Código</th><th>Nombre</th><th>Precio</th><th>Stock</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${listaProductos}">
                <tr>
                    <td>${p.idProducto}</td>
                    <td>${p.codigo}</td>
                    <td>${p.nombre}</td>
                    <td>${p.precio}</td>
                    <td>${p.stock}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>