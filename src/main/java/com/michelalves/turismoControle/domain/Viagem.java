package com.michelalves.turismoControle.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="Viagem")
public class Viagem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idViagem;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataIda;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVolta;
	private Double valorHotel;
	private Double valorTransporte;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="estados_fk")
	private Estados estados = new Estados();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cidades_fk")
	private Cidades cidades = new Cidades();
	
	@ManyToMany
	@JoinTable(name = "VIAGEM_PASSAGEIRO", joinColumns = @JoinColumn(name = "viagem_id"), inverseJoinColumns = @JoinColumn(name = "passageiro_id"))
	private List<Passageiro> passageiros = new ArrayList<>();
	
	@OneToMany(mappedBy="viagem")
	private List<Financeiro> financeiros = new ArrayList<>();
	
	@OneToOne
	private Onibus onibus = new Onibus();
	
	public Viagem() {
		
	}
	
	public Viagem(Integer id, Date dataIda, Date dataVolta, Double valorHotel, Double valorTransporte, Estados estados,
			Cidades cidades, Onibus onibus) {
		super();
		this.idViagem = id;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.valorHotel = valorHotel;
		this.valorTransporte = valorTransporte;
		this.estados = estados;
		this.cidades = cidades;
		this.onibus = onibus;
		}


	public Integer getId() {
		return idViagem;
	}


	public void setId(Integer id) {
		this.idViagem = id;
	}


	public Date getDataIda() {
		return dataIda;
	}


	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}


	public Date getDataVolta() {
		return dataVolta;
	}


	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}


	public Double getValorHotel() {
		return valorHotel;
	}


	public void setValorHotel(Double valorHotel) {
		this.valorHotel = valorHotel;
	}


	public Double getValorTransporte() {
		return valorTransporte;
	}


	public void setValorTransporte(Double valorTransporte) {
		this.valorTransporte = valorTransporte;
	}


	public Estados getEstados() {
		return estados;
	}


	public void setEstados(Estados estados) {
		this.estados = estados;
	}


	public Cidades getCidades() {
		return cidades;
	}


	public void setCidades(Cidades cidades) {
		this.cidades = cidades;
	}

	public Integer getIdViagem() {
		return idViagem;
	}


	public void setIdViagem(Integer idViagem) {
		this.idViagem = idViagem;
	}


	public List<Passageiro> getPassageiros() {
		return passageiros;
	}


	public void setPassageiros(List<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}


	public List<Financeiro> getFinanceiros() {
		return financeiros;
	}


	public void setFinanceiros(List<Financeiro> financeiros) {
		this.financeiros = financeiros;
	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idViagem == null) ? 0 : idViagem.hashCode());
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
		Viagem other = (Viagem) obj;
		if (idViagem == null) {
			if (other.idViagem != null)
				return false;
		} else if (!idViagem.equals(other.idViagem))
			return false;
		return true;
	}
	
	
}
