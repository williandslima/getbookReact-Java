package com.devgetbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devgetbook.model.DevPostagem;



@Repository
public interface DevPostagemRepository extends JpaRepository <DevPostagem, Long>{

	  List<DevPostagem>findAllByTituloLivroContainingIgnoreCase(@Param ("tituloLivro") String tituloLivro);

}
