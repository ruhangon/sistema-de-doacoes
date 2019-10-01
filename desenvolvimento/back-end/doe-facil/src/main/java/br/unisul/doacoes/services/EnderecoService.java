package br.unisul.doacoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.doacoes.domain.Endereco;
import br.unisul.doacoes.repositories.EnderecoRepository;


@Service
public class EnderecoService {

		@Autowired
		private EnderecoRepository rep;
		
		
		
		public Endereco find (Integer id) {
			Optional<Endereco> obj = rep.findById(id);
			return obj.orElse(null);
		}
		
		
		public Endereco insert (Endereco obj) {
			obj.setId(null);
			return rep.save(obj);
		}

		
		public Endereco update (Endereco obj) {
			find(obj.getId());
			return rep.save(obj);
		}

		
		
		public List<Endereco> findAll(){
			return rep.findAll();
		}
		

		
}

