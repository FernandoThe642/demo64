package ups.demo.dao;
import java.util.List;

import jakarta.ejb.Stateless;
import model.Producto;

@Stateless
public class ProductoDAO extends GenericDAO<Producto, Integer>{

    @Override
    public Producto get(Integer param) {
        Producto entity = em.find(Producto.class, param);
        return entity;
    }

    @Override
    public List<Producto> getAll() {
        String jpql = "SELECT p FROM Producto p";
        return em.createQuery(jpql).getResultList();
    }

}
