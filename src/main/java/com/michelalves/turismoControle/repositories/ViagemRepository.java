package com.michelalves.turismoControle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michelalves.turismoControle.domain.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Integer> {

}
