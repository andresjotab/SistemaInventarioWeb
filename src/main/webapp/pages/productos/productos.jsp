<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>I.T.R. - Productos</title>

    <!-- Rutas absolutas para que Tomcat encuentre el CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/variables.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modal.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages.css">
</head>

<body data-page="productos">

    <!-- Header y Sidebar se cargan automáticamente -->
    <div id="header-container"></div>

    <div class="app-layout">
        <div id="sidebar-container"></div>

        <main class="main-content">
            <div class="container">

                <!-- Encabezado -->
                <header class="product-page-header">
                    <h1>📦 Productos</h1>
                    <p class="text-muted">Gestión de productos del inventario</p>
                </header>

                <!-- Barra de herramientas -->
                <div class="product-toolbar">
                    <div class="product-search">
                        <input type="text" id="buscar-input" placeholder="🔍 Buscar..." class="search-input">
                        <button class="btn btn-primary" type="button">Buscar</button>
                    </div>
                    <!-- Ruta corregida con contextPath -->
                    <a href="${pageContext.request.contextPath}/pages/productos/nuevo_producto.html" class="btn btn-success">➕ Nuevo</a>
                    <a href="#" class="btn btn-primary">🛒 Vender</a>
                </div>

                <!-- Tabla -->
                <div class="product-table-wrapper" aria-label="Tabla de productos">
                    <table class="product-table">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Stock</th>
                                <th>Precio</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody id="productos-tbody">
                            <!-- AQUÍ CONECTAMOS CON MYSQL -->
                            <c:forEach items="${listaProductos}" var="p">
                                <tr>
                                    <td>${p.codigo}</td>
                                    <td>${p.nombre}</td>
                                    <td>${p.stock}</td>
                                    <td>$${p.precio}</td>
                                    <td>
                                        <span class="badge" style="background: #eef; padding: 4px 8px; border-radius: 4px; color: #333;">
                                            ${p.estado}
                                        </span>
                                    </td>
                                    <td>
                                        <button class="btn btn-secondary btn-sm" title="Editar">✏️</button>
                                        <button class="btn btn-danger btn-sm" title="Eliminar">🗑️</button>
                                    </td>
                                </tr>
                            </c:forEach>

                            <c:if test="${empty listaProductos}">
                                <tr>
                                    <td colspan="6" style="text-align: center;">No hay productos registrados aún.</td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>

                    <!-- Paginación -->
                    <div class="product-table-footer">
                        <span id="paginacion-info">Mostrando datos reales de MySQL</span>
                        <div class="pagination" id="paginacion-botones"></div>
                    </div>
                </div>

            </div>
        </main>
    </div>

    <div id="footer-container"></div>

    <!-- Modal eliminar producto -->
    <div class="modal-overlay" id="modalEliminar">
        <div class="modal" role="dialog" aria-modal="true" aria-labelledby="modalEliminarTitle">
            <div class="modal-header">
                <h2 id="modalEliminarTitle">Eliminar Producto</h2>
                <button type="button" class="modal-close" data-cerrar-modal aria-label="Cerrar ventana">×</button>
            </div>
            <div class="modal-body">
                <div class="modal-icon">⚠️</div>
                <p class="text-center" style="margin-bottom: var(--spacing-md); font-weight: 500;">
                    ¿Estás seguro de eliminar este producto? Esta acción no se puede deshacer.
                </p>
                <div class="product-details">
                    <strong>Código:</strong> <span id="codigoProducto">---</span><br>
                    <strong>Nombre:</strong> <span id="nombreProducto">---</span>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary btn-sm" data-cerrar-modal>Cancelar</button>
                <button type="button" class="btn btn-danger btn-sm" id="btnConfirmarEliminar">Eliminar</button>
            </div>
        </div>
    </div>

    <!-- Mantenemos app.js y navigation.js con ruta absoluta, quitamos data.js y productos.js -->
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/js/navigation.js"></script>

</body>
</html>