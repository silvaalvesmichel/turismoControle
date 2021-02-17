package com.michelalves.turismoControle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michelalves.turismoControle.domain.Financeiro;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Integer> {

}
