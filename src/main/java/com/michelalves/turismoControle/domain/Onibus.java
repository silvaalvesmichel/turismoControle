package com.michelalves.turismoControle.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Onibus implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idBus;
	private Integer quantLugares;
	 
	@OneToMany(mappedBy = "onibus")
	private List<Assentos> assentos = new ArrayList<>();
	
	public Onibus() {
		
	}

	public Onibus(Integer idBus, Integer quantLugares) {
		super();
		this.idBus = idBus;
		this.quantLugares = quantLugares;
	}

	public Integer getIdBus() {
		return idBus;
	}

	public void setIdBus(Integer idBus) {
		this.idBus = idBus;
	}

	public Integer getQuantLugares() {
		return quantLugares;
	}

	public void setQuantLugares(Integer quantLugares) {
		this.quantLugares = quantLugares;
	}

	public List<Assentos> getAssentos() {
		return assentos;
	}

	public void setAssentos(List<Assentos> assentos) {
		this.assentos = assentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBus == null) ? 0 : idBus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Onibus other = (Onibus) obj;
		if (idBus == null) {
			if (other.idBus != null)
				return false;
		} else if (!idBus.equals(other.idBus))
			return false;
		return true;
	}
	
	
}
