package br.unisul.doacoes.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import br.unisul.doacoes.domain.Doacao;

public class DoacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private static final String[] categoria = new String[] { "brinquedos", "eletrônicos", "esportes", "livros", "roupas", "saúde", "outros" };
	private String[] img;
	private String status;
	private String metodoFrete;
	private String descricao;
	private int votosPositivos;
	private int votosNegativos;
	private LocalDate dataInicio;
	private LocalDate dataFim;

	public DoacaoDTO() {
	}

	public DoacaoDTO(Doacao obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.status = obj.getStatus();
		this.metodoFrete = obj.getMetodoFrete();
		this.descricao = obj.getDescricao();
		this.votosPositivos = obj.getVotosPositivos();
		this.votosNegativos = obj.getVotosNegativos();
		this.dataInicio = obj.getDataInicio();
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

}
