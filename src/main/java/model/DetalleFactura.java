package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class DetalleFactura {

    @Id
    private int codigo;
    private int cantidad;
    private double precio;

    @OneToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    @Override
    public String toString() {
        return "DetalleFactura [cantidad=" + cantidad + ", codigo=" + codigo + ", precio=" + precio + ", producto=" + producto + "]";
    }

    
}
