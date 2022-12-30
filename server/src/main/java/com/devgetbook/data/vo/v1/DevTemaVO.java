package com.devgetbook.data.vo.v1;

import java.io.Serializable;

import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;


//@Tag(name= "Authentication Endpoint")
@JsonPropertyOrder({"id","genero","categoria"}) //ordenando como mostrar
public class DevTemaVO extends RepresentationModel <DevTemaVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id") //mostrar id em vez de KEY nos metodos GET, POST .....
	@Mapping("id") //mappeando id em vem de KEY ....
	private Long key; //alterado para kEy por que em HATEOS ja tem o ID
	@JsonProperty ("Titulo") // definindo o nome que vai aparece
	private String genero;
	private String categoria;


	public DevTemaVO() {
	}

	/**
	 * @return the id
	 */
	public Long getKey() {
		return key;
	}

	/**
	 * @param id the id to set
	 */
	public void setKey(Long key) {
		this.key = key;
	}

	/**
	 * @return the tituloLivro
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the tituloLivro to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the descricao
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the descricao to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(categoria, genero, key);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof DevTemaVO)) {
			return false;
		}
		DevTemaVO other = (DevTemaVO) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(genero, other.genero)
				&& Objects.equals(key, other.key);
	}


	/**
	 * @return the autor
	 */




}
