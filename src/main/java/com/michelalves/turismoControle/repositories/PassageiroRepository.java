package com.michelalves.turismoControle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michelalves.turismoControle.domain.Passageiro;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {

}
