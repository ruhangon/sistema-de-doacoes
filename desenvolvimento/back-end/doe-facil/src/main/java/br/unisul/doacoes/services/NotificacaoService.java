package br.unisul.doacoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.doacoes.domain.Notificacao;
import br.unisul.doacoes.repositories.NotificacaoRepository;

@Service
public class NotificacaoService {

	@Autowired
	private NotificacaoRepository rep;

	@Autowired
	private UsuarioService usuarioService;

	public List<Notificacao> findByUsuario(Integer usuarioId) {
		return rep.findNotificacoes(usuarioId);
	}

	public Notificacao findById(Integer id) {
		Optional<Notificacao> obj = rep.findById(id);
		return obj.orElse(null);
	}

	public Notificacao insert(Notificacao obj) {
		obj.setId(null);
		obj.setUsuario(usuarioService.findById(obj.getUsuario().getId()));
		return rep.save(obj);
	}

	public Notificacao update(Notificacao obj) {
		findById(obj.getId());
		return rep.save(obj);
	}

	public List<Notificacao> findAll() {
		return rep.findAll();
	}

}
