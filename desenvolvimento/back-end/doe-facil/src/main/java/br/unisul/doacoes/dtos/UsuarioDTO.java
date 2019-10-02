package br.unisul.doacoes.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.mysql.cj.jdbc.Blob;

import br.unisul.doacoes.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomeUsuario;
	private String nomeCompleto;
	private String email;
	private String cpf;
	private Integer votosPositivosUsuario;
	private Integer votosNegativosUsuario;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario user) {
		id = user.getIdUsuario();
		nomeUsuario = user.getNomeUsuario();
		nomeCompleto = user.getNomeCompleto();
		email = user.getEmail();
		cpf = user.getCpf();
		votosPositivosUsuario = user.getVotosPositivosUsuario();
		votosNegativosUsuario = user.getVotosNegativosUsuario();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getVotosPositivosUsuario() {
		return votosPositivosUsuario;
	}

	public void setVotosPositivosUsuario(Integer votosPositivosUsuario) {
		this.votosPositivosUsuario = votosPositivosUsuario;
	}

	public Integer getVotosNegativosUsuario() {
		return votosNegativosUsuario;
	}

	public void setVotosNegativosUsuario(Integer votosNegativosUsuario) {
		this.votosNegativosUsuario = votosNegativosUsuario;
	}

}
