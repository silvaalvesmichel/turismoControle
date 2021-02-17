package com.michelalves.turismoControle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.michelalves.turismoControle.domain.Viagem;
import com.michelalves.turismoControle.repositories.ViagemRepository;
import com.michelalves.turismoControle.services.exception.DataIntegrityException;
import com.michelalves.turismoControle.services.exception.ObjectNotFoundException;

@Service
public class ViagemService {
	
	@Autowired
	private ViagemRepository repo;
	
	public Viagem find(Integer id) {
		Viagem obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + ", Tipo: "+ Viagem.class.getName());
		}
		return obj;
	}
	

	public Viagem insert(Viagem obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Viagem update(Viagem obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível uma Viagem que possui produtos");
		}
	}
	
	public List<Viagem> findAll(){
		return repo.findAll();
	}

}
