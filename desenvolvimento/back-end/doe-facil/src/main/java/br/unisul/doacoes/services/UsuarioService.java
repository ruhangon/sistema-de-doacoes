package br.unisul.doacoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.doacoes.domain.Usuario;
import br.unisul.doacoes.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findById(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario insert(Usuario usuario) {
		usuario.setId(null);
		return usuarioRepository.save(usuario);
	}

	public Usuario update(Usuario usuario) {
		findById(usuario.getId());
		return usuarioRepository.save(usuario);
	}

}
