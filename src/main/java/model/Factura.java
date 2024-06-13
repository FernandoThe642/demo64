package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Factura {

    @Id
    private int numero;
    private String fecha;

    @OneToOne
    @JoinColumn(name = "cedula")
    private Persona cliente;

    @OneToMany
    @JoinColumn(name = "codigo")
    private List<DetalleFactura> detalles;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Factura [cliente=" + cliente + ", fecha=" + fecha + ", numero=" + numero + ", detalles=" + detalles
                + "]";
    }

    public void addDetalle(DetalleFactura detalle) {
        if (detalles == null)
            detalles = new ArrayList<>();
        detalles.add(detalle);
    }

}
