package br.unisul.doacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.doacoes.domain.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Integer>{
	@Transactional (readOnly = true)
    Doacao findByNomeDoacao(String nomeDoacao);
}
