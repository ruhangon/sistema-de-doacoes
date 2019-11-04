package br.unisul.doacoes.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeCompleto;
	private String nomeUsuario;
	private String email;
	private String senha;
	private String dataNasc;
	private Byte idade;
	private String cpf;
	private String img;
	private Integer votosPositivos;
	private Integer votosNegativos;

	@OneToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Notificacao> notificacoes = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "doador")
	private List<Doacao> feitas = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "recebedor")
	private List<Doacao> recebidas = new ArrayList<>();

	public Usuario() {
	}

	public Usuario(Integer id, String nomeCompleto, String nomeUsuario, String email, String senha, String dataNasc,
			String cpf, String img, Integer votosPositivos, Integer votosNegativos, Endereco endereco) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.img = img;
		this.votosPositivos = votosPositivos;
		this.votosNegativos = votosNegativos;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Notificacao> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(List<Notificacao> notificacoes) {
		this.notificacoes = notificacoes;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<Doacao> getFeitas() {
		return feitas;
	}

	public void setFeitas(List<Doacao> feitas) {
		this.feitas = feitas;
	}

	public List<Doacao> getRecebidas() {
		return recebidas;
	}

	public void setRecebidas(List<Doacao> recebidas) {
		this.recebidas = recebidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
