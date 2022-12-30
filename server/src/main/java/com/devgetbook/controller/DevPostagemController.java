package com.devgetbook.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devgetbook.data.vo.v1.DevPostagemVO;
import com.devgetbook.services.DevPostagemServices;
import com.devgetbook.util.MediaType;


@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DevPostagemController {

	@Autowired
	private DevPostagemServices service;

	@GetMapping (produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML
			})
	public ResponseEntity<PagedModel<EntityModel<DevPostagemVO>>> findAll(
			@RequestParam(value= "page", defaultValue = "0") Integer page,
			@RequestParam(value= "size", defaultValue ="12") Integer size,
			@RequestParam(value= "direction", defaultValue ="asc") String direction
			){// request param para paginacao para mostrar

		var sortDirection = "desc".equalsIgnoreCase(direction)
				? Direction.DESC : Direction.ASC;

		Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "tituloLivro")); //definindo a ordem que vai mostrar os atribitos
		return ResponseEntity.ok(service.findAll(pageable));
	}


	@GetMapping (value= "/{id}",
			produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML
					})
	public DevPostagemVO findById (@PathVariable (value = "id") Long id){
		return service.findById(id);
	}


	@PostMapping (
			consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML },
			produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML })
	public DevPostagemVO criarPostagem (
			@RequestBody DevPostagemVO devPostagem){
		return service.criarPostagem(devPostagem);
	}

	@PutMapping (
			consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,	MediaType.APPLICATION_YML },
			produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,	MediaType.APPLICATION_YML })

	public DevPostagemVO atualizrPostagem (
			@RequestBody DevPostagemVO devPostagem){
		return service.atualizarPostagem(devPostagem);
	}


	@DeleteMapping (value= "/{id}")
	public ResponseEntity<?> delete (@PathVariable (value = "id") Long id){
		service.deletarPostagem(id);
		return ResponseEntity.noContent().build();
	}

}
