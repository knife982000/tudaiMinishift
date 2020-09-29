package edu.isistan.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioREST {
	
	public UsuarioREST() {
		System.out.println("Creando Clase");
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("id") String id) {
		System.out.println("Obteniendo usuario "+ id + " ---");
		return new Usuario(Integer.parseInt(id), "Nombre_"+id, "Apellido_"+id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios() {
		System.out.println("Obteniendo Usuarios "+System.currentTimeMillis());
		return IntStream.range(0, 10).
				mapToObj(id -> new Usuario(id, "Nombre_"+id, "Apellido_"+id)).
				collect(Collectors.toList());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String save(Usuario u) {
		System.out.println("Guardando usuario "+ u);
		return "Usuario Salvado ok";
	}
}
