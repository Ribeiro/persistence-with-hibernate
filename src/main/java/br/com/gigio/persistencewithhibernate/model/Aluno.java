package br.com.gigio.persistencewithhibernate.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Aluno extends Pessoa {

	private static final long serialVersionUID = 5884979528981071630L;
	
	@Column(name = "matricula")
    @Basic(optional = false)
    private String matricula;

    public Aluno() {
    
    }

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}