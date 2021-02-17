package com.michelalves.turismoControle.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Passageiro")
@Table(name="Passageiro", uniqueConstraints = {@UniqueConstraint(columnNames= {"cpfOuRgCertidao"}, name="IDXUKPasseiro_cpfOuRgCertidao")})
public class Passageiro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPassageiro;
	private String nome;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	private String sexo;
	private String cpfOuRgCertidao;
	private String telefone;
	private String endereco;
	
	@JsonIgnore
	@ManyToMany(mappedBy="passageiros")
	private List<Viagem> viagens = new ArrayList<>();
	
	@OneToMany(mappedBy = "passageiro")
	private List<Financeiro> financeiros = new ArrayList<>();
	
	public Passageiro() {
		
	}

	public Passageiro(Integer idPasseiro, String nome, Date dataNascimento, String sexo, String cpfOuRgCertidao,
			String telefone, String endereco) {
		super();
		this.idPassageiro = idPasseiro;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpfOuRgCertidao = cpfOuRgCertidao;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getId() {
		return idPassageiro;
	}

	public void setId(Integer id) {
		this.idPassageiro = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpfOuRgCertidao() {
		return cpfOuRgCertidao;
	}

	public void setCpfOuRgCertidao(String cpfOuRgCertidao) {
		this.cpfOuRgCertidao = cpfOuRgCertidao;
	}
	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getIdPassageiro() {
		return idPassageiro;
	}

	public void setIdPassageiro(Integer idPassageiro) {
		this.idPassageiro = idPassageiro;
	}

	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}

	public List<Financeiro> getFinanceiros() {
		return financeiros;
	}

	public void setFinanceiros(List<Financeiro> financeiros) {
		this.financeiros = financeiros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPassageiro == null) ? 0 : idPassageiro.hashCode());
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
		Passageiro other = (Passageiro) obj;
		if (idPassageiro == null) {
			if (other.idPassageiro != null)
				return false;
		} else if (!idPassageiro.equals(other.idPassageiro))
			return false;
		return true;
	}
	
}
