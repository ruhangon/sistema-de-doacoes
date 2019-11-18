package br.unisul.doacoes.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.doacoes.domain.Doacao;
import br.unisul.doacoes.domain.Usuario;
import br.unisul.doacoes.repositories.DoacaoRepository;
import br.unisul.doacoes.repositories.UsuarioRepository;


@Service
public class DbService {
	
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private DoacaoRepository doacaoRep;

	public void inicializaBancoDeDados() throws ParseException {
		
		Usuario u1 = new Usuario(1, "João Silva", "js", "joao@gmail.com", "joao123","25/11/1990", "Santa Catarina","Tubarão","Dehon","Rua das Flores","303","Apto 101");
		Usuario u2 = new Usuario(2, "Maria Penha", "mp", "maria@gmail.com", "maria123","25/11/1991", "Paraná","Curitiba","Centro","Rua das Orquídeas","895","");
		
		u1.setCpf("123.456.789-90");
		u2.setCpf("987.654.321-01");
		
		u1.setImgUsuario("user");
		u2.setImgUsuario("user");
		
		
		Doacao d1 = new Doacao(1,"Camisa","Vestimenta","1","Finalizada","Recebedor Paga o Frete","Descrição","15/11/2009",u2,u1);
		Doacao d2 = new Doacao(2,"Cesto","Outros","2","Finalizada","Doador Paga o Frete","Descrição","13/11/2010",u1,u2);
		Doacao d3 = new Doacao(3,"Chave Philips","Ferramentas","3","Disponível","Doador Paga o Frete","Descrição","14/11/2019",u1,null);
		Doacao d4 = new Doacao(4,"Alicate de corte","Ferramentas","4","Disponível","Doador Paga o Frete","Descrição","7/04/2019",u1,null);
		Doacao d5 = new Doacao(5,"Ursinho","Brinquedos","5","Disponível","Doador Paga o Frete","Descrição","5/07/2019",u2,null);
		Doacao d6 = new Doacao(6,"Alice no País das Maravilhas","Livros","6","Disponível","Doador Paga o Frete","Descrição","15/05/2019",u2,null);
		Doacao d7 = new Doacao(7,"Mouse de bola","Eletrônicos","7","Disponível","Doador Paga o Frete","Descrição","15/05/2019",u1,null);
		Doacao d8 = new Doacao(8,"Teclado branco com teclas de tijolo","Eletrônicos","8","Disponível","Doador Paga o Frete","Descrição","15/05/2019",u2,null);
		Doacao d9 = new Doacao(9,"Vassoura","Ferramentas","9","Disponível","Doador Paga o Frete","Descrição","15/05/2019",u1,null);
		Doacao d10 = new Doacao(10,"Funil","Ferramentas","10","Disponível","Doador Paga o Frete","Descrição","15/05/2019",u2,null);
		Doacao d11 = new Doacao(11,"Trivago","Outros","11","Disponível","Doador Paga o Frete","Descrição","15/05/2019",u2,null);
		Doacao d12 = new Doacao(12,"Dinheiro","Ferramentas","12","Disponível","Doador Paga o Frete","Descrição","15/05/2019",u1,null);
		
		d1.setDataFim("2/03/2011");
		d2.setDataFim("18/04/2012");

		usuarioRep.saveAll(Arrays.asList(u1,u2));
		doacaoRep.saveAll(Arrays.asList(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12));
		
	
	}

}
