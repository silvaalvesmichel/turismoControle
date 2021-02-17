package com.michelalves.turismoControle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michelalves.turismoControle.domain.Assentos;

@Repository
public interface AssentosRepository extends JpaRepository<Assentos, Integer>{

}
