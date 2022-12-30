package com.devgetbook.model;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import javax.persistence.*;

@Entity
@Table(name = "tb_temas")
public class DevTema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "O Atributo id e obrigatorio")
	private Long id;

	@NotBlank
	@Size(min = 3, max = 15, message = "O Atributo Genero deve conter no minimo 3 e no maximo 15")
	private String genero;

	@NotBlank
	@Size(min = 3, max = 15, message = "O Atributo Categoria deve conter no minimo 3 e no maximo 15")
	private String categoria;
	/*
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<DevPostagem> postagem;
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


/*
	public List<DevPostagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<DevPostagem> postagem) {
		this.postagem = postagem;
	}



	*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DevTema other = (DevTema) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}






}
