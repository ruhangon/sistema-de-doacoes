package br.unisul.doacoes.dtos;

import java.io.Serializable;

import br.unisul.doacoes.domain.Notificacao;

public class NotificacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String conteudo;
	private boolean lida;

	public NotificacaoDTO() {
	}

	public NotificacaoDTO(Notificacao obj) {
		this.id = obj.getId();
		this.conteudo = obj.getConteudo();
		this.lida = obj.isLida();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public boolean isLida() {
		return lida;
	}

	public void setLida(boolean lida) {
		this.lida = lida;
	}

}
