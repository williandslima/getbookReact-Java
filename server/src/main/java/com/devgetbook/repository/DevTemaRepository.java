package com.devgetbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devgetbook.model.DevTema;
@Repository
public interface DevTemaRepository extends JpaRepository<DevTema, Long> {


}
