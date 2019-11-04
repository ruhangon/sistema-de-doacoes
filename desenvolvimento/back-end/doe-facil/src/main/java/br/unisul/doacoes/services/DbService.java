package br.unisul.doacoes.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.doacoes.domain.Doacao;
import br.unisul.doacoes.domain.Endereco;
import br.unisul.doacoes.domain.Notificacao;
import br.unisul.doacoes.domain.Usuario;
import br.unisul.doacoes.repositories.DoacaoRepository;
import br.unisul.doacoes.repositories.EnderecoRepository;
import br.unisul.doacoes.repositories.NotificacaoRepository;
import br.unisul.doacoes.repositories.UsuarioRepository;

@Service
public class DbService {

	@Autowired
	private EnderecoRepository enderecoRep;

	@Autowired
	private UsuarioRepository usuarioRep;

	@Autowired
	private NotificacaoRepository notificacaoRep;

	@Autowired
	private DoacaoRepository doacaoRep;

	public void inicializaBancoDeDados() throws ParseException {

		Endereco e1 = new Endereco(1, "SC", "Tubarão", "Dehon", "Rua das Flores", "303", "Apartamento 101");
		Endereco e2 = new Endereco(2, "SC", "Tubarão", "Dehon", "Rua das Flores", "205", "Apartamento 10");

		Usuario usuario1 = new Usuario(1, "João Silva", "joaosilva", "joao@gmail.com", "joao123", "15/10/1992",
				"06593254337", "c:/doefacil/imagens/perfil/joaosilva", 0, 0, e1);
		Usuario usuario2 = new Usuario(2, "Marcos Dias", "marcosdias", "marcos@gmail.com", "marcos321", "20/04/1990",
				"03212345697", "c:/doefacil/imagens/perfil/marcosdias", 0, 0, e2);

		Notificacao n1 = new Notificacao(1, "Há um interessado na sua Doaçao", false, usuario1);
		Notificacao n2 = new Notificacao(2, "Usuário enviou doação para você", true, usuario2);

		Doacao d1 = new Doacao(1,"Doa-se Notebook","Disponível","Recebedor Paga o Frete","Notebook antigo mas bem conservado",20,5,null,usuario1);
		Doacao d2 = new Doacao(2,"Doa-se carrinho de mão","Disponível","Doador Paga o Frete","Não precisarei usar mais",14,3,null,usuario1);

		enderecoRep.saveAll(Arrays.asList(e1, e2));

		usuarioRep.saveAll(Arrays.asList(usuario1, usuario2));

		notificacaoRep.saveAll(Arrays.asList(n1, n2));

		doacaoRep.saveAll(Arrays.asList(d1,d2));

	}

}
