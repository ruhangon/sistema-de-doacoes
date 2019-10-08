package br.unisul.doacoes.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDoacao;
	private String nomeDoacao;
	private ArrayList<String> imgDoacao;
	private String statusDoacao;
	private String metodoFrete;
	private String descricao;
	private int votosPositivosDoacao;
	private int votosNegativosDoacao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	@ManyToOne
	@JoinColumn(name = "doador_id")
	private Usuario doador;
	
	@ManyToOne
	@JoinColumn(name = "recebedor_id")
	private Usuario recebedor;
	
	
	
	public Doacao() {
		
	}
	public Doacao(Integer idDoacao, String nomeDoacao, ArrayList<String> imgDoacao, String statusDoacao,
			String metodoFrete, String descricao, int votosPositivosDoacao, int votosNegativosDoacao,
			LocalDate dataInicio, LocalDate dataFim, Usuario doador) {
		super();
		this.idDoacao = idDoacao;
		this.nomeDoacao = nomeDoacao;
		this.imgDoacao = imgDoacao;
		this.statusDoacao = statusDoacao;
		this.metodoFrete = metodoFrete;
		this.descricao = descricao;
		this.votosPositivosDoacao = votosPositivosDoacao;
		this.votosNegativosDoacao = votosNegativosDoacao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.doador = doador;
	}
	public Integer getIdDoacao() {
		return idDoacao;
	}
	public void setIdDoacao(Integer idDoacao) {
		this.idDoacao = idDoacao;
	}
	public String getNomeDoacao() {
		return nomeDoacao;
	}
	public void setNomeDoacao(String nomeDoacao) {
		this.nomeDoacao = nomeDoacao;
	}
	public ArrayList<String> getImgDoacao() {
		return imgDoacao;
	}
	public void setImgDoacao(ArrayList<String> imgDoacao) {
		this.imgDoacao = imgDoacao;
	}
	public String getStatusDoacao() {
		return statusDoacao;
	}
	public void setStatusDoacao(String statusDoacao) {
		this.statusDoacao = statusDoacao;
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
	public int getVotosPositivosDoacao() {
		return votosPositivosDoacao;
	}
	public void setVotosPositivosDoacao(int votosPositivosDoacao) {
		this.votosPositivosDoacao = votosPositivosDoacao;
	}
	public int getVotosNegativosDoacao() {
		return votosNegativosDoacao;
	}
	public void setVotosNegativosDoacao(int votosNegativosDoacao) {
		this.votosNegativosDoacao = votosNegativosDoacao;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDoacao == null) ? 0 : idDoacao.hashCode());
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
		if (idDoacao == null) {
			if (other.idDoacao != null)
				return false;
		} else if (!idDoacao.equals(other.idDoacao))
			return false;
		return true;
	}
	
}
