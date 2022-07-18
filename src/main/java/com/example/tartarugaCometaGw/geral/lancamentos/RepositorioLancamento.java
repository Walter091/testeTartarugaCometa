package com.example.tartarugaCometaGw.geral.lancamentos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLancamento extends CrudRepository<Lancamento, Long>{
	
	@Query(value = "SELECT * FROM lancamento WHERE ID_REMETENTE=:remetente AND ID_DESTINATARIO=:destinatario", nativeQuery = true)
	public Lancamento getLancamentoRepetido(@Param("remetente") Long remetente, @Param("destinatario") Long destinatario);
	
	@Query(value = "SELECT id_lancamento FROM lancamento "
			+ "where ID_DESTINATARIO=:idD or ID_REMETENTE=:idR", nativeQuery = true)
	public Long obterPelosCampos(@Param("idD") Long idD, @Param("idR") Long idR);

}
