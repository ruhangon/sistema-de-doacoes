package br.unisul.doacoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.doacoes.domain.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {
	// pegar todas as doaçoes feitas de um usuario
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Doacao obj WHERE obj.doador.id = :doadorId")
	public List<Doacao> findFeitas(@Param("doadorId") Integer doador_id);

	// pegar todas as doaçoes feitas de um usuario
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Doacao obj WHERE obj.recebedor.id = :recebedorId")
	public List<Doacao> findRecebidas(@Param("recebedorId") Integer recebedor_id);

}
