package br.unisul.doacoes.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aj.org.objectweb.asm.Type;
import br.unisul.doacoes.domain.Endereco;
import br.unisul.doacoes.domain.Usuario;
import br.unisul.doacoes.repositories.EnderecoRepository;
import br.unisul.doacoes.repositories.UsuarioRepository;


@Service
public class DbService {
	@Autowired
	private EnderecoRepository enderecoRep;

	@Autowired
	private UsuarioRepository usuarioRep;

	public void inicializaBancoDeDados() throws ParseException {
		Endereco e1 = new Endereco(1,"SC","Tubarão","Dehon","Rua das Flores","303","Apto 101");

		Usuario u1 = new Usuario(1, "João Silva", "js", "joao@gmail.com", "joao123",null, (byte) 24, "0123456789", 0, 0, e1);

		enderecoRep.saveAll(Arrays.asList(e1));
		usuarioRep.saveAll(Arrays.asList(u1));
	}

}
