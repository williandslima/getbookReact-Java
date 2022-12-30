package com.devgetbook.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_postagem")
public class DevPostagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//	@Column name= definindo nome da coluna na tabela do banco, nulllabe nao pode ser nulo not nol
	@Column(name = "titulo", nullable = false)
	private String tituloLivro;

	@Column
	private String descricao;

	@Column
	private String foto;

	@Column
	private String autor;

	
	public DevPostagem() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the tituloLivro
	 */
	public String getTituloLivro() {
		return tituloLivro;
	}

	/**
	 * @param tituloLivro the tituloLivro to set
	 */
	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, descricao, foto, id, tituloLivro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DevPostagem)) {
			return false;
		}
		DevPostagem other = (DevPostagem) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(foto, other.foto) && Objects.equals(id, other.id)
				&& Objects.equals(tituloLivro, other.tituloLivro);
	}

	
	
}
