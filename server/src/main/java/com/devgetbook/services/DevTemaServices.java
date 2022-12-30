package com.devgetbook.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgetbook.controller.DevTemaController;
import com.devgetbook.data.vo.v1.DevTemaVO;
import com.devgetbook.exceptions.ResourceNotFoundException;
import com.devgetbook.mapper.DozerMapper;
import com.devgetbook.model.DevTema;
import com.devgetbook.repository.DevTemaRepository;


@Service
public class DevTemaServices {

	private Logger logger = Logger.getLogger(DevTemaServices.class.getName());

	@Autowired
	DevTemaRepository repository;

	public List<DevTemaVO> findAll() {

		logger.info("Procurando todos Temas");
		var temas = DozerMapper.parseListObjects(repository.findAll(), DevTemaVO.class);

		temas.stream().forEach(p -> p.add(linkTo(methodOn(DevTemaController.class).findById(p.getKey())).withSelfRel()));
		return temas;


	}

	public DevTemaVO findById(Long id) {

		logger.info("Procurando um tema por ID");

		var entidade = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID informado nao existe"));

		var vo = DozerMapper.parseObject(entidade, DevTemaVO.class);
		vo.add(linkTo(methodOn(DevTemaController.class).findById(id)).withSelfRel());
		return vo;
	}

	// recebe um VO
	public DevTemaVO criarTema(DevTemaVO devTema) {

		logger.info("Criar um tema");
		// converter o vo para entidade do tipo postagem
		var entidade = DozerMapper.parseObject(devTema, DevTema.class);
		// salva ele no banco e passa para o objeto vo -"INTERFACE"
		var vo = DozerMapper.parseObject(repository.save(entidade), DevTemaVO.class);
		vo.add(linkTo(methodOn(DevTemaController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public DevTemaVO atualizarTema(DevTemaVO devTema) {

		logger.info("Atualizando um tema");

		// recuperando dados por id
		var recebeTema = repository.findById(devTema.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("ID informado nao existe"));

		// salvando novos dados na entidade postagem
		recebeTema.setCategoria(devTema.getCategoria());
		recebeTema.setGenero(devTema.getGenero());


		var vo = DozerMapper.parseObject(repository.save(recebeTema), DevTemaVO.class);
		vo.add(linkTo(methodOn(DevTemaController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public void deletarTema(Long id) {

		logger.info("Deletando Tema");

		var recebeTema = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID informado nao existe"));

		repository.delete(recebeTema);

	}

}
