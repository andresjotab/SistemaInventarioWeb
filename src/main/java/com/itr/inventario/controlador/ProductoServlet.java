package com.itr.inventario.controlador;

import com.itr.inventario.dao.ProductoDAO;
import com.itr.inventario.dao.ProductoDAOImpl;
import com.itr.inventario.modelo.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {

    // ==========================================
    // MÉTODO POST: Recibe los datos del formulario
    // ==========================================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Recibimos los datos del formulario
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String categoriaStr = request.getParameter("categoria");
        String precioStr = request.getParameter("precio");
        String stockStr = request.getParameter("stock");
        String estado = request.getParameter("estado");
        String descripcion = request.getParameter("descripcion");

        try {
            // 2. Convertimos y creamos el objeto
            int idCategoria = Integer.parseInt(categoriaStr);
            double precio = Double.parseDouble(precioStr);
            int stock = Integer.parseInt(stockStr);

            Producto nuevoProducto = new Producto(idCategoria, codigo, nombre, descripcion, precio, stock, estado);

            // 3. Guardamos en MySQL
            ProductoDAO dao = new ProductoDAOImpl();
            dao.insertar(nuevoProducto);

            System.out.println("✅ Producto guardado desde la web: " + nombre);

            // 4. Redirigimos a nuestro propio Servlet (GET) para que cargue la tabla del JSP
            response.sendRedirect(request.getContextPath() + "/ProductoServlet");

        } catch (Exception e) {
            System.err.println("❌ Error al guardar: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/pages/productos/nuevo-producto.html?error=1");
        }
    }

    // ==========================================
    // MÉTODO GET: Muestra la lista en el JSP
    // ==========================================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Usamos el DAO para traer todos los productos de MySQL
        ProductoDAO dao = new ProductoDAOImpl();
        List<Producto> lista = dao.listar();

        // 2. Guardamos la lista en un atributo para que el JSP pueda usarla
        request.setAttribute("listaProductos", lista);

        // 3. Enviamos al usuario a la página JSP
        request.getRequestDispatcher("/pages/productos/productos.jsp").forward(request, response);
    }
}