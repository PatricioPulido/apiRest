package com.pruebas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.PersonaDAO;
import com.pruebas.model.Persona;



//anotaciones
//con esta notaciones vamos a decir que es un archivo rest
@RestController
//esto va a tener una ruta principal (ruta principal)
@RequestMapping("personas")
public class PersonaRest {

	@Autowired
	//injeccion de dependencias
	private PersonaDAO personaDAO;
	//metodos http solicitados al servidor
	
	//GET, POST, PUT, DELETE -> 200 correcto - 500 error de programacion logica- 404 escrito mal ruta etc
	
	@PostMapping("/guardar")//localhos:8080/personas/guardar
	public void guardar(@RequestBody Persona persona) {//@RequestBody se encarga de recibir el objeto json y lo convierte en un objeto java
		personaDAO.save(persona);
	}
	
	@GetMapping("/listar") //me debe devolver una lista con todos los registros no puede ser void
	public List<Persona> listar(){
		return personaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Persona persona){
		personaDAO.save(persona);
	}
}
