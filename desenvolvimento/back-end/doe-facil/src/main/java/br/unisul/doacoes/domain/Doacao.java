package br.unisul.doacoes.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Doacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private static final String[] categoria = new String[] { "eletrônico", "esporte", "ferramenta", "roupa", "saúde" };
	private String[] img;
	private String status;
	private String metodoFrete;
	private String descricao;
	private int votosPositivos;
	private int votosNegativos;
	private LocalDate dataInicio;
	private LocalDate dataFim;

	@ManyToOne
	@JoinColumn(name = "doador_id")
	private Usuario doador;

	@ManyToOne
	@JoinColumn(name = "recebedor_id")
	private Usuario recebedor;

	// por enquanto também não há doador e recebedor no construtor com parâmetros

	public Doacao() {
	}

	public Doacao(Integer id, String nome, String status, String metodoFrete, String descricao, Integer votosPositivos,
			Integer votosNegativos, LocalDate dataInicio, Usuario doador) {
		super();
		this.id = id;
		this.nome = nome;
		this.status = status;
		this.metodoFrete = metodoFrete;
		this.descricao = descricao;
		this.votosPositivos = votosPositivos;
		this.votosNegativos = votosNegativos;
		this.dataInicio = dataInicio;
		this.doador = doador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static String[] getCategoria() {
		return categoria;
	}

	public String[] getImg() {
		return img;
	}

	public void setImg(String[] img) {
		this.img = img;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMetodoFrete() {
		return metodoFrete;
	}

	public void setMetodoFrete(String metodoFrete) {
		this.metodoFrete = metodoFrete;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getVotosPositivos() {
		return votosPositivos;
	}

	public void setVotosPositivos(int votosPositivos) {
		this.votosPositivos = votosPositivos;
	}

	public int getVotosNegativos() {
		return votosNegativos;
	}

	public void setVotosNegativos(int votosNegativos) {
		this.votosNegativos = votosNegativos;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Usuario getDoador() {
		return doador;
	}

	public void setDoador(Usuario doador) {
		this.doador = doador;
	}

	public Usuario getRecebedor() {
		return recebedor;
	}

	public void setRecebedor(Usuario recebedor) {
		this.recebedor = recebedor;
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
		Doacao other = (Doacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}