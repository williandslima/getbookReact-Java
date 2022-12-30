package com.devgetbook.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devgetbook.model.DevUsuario;

@Repository
public interface DevUsuarioRepository extends JpaRepository<DevUsuario, Long> {

	public Optional<DevUsuario> findByUsuario(String usuario);


}
