package com.devgetbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgetbook.data.vo.v1.DevTemaVO;
import com.devgetbook.services.DevTemaServices;
import com.devgetbook.util.MediaType;


@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DevTemaController {

	@Autowired
	private DevTemaServices service;

	@GetMapping (produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML
			})
	public List<DevTemaVO> findAll() {
		return service.findAll();
	}


	@GetMapping (value= "/{id}",
			produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML
					})
	public DevTemaVO findById (@PathVariable (value = "id") Long id){
		return service.findById(id);
	}


	@PostMapping (
			consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML },
			produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML })

	public DevTemaVO criarTemaP (
			@RequestBody DevTemaVO devTema){
		return service.criarTema(devTema);
	}

	@PutMapping (
			consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,	MediaType.APPLICATION_YML },
			produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,	MediaType.APPLICATION_YML })

	public DevTemaVO atualizarTema (
			@RequestBody DevTemaVO devTema){
		return service.atualizarTema(devTema);
	}


	@DeleteMapping (value= "/{id}")
	public ResponseEntity<?> delete (@PathVariable (value = "id") Long id){
		service.deletarTema(id);
		return ResponseEntity.noContent().build();
	}

}
