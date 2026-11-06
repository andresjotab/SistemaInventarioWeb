package com.itr.inventario.dao;

// Importamos la clase Producto para poder usarla en los métodos
import com.itr.inventario.modelo.Producto;
// Importamos List para poder devolver una lista de productos
import java.util.List;

/**
 * Esta es una INTERFAZ.
 * Define el "contrato" de las operaciones que se pueden hacer con un Producto en la base de datos.
 * No dice CÓMO se hacen, solo QUÉ se puede hacer.
 */
public interface ProductoDAO {

    // C (Create) - Crear/Insertar: Recibe un objeto Producto para guardarlo en la BD.
    void insertar(Producto producto);

    // R (Read) - Leer/Listar: Devuelve una lista (List) llena con todos los productos de la BD.
    List<Producto> listar();

    // U (Update) - Actualizar: Recibe un objeto Producto (con datos modificados) para actualizarlo en la BD.
    void actualizar(Producto producto);

    // D (Delete) - Eliminar: Recibe el ID (int) del producto que se quiere borrar de la BD.
    void eliminar(int idProducto);

}