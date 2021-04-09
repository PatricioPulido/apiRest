package com.pruebas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.model.Persona;

//muy importante crear esta inteface que extiende del JpaRepository
public interface PersonaDAO extends JpaRepository<Persona, Integer> {
	
	

}
