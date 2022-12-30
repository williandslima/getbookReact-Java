package com.devgetbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devgetbook.model.DevPostagem;



@Repository
public interface DevPostagemRepository extends JpaRepository <DevPostagem, Long>{

}
