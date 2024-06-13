package ups.demo.demo.ups;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import model.DetalleFactura;
import model.Factura;
import model.Persona;
import model.Producto;
import ups.demo.dao.DetalleFacturaDAO;
import ups.demo.dao.FacturaDAO;
import ups.demo.dao.PersonaDAO;
import ups.demo.dao.ProductoDAO;

@Singleton
@Startup
public class Inicio {
	
	@Inject PersonaDAO personaDAO;

	@Inject ProductoDAO productoDAO;

	@Inject FacturaDAO facturaDAO;

	@Inject DetalleFacturaDAO detalleFacturaDAO;	
	
	@PostConstruct
	public void init()	{

		InsertProducts();
		InsertClientes();
		CreateFactura();

		personaDAO.getAll().forEach(e -> System.out.println(e.toString()) );
		productoDAO.getAll().forEach(e -> System.out.println(e.toString()) );
		facturaDAO.getAll().forEach(e -> System.out.println(e.toString()) );		
	}

	private void CreateFactura(){
		Factura factura = new Factura();
		factura.setNumero(1);
		factura.setFecha("2021-10-10");
		factura.setCliente(personaDAO.get("0107951170"));
		factura.setDetalles(GetDetalles());
		facturaDAO.create(factura);
	}

	private List<DetalleFactura> GetDetalles(){
		List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
		DetalleFactura detalle = new DetalleFactura();
		Producto producto = productoDAO.get(1);
		detalle.setCantidad(1);
		detalle.setProducto(producto);
		detalle.setPrecio(producto.getPrecio());
		detalles.add(detalle);

		producto = productoDAO.get(2);
		detalle.setCantidad(3);
		detalle.setProducto(producto);
		detalle.setPrecio(producto.getPrecio());
		detalles.add(detalle);

		producto = productoDAO.get(2);
		detalle.setCantidad(1);
		detalle.setProducto(producto);
		detalle.setPrecio(producto.getPrecio());
		detalles.add(detalle);
		return detalles;
	}

	private void InsertProducts(){
		Producto producto = new Producto();
		producto.setCodigo(1);
		producto.setNombre("Producto 1");
		producto.setPrecio(10.0);
		producto.setStock(10);
		productoDAO.create(producto);
		producto = new Producto();
		producto.setCodigo(2);
		producto.setNombre("Producto 2");
		producto.setPrecio(20.0);
		producto.setStock(20);
		productoDAO.create(producto);
		producto = new Producto();
		producto.setCodigo(3);
		producto.setNombre("Producto 3");
		producto.setPrecio(30.0);
		producto.setStock(30);
		productoDAO.create(producto);
		producto = new Producto();
		producto.setCodigo(4);
		producto.setNombre("Producto 4");
		producto.setPrecio(40.0);
		producto.setStock(40);
		productoDAO.create(producto);
		producto = new Producto();
		producto.setCodigo(5);
		producto.setNombre("Producto 5");
		producto.setPrecio(50.0);
		producto.setStock(50);
		productoDAO.create(producto);
		producto = new Producto();
		producto.setCodigo(6);
		producto.setNombre("Producto 6");
		producto.setPrecio(60.0);
		producto.setStock(60);
		productoDAO.create(producto);
		producto = new Producto();
		producto.setCodigo(7);
		producto.setNombre("Producto 7");
		producto.setPrecio(70.0);
		producto.setStock(70);
		productoDAO.create(producto);
		producto = new Producto();
		producto.setCodigo(8);
		producto.setNombre("Producto 8");
		producto.setPrecio(80.0);
		producto.setStock(80);
		productoDAO.create(producto);
		producto = new Producto();
		producto.setCodigo(9);
		producto.setNombre("Producto 9");
		producto.setPrecio(90.0);
		producto.setStock(90);	
		productoDAO.create(producto);
	}

	private void InsertClientes(){
		Persona persona = new Persona();
		persona.setCedula("0107951170");
		persona.setNombre("John Doe");
		persona.setDireccion("123 Main St");
		personaDAO.create(persona);
		persona = new Persona();
		persona.setCedula("0107951171");
		persona.setNombre("Jane Smith");
		persona.setDireccion("456 Elm St");
		personaDAO.create(persona);
		persona = new Persona();
		persona.setCedula("0107951172");
		persona.setNombre("Mike Johnson");
		persona.setDireccion("789 Oak St");
		personaDAO.create(persona);
		persona = new Persona();
		persona.setCedula("0107951173");
		persona.setNombre("Emily Davis");
		persona.setDireccion("321 Pine St");
		personaDAO.create(persona);
		persona = new Persona();
		persona.setCedula("0107951174");
		persona.setNombre("Chris Wilson");
		persona.setDireccion("654 Maple St");
		personaDAO.create(persona);
		persona = new Persona();
		persona.setCedula("0107951175");
		persona.setNombre("Sarah Thompson");
		persona.setDireccion("987 Cedar St");
		personaDAO.create(persona);
		persona = new Persona();
		persona.setCedula("0107951176");
		persona.setNombre("Alex Brown");
		persona.setDireccion("654 Birch St");
		personaDAO.create(persona);
		persona = new Persona();
		persona.setCedula("0107951177");
		persona.setNombre("Jessica Lee");
		persona.setDireccion("321 Willow St");
		personaDAO.create(persona);
		persona = new Persona();
		persona.setCedula("0107951178");
		persona.setNombre("David Miller");
		persona.setDireccion("987 Pine St");
		personaDAO.create(persona);
	}

}
