package br.unisul.doacoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.unisul.doacoes.domain.Doacao;
import br.unisul.doacoes.repositories.DoacaoRepository;

public class DoacaoService {
	
	@Autowired
	private DoacaoRepository rep;

	public Doacao find (Integer id) {
		Optional<Doacao> obj = rep.findById(id);
		return obj.orElse(null);
	}

	public Doacao insert (Doacao obj) {
		obj.setIdDoacao(null);
		return rep.save(obj);
	}

	public Doacao update (Doacao obj) {
		find(obj.getIdDoacao());
		return rep.save(obj);
	}

	public List<Doacao> findAll(){
		return rep.findAll();
	}
	public void delete (Doacao id) {
		find(id.getIdDoacao());
		rep.deleteById(id.getIdDoacao());
	}
	public Doacao findByNomeDoacao(String nomeDoacao) {
        Doacao obj = rep.findByNomeDoacao(nomeDoacao);
        return obj;
}
}


