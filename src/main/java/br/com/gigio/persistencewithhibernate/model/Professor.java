package br.com.gigio.persistencewithhibernate.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Professor extends Pessoa {

	private static final long serialVersionUID = -7089356107142805240L;
	
	@Column(name = "titulacao")
    @Basic(optional = false)
    private String titulacao;

    public Professor() {
    
    }

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}   
    
}