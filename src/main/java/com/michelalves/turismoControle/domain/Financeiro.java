package com.michelalves.turismoControle.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Financeiro")
public class Financeiro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idFinanceiro;
	
	private Double valorViagem;	
	private Double saldoDevedor;
	private Double valorPago;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "passageiro_id")
	private Passageiro passageiro;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "viagem_id")
	private Viagem viagem;
	
	public Financeiro() {
		
	}

	public Financeiro(Integer idFinanceiro, Double valorViagem, Double saldoDevedor, Double valorPago, Passageiro passageiro,
			Viagem viagem) {
		super();
		this.idFinanceiro = idFinanceiro;
		this.valorViagem = valorViagem;
		this.saldoDevedor = saldoDevedor;
		this.valorPago = valorPago;
		this.passageiro = passageiro;
		this.viagem = viagem;
	}

	public Integer getIdFinanceiro() {
		return idFinanceiro;
	}

	public void setIdFinanceiro(Integer idFinanceiro) {
		this.idFinanceiro = idFinanceiro;
	}

	public Double getValorViagem() {
		return valorViagem;
	}

	public void setValorViagem(Double valorViagem) {
		this.valorViagem = valorViagem;
	}

	public Double getSaldoDevedor() {
		return saldoDevedor;
	}

	public void setSaldoDevedor(Double saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFinanceiro == null) ? 0 : idFinanceiro.hashCode());
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
		Financeiro other = (Financeiro) obj;
		if (idFinanceiro == null) {
			if (other.idFinanceiro != null)
				return false;
		} else if (!idFinanceiro.equals(other.idFinanceiro))
			return false;
		return true;
	}
	
	

}
