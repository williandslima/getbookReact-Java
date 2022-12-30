package com.devgetbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgetbook.model.DevPostagem;
import com.devgetbook.repository.DevPostagemRepository;

@Service
public class DevPostagemServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(DevPostagemServices.class.getName());

	@Autowired
	DevPostagemRepository repository;
	
	
	public List<DevPostagem> findAll() {

		logger.info("Procurando todas postagens");
		List<DevPostagem> devPostagens = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			DevPostagem devPostagem = mockDevPostagem(i);
			devPostagens.add(devPostagem);
		}

		return devPostagens;
	}

	public DevPostagem findById(String id) {

		logger.info("Procurando uma postagem");

		DevPostagem devPostagem = new DevPostagem();
		devPostagem.setId(counter.incrementAndGet());
		devPostagem.setTituloLivro("Titulo tal tal");
		devPostagem.setDescricao("Descricao tal tal");
		devPostagem.setFoto("Foto tal tal");
		devPostagem.setAutor("Autor tal tal");

		return devPostagem;

	}

	public DevPostagem criarPostagem(DevPostagem devPostagem) {

		logger.info("Criar uma postagem");

		return devPostagem;

	}

	public DevPostagem atualizarPostagem(DevPostagem devPostagem) {

		logger.info("Atualizando uma postagem");

		return devPostagem;

	}

	public void deletarPostagem(String id) {

		logger.info("Atualizando uma postagem");


	}
	
	private DevPostagem mockDevPostagem(int i) {
		DevPostagem devPostagem = new DevPostagem();
		devPostagem.setId(counter.incrementAndGet());
		devPostagem.setTituloLivro("Titulo tal tal" + i);
		devPostagem.setDescricao("Descricao tal tal" + i);
		devPostagem.setFoto("Foto tal tal" + i);
		devPostagem.setAutor("Autor tal tal" + i);
		return devPostagem;
	}

}
