package controllers;

import java.util.List;


import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ups.demo.dao.PersonaDAO;
import model.Persona;


@Path("/persona")
public class PersonaController {

    @Inject
    private PersonaDAO personaDAO;

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    public List<Persona> GetPersonas() {
        return personaDAO.getAll();
    }

    @Path("/get/{cedula}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Persona GetPersona(@PathParam("cedula") String cedula) {
        return personaDAO.get(cedula);
    }

    @Path("/delete/{cedula}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String DeletePersona(@PathParam("cedula") String cedula) {
        personaDAO.delete(cedula);
        return "Persona eliminada";
    }

    @Path("/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String CreatePersona(Persona persona) {
        personaDAO.create(persona);
        return "Persona creada";
    }









}
