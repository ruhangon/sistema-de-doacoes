package br.unisul.doacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.doacoes.domain.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

}
