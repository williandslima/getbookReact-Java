package com.devgetbook.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import com.devgetbook.controller.DevPostagemController;
import com.devgetbook.data.vo.v1.DevPostagemVO;
import com.devgetbook.exceptions.ResourceNotFoundException;
import com.devgetbook.mapper.DozerMapper;
import com.devgetbook.model.DevPostagem;
import com.devgetbook.repository.DevPostagemRepository;


@Service
public class DevPostagemServices {

	private Logger logger = Logger.getLogger(DevPostagemServices.class.getName());

	@Autowired
	DevPostagemRepository repository;

	@Autowired
	PagedResourcesAssembler <DevPostagemVO> assembler;

	public PagedModel<EntityModel<DevPostagemVO>> findAll(Pageable pageable) {

		logger.info("Procurando todas postagens");
		var postagemPage = repository.findAll(pageable);

		var postagemVosPage = postagemPage.map(p -> DozerMapper.parseObject(p, DevPostagemVO.class));
		postagemVosPage.map(
				p -> p.add(
					linkTo(methodOn(DevPostagemController.class)
						.findById(p.getKey())).withSelfRel()));

		Link link = linkTo(
				methodOn(DevPostagemController.class)
					.findAll(pageable.getPageNumber(),
							pageable.getPageSize(),
							"asc")).withSelfRel();


		return assembler.toModel(postagemVosPage, link);
	}

	public DevPostagemVO findById(Long id) {

		logger.info("Procurando uma postagem");

		var entidade = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID informado nao existe"));

		var vo = DozerMapper.parseObject(entidade, DevPostagemVO.class);
		vo.add(linkTo(methodOn(DevPostagemController.class).findById(id)).withSelfRel());
		return vo;
	}

	// recebe um VO
	public DevPostagemVO criarPostagem(DevPostagemVO devPostagem) {

		logger.info("Criar uma postagem");
		// converter o vo para entidade do tipo postagem
		var entidade = DozerMapper.parseObject(devPostagem, DevPostagem.class);
		// salva ele no banco e passa para o objeto vo -"INTERFACE"
		var vo = DozerMapper.parseObject(repository.save(entidade), DevPostagemVO.class);
		vo.add(linkTo(methodOn(DevPostagemController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public DevPostagemVO atualizarPostagem(DevPostagemVO devPostagem) {

		logger.info("Atualizando uma postagem");

		// recuperando dados por id
		var recebePostagem = repository.findById(devPostagem.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("ID informado nao existe"));

		// salvando novos dados na entidade postagem
		recebePostagem.setTituloLivro(devPostagem.getTituloLivro());
		recebePostagem.setDescricao(devPostagem.getDescricao());
		recebePostagem.setFoto(devPostagem.getFoto());
		recebePostagem.setAutor(devPostagem.getAutor());

		var vo = DozerMapper.parseObject(repository.save(recebePostagem), DevPostagemVO.class);
		vo.add(linkTo(methodOn(DevPostagemController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public void deletarPostagem(Long id) {

		logger.info("Deletando postagem");

		var recebePostagem = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID informado nao existe"));

		repository.delete(recebePostagem);

	}

}
