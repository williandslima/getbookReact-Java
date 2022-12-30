package com.devgetbook.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.devgetbook.model.DevPostagem;
import com.devgetbook.services.DevPostagemServices;


@RestController
@RequestMapping("/postagem")
public class DevPostagemController {

	@Autowired
	private DevPostagemServices service;
	
	
	@RequestMapping (method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DevPostagem> findAll() {
		return service.findAll();
	}

	
	@RequestMapping (value= "/{id}", 
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public DevPostagem findById (
			@PathVariable (value = "id") String id){
		return service.findById(id);
	}
	
	
	@RequestMapping (method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public DevPostagem criarPostagem (
			@RequestBody DevPostagem devPostagem){
		return service.criarPostagem(devPostagem);
	}
	
	@RequestMapping (method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public DevPostagem atualizrPostagem (
			@RequestBody DevPostagem devPostagem){
		return service.atualizarPostagem(devPostagem);
	}
	
	@RequestMapping (value= "/{id}", 
			method=RequestMethod.DELETE)
	public void delete (@PathVariable (value = "id") String id){
		service.deletarPostagem(id);
	}

}
