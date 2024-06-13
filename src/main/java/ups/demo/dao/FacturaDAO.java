package ups.demo.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import model.Factura;

@Stateless
public class FacturaDAO extends GenericDAO<Factura, Integer>{

    @Override
    public Factura get(Integer param) {
        Factura entity = em.find(Factura.class, param);
        return entity;
    }

    @Override
    public List<Factura> getAll() {
        String jpql = "SELECT f FROM Factura f";
        return em.createQuery(jpql).getResultList();        
    }


}
