package com.michelalves.turismoControle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michelalves.turismoControle.domain.Estados;

@Repository
public interface EstadosRepository extends JpaRepository<Estados, Integer> {

}
