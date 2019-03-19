package com.stefanini.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Monitor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="SQ_MN_ID", sequenceName="SQ_MN_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_MN_ID")
	@Column(name="MN_ID")
	private Long id;
	
	@Column(name="MN_NOME")
	private String nome;
	
	@ManyToOne
	@com.fasterxml.jackson.annotation.JsonIgnore
	@JoinColumn(name="CP_ID", referencedColumnName="CP_ID")
	private Computador computador;
	
	public Monitor() {
		
	}

	public Monitor(Long id, String nome, Computador computador) {
		super();
		this.id = id;
		this.nome = nome;
		this.computador = computador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Computador getComputador() {
		return computador;
	}

	public void setComputador(Computador computador) {
		this.computador = computador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((computador == null) ? 0 : computador.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Monitor other = (Monitor) obj;
		if (computador == null) {
			if (other.computador != null)
				return false;
		} else if (!computador.equals(other.computador))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
