package ups.demo.dao;

import java.util.List;


import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import model.Persona;

@Stateless
public class PersonaDAO extends GenericDAO<Persona, String>{

    @Override
    public Persona get(String param) {
        Persona entity = em.find(Persona.class, param);
		return entity;
    }

    @Override
    public List<Persona> getAll() {
        String jpql = "SELECT p FROM Persona p";
		Query query = em.createQuery(jpql);
		return query.getResultList();
    }



}
