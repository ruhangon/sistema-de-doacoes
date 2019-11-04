package br.unisul.doacoes.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import br.unisul.doacoes.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomeUsuario;
	private String nomeCompleto;
	private String email;
	private String senha;
	private String dataNasc;
	private String cpf;
	private String img;
	private Integer votosPositivos;
	private Integer votosNegativos;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario obj) {
		this.id = obj.getId();
		this.nomeUsuario = obj.getNomeUsuario();
		this.nomeCompleto = obj.getNomeCompleto();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.dataNasc = obj.getDataNasc();
		this.cpf = obj.getCpf();
		this.img = obj.getImg();
		this.votosPositivos = obj.getVotosPositivos();
		this.votosNegativos = obj.getVotosNegativos();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getVotosPositivos() {
		return votosPositivos;
	}

	public void setVotosPositivos(Integer votosPositivos) {
		this.votosPositivos = votosPositivos;
	}

	public Integer getVotosNegativos() {
		return votosNegativos;
	}

	public void setVotosNegativos(Integer votosNegativos) {
		this.votosNegativos = votosNegativos;
	}

}
