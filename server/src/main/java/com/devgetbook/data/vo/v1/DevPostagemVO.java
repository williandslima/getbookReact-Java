package com.devgetbook.data.vo.v1;

import java.io.Serializable;

import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;


//@Tag(name= "Authentication Endpoint")
@JsonPropertyOrder({"id","tituloLivro","descricao" }) //ordenando como mostrar
public class DevPostagemVO extends RepresentationModel <DevPostagemVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id") //mostrar id em vez de KEY nos metodos GET, POST .....
	@Mapping("id") //mappeando id em vem de KEY ....
	private Long key; //alterado para kEy por que em HATEOS ja tem o ID
	@JsonProperty ("nome") // definindo o nome que vai aparece
	private String tituloLivro;
	private String descricao;
	@JsonIgnore //inorando na vizuali do post(json)
	private String foto;
	private String autor;


	public DevPostagemVO() {
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
		return Objects.hash(autor, descricao, foto, key, tituloLivro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DevPostagemVO)) {
			return false;
		}
		DevPostagemVO other = (DevPostagemVO) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(foto, other.foto) && Objects.equals(key, other.key)
				&& Objects.equals(tituloLivro, other.tituloLivro);
	}



}
