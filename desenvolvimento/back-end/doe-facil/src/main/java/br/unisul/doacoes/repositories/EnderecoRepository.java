package br.unisul.doacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisul.doacoes.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
