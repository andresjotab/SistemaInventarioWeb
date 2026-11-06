<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Productos - I.T.R.</title>
    <!-- Ajusta las rutas de tu CSS según tu estructura de carpetas en webapp -->
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <!-- Aquí puedes poner tu menú lateral si quieres -->

    <main class="main-content">
        <h1>Gestión de Productos</h1>

        <!-- Botón para ir al formulario de creación -->
        <a href="pages/productos/nuevo-producto.html" class="btn btn-primary">+ Nuevo Producto</a>

        <!-- TABLA DINÁMICA CON JSTL -->
        <table class="table" style="width: 100%; margin-top: 20px; border-collapse: collapse;">
            <thead>
                <tr style="background: #2c3e50; color: white;">
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Stock</th>
                    <th>Precio</th>
                    <th>Estado</th>
                </tr>
            </thead>
            <tbody>
                <!-- Esto recorre la lista que enviamos desde el Servlet -->
                <c:forEach var="p" items="${listaProductos}">
                    <tr style="border-bottom: 1px solid #ddd;">
                        <td>${p.codigo}</td>
                        <td>${p.nombre}</td>
                        <td>${p.stock}</td>
                        <td>${p.precio}</td>
                        <td>${p.estado}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>