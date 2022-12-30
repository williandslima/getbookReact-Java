package com.devgetbook.model;


//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table (name = "tb_usuarios")
public class DevUsuario{


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull
		private String nome;

		@NotNull
		@Schema(example = "email@email.com")
		private String usuario;

		@Size(min = 8, message = "A senha deve conter no minimo 8 caracteres")
		@NotNull
		private String senha;

		@Size(min = 3, max = 255, message = " Coloque o link da sua foto")
		private String foto;
/*
		@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("usuario")
	//	//@NotNull
		List<DevPostagem> postagem;
*/
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

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}
/*
		public List<DevPostagem> getPostagem() {
			return postagem;
		}

		public void setPostagem(List<DevPostagem> postagem) {
			this.postagem = postagem;
		}

	*/
}
