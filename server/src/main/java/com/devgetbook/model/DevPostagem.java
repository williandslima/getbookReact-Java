package com.devgetbook.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
//teste
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

	/*
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	@NotNull
	private DevTema tema;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	@NotNull
	private DevUsuario usuario;

*/
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



/*
	public DevTema getTema() {
		return tema;
	}

	public void setTema(DevTema tema) {
		this.tema = tema;
	}

	public DevUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(DevUsuario usuario) {
		this.usuario = usuario;
	}
*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tituloLivro == null) ? 0 : tituloLivro.hashCode());
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
		DevPostagem other = (DevPostagem) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tituloLivro == null) {
			if (other.tituloLivro != null)
				return false;
		} else if (!tituloLivro.equals(other.tituloLivro))
			return false;
		return true;
	}




}
