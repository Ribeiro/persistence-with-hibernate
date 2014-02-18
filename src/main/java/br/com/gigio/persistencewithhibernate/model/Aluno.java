package br.com.gigio.persistencewithhibernate.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3992011341978194016L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	@Basic(optional = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	@Basic(optional = false)
	private Date dataNascimento;

	@Column(name = "curso")
	@Basic(optional = false)
	private String curso;

	@Column(name = "tem_fies")
	@Basic(optional = false)
	private Boolean temFies;

	@Column(name = "quantidade_reprovacoes")
	@Basic(optional = true)
	private Integer quantidadeReprovacoes;

	public Aluno() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Boolean getTemFies() {
		return temFies;
	}

	public void setTemFies(Boolean temFies) {
		this.temFies = temFies;
	}

	public Integer getQuantidadeReprovacoes() {
		return quantidadeReprovacoes;
	}

	public void setQuantidadeReprovacoes(Integer quantidadeReprovacoes) {
		this.quantidadeReprovacoes = quantidadeReprovacoes;
	}

}