package br.unisul.doacoes.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.doacoes.domain.Doacao;
import br.unisul.doacoes.domain.Notificacao;
import br.unisul.doacoes.domain.Usuario;
import br.unisul.doacoes.repositories.DoacaoRepository;
import br.unisul.doacoes.repositories.NotificacaoRepository;
import br.unisul.doacoes.repositories.UsuarioRepository;


@Service
public class DbService {
	
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private NotificacaoRepository notificacaoRep;
	
	@Autowired
	private DoacaoRepository doacaoRep;

	public void inicializaBancoDeDados() throws ParseException {
		
		Usuario u1 = new Usuario(1, "João Silva", "js", "joao@gmail.com", "joao123","25/11/1990", "Santa Catarina","Tubarão","Dehon","Rua das Flores","303","Apto 101");
		Usuario u2 = new Usuario(2, "Maria Penha", "mp", "maria@gmail.com", "maria123","25/11/1991", "Santa Catarina","São Ludgero","Centro","Rua das Orquídeas","895","");
		
		Notificacao n1 = new Notificacao(1,"Há um interessado na sua Doaçao",u2,u1);
		Notificacao n2 = new Notificacao(2,"Usuário enviou doaçao para você",u1,u2);
		
		Doacao d1 = new Doacao(1,"Doa-se Cachorro","Categoria1","caminho da imagem","Disponível","Recebedor Paga o Frete","Cachorro encomoda muito não dá mais",null,u2,u1);
		Doacao d2 = new Doacao(2,"Doa-se Vaca","Categoria2","caminho da imagem","Disponível","Doador Paga o Frete","Estou de mudança",null,u1,u2);
		Doacao d3 = new Doacao(3,"Doa-se Leitão","Categoria2","caminho da imagem","Disponível","Doador Paga o Frete","Removi o chiqueiro da fazenda",null,u1,null);
		Doacao d4 = new Doacao(4,"Doa-se Bezerro","Categoria2","caminho da imagem","Disponível","Doador Paga o Frete","Preciso de espaço no sítio",null,u1,null);
		Doacao d5 = new Doacao(5,"Doa-se Bode","Categoria3","caminho da imagem","Disponível","Doador Paga o Frete","Faz muito barulho",null,u2,null);
		Doacao d6 = new Doacao(6,"Doa-se Hipopotamo","Categoria4","caminho da imagem","Disponível","Doador Paga o Frete","Não sabia que ia crescer tanto",null,u2,u1);
		
		d6.setRecebedor(u2);
		d6.setStatus("Finalizada");

		usuarioRep.saveAll(Arrays.asList(u1,u2));
		notificacaoRep.saveAll(Arrays.asList(n1,n2));
		doacaoRep.saveAll(Arrays.asList(d1,d2,d3,d4,d5,d6));
	
	}

}
