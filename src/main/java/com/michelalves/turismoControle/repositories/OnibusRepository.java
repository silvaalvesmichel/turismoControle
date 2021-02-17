package com.michelalves.turismoControle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michelalves.turismoControle.domain.Cidades;
import com.michelalves.turismoControle.domain.Onibus;
import com.michelalves.turismoControle.domain.Passageiro;

	@Repository
	public interface OnibusRepository extends JpaRepository<Onibus, Integer> {

}
