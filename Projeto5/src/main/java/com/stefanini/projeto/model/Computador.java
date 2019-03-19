package com.stefanini.projeto.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Computador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="SQ_CP_ID", sequenceName="SQ_CP_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_CP_ID")
	@Column(name="CP_ID")
	private Long id;
	
	@Column(name="CP_NOME")
	private String nome;
	
	@OneToMany(mappedBy="computador", cascade =	CascadeType.ALL)
	private List<Monitor> monitores;
	
	public Computador() {
		
	}

	public Computador(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	public List<Monitor> getMonitores() {
		return monitores;
	}

	public void addMonitores(Monitor monitor) {
		this.monitores.add(monitor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((monitores == null) ? 0 : monitores.hashCode());
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
		Computador other = (Computador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (monitores == null) {
			if (other.monitores != null)
				return false;
		} else if (!monitores.equals(other.monitores))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
