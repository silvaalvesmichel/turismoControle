package com.michelalves.turismoControle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.michelalves.turismoControle.domain.Passageiro;
import com.michelalves.turismoControle.repositories.PassageiroRepository;
import com.michelalves.turismoControle.services.exception.DataIntegrityException;
import com.michelalves.turismoControle.services.exception.ObjectNotFoundException;

@Service
public class PassageiroService {
	
	@Autowired
	private PassageiroRepository repo;
	
	public Passageiro find(Integer id) {
		Passageiro obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + ", Tipo: "+ Passageiro.class.getName());
		}
		return obj;
	}
	

	public Passageiro insert(Passageiro obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Passageiro update(Passageiro obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível uma Passageiro que possui produtos");
		}
	}
	
	public List<Passageiro> findAll(){
		return repo.findAll();
	}

	
}
