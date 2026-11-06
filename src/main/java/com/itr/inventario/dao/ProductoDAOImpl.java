package com.itr.inventario.dao;

// Importamos nuestra clase de conexión y el modelo
import com.itr.inventario.conexion.Conexion;
import com.itr.inventario.modelo.Producto;

// Importamos las herramientas de SQL y Colecciones
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Esta clase implementa (hereda) el contrato de ProductoDAO
public class ProductoDAOImpl implements ProductoDAO {

    // ==========================================
    // 1. INSERTAR (CREATE)
    // ==========================================
    @Override
    public void insertar(Producto p) {
        // Escribimos el SQL con '?' en lugar de los datos reales para mayor seguridad
        String sql = "INSERT INTO PRODUCTO (id_categoria, codigo, nombre, descripcion, precio, stock, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // try-with-resources: Abre la conexión y el PreparedStatement, y los cierra solos al terminar
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Rellenamos los '?' uno por uno. (Los índices empiezan en 1)
            stmt.setInt(1, p.getIdCategoria());
            stmt.setString(2, p.getCodigo());
            stmt.setString(3, p.getNombre());
            stmt.setString(4, p.getDescripcion());
            stmt.setDouble(5, p.getPrecio());
            stmt.setInt(6, p.getStock());
            stmt.setString(7, p.getEstado());

            // Ejecutamos la inserción en la base de datos
            stmt.executeUpdate();
            System.out.println("✅ Producto insertado correctamente.");

        } catch (SQLException e) {
            // Si hay un error (ej. el código se repite), lo mostramos en rojo
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    // ==========================================
    // 2. LISTAR (READ)
    // ==========================================
    @Override
    public List<Producto> listar() {
        // Creamos una lista vacía donde guardaremos los productos que vengan de MySQL
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTO";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             // executeQuery devuelve un ResultSet (la tabla virtual con los datos)
             ResultSet rs = stmt.executeQuery()) {

            // rs.next() avanza a la siguiente fila. Devuelve false cuando ya no hay más filas.
            while (rs.next()) {
                // Creamos un producto vacío
                Producto p = new Producto();

                // Le pasamos los datos de la columna de MySQL al objeto usando los Setters
                // Usamos el nombre exacto de la columna en la base de datos
                p.setIdProducto(rs.getInt("id_producto"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setEstado(rs.getString("estado"));

                // Agregamos el producto lleno a la lista
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }
        // Retornamos la lista llena
        return lista;
    }

    // ==========================================
    // 3. ACTUALIZAR (UPDATE)
    // ==========================================
    @Override
    public void actualizar(Producto p) {
        // SQL para actualizar. ¡Ojo con el WHERE al final! Es vital para no actualizar TODOS los productos.
        String sql = "UPDATE PRODUCTO SET id_categoria=?, codigo=?, nombre=?, descripcion=?, precio=?, stock=?, estado=? WHERE id_producto=?";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Rellenamos los primeros 7 datos
            stmt.setInt(1, p.getIdCategoria());
            stmt.setString(2, p.getCodigo());
            stmt.setString(3, p.getNombre());
            stmt.setString(4, p.getDescripcion());
            stmt.setDouble(5, p.getPrecio());
            stmt.setInt(6, p.getStock());
            stmt.setString(7, p.getEstado());

            // El dato 8 es el ID para el WHERE (el producto que queremos modificar)
            stmt.setInt(8, p.getIdProducto());

            stmt.executeUpdate();
            System.out.println("✅ Producto actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    // ==========================================
    // 4. ELIMINAR (DELETE)
    // ==========================================
    @Override
    public void eliminar(int idProducto) {
        // SQL para borrar. El WHERE es obligatorio aquí.
        String sql = "DELETE FROM PRODUCTO WHERE id_producto = ?";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Solo necesitamos rellenar un dato: el ID
            stmt.setInt(1, idProducto);

            stmt.executeUpdate();
            System.out.println("✅ Producto eliminado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}