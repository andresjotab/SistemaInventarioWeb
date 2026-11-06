package com.itr.inventario.modelo;

// Declaramos la clase pública llamada Producto
public class Producto {

    // 1. ATRIBUTOS: Representan las columnas de tu tabla en MySQL.
    // Usamos 'private' para proteger los datos (Encapsulamiento).
    private int idProducto;
    private int idCategoria;
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String estado;

    // 2. CONSTRUCTOR VACÍO:
    // Es obligatorio tenerlo. Nos permite crear un objeto Producto sin datos iniciales
    // (lo usaremos mucho cuando leamos la base de datos y vayamos llenando los datos).
    public Producto() {}

    // 3. CONSTRUCTOR CON PARÁMETROS:
    // Nos permite crear un producto nuevo con todos sus datos de una vez.
    // Nota que NO pedimos el idProducto, porque ese lo genera MySQL automáticamente.
    public Producto(int idCategoria, String codigo, String nombre, String descripcion, double precio, int stock, String estado) {
        this.idCategoria = idCategoria;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    // 4. GETTERS Y SETTERS (Métodos accesores y modificadores):
    // Son las "puertas de entrada" para leer o cambiar las variables privadas de arriba.

    // Ejemplo: Para leer el ID usamos getIdProducto(), y para cambiarlo usamos setIdProducto()
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // 5. TOSTRING:
    // Cambia la forma en que se muestra el objeto cuando lo imprimimos en consola.
    @Override
    public String toString() {
        // Retorna un texto formateado con los datos principales del producto.
        return "Producto [ID=" + idProducto + ", Código=" + codigo + ", Nombre=" + nombre + ", Precio=" + precio + ", Stock=" + stock + "]";
    }
}