package br.unisul.doacoes.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.mysql.cj.jdbc.Blob;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String nomeCompleto;
	private String nomeUsuario;
	private String email;
	private String senha;
	private LocalDate dataNasc;
	private Byte idade;
	private String cpf;
//	private Blob imgUsuario;
	private Integer votosPositivosUsuario;
	private Integer votosNegativosUsuario;
	

	
	
	@OneToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
//	@OneToMany
//	@JoinTable(name = "NOTIFICACAO",
//		joinColumns = @JoinColumn(name = "idNotificacao"),
//		inverseJoinColumns = @JoinColumn(name = "idUsuario")
//	)
//	@OneToMany
//	@JoinTable(name = "DOACAO",
//		joinColumns = @JoinColumn(name = "idDoacao"),
//		inverseJoinColumns = @JoinColumn(name = "idUsuario")
//	)
	
	public Usuario() {
		
	}
	public Usuario(Integer idUsuario, String nomeCompleto, String nomeUsuario, String email, String senha,
			LocalDate dataNasc, Byte idade, String cpf, Integer votosPositivosUsuario,
			Integer votosNegativosUsuario,Endereco endereco) {
		this.idUsuario = idUsuario;
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
		this.dataNasc = dataNasc;
		this.idade = idade;
		this.cpf = cpf;
//		this.imgUsuario = imgUsuario;
		this.votosPositivosUsuario = votosPositivosUsuario;
		this.votosNegativosUsuario = votosNegativosUsuario;
		this.endereco = endereco;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Byte getIdade() {
		return idade;
	}
	public void setIdade(Byte idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
//	public Blob getImgUsuario() {
//		return imgUsuario;
//	}
//	public void setImgUsuario(Blob imgUsuario) {
//		this.imgUsuario = imgUsuario;
//	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
}
