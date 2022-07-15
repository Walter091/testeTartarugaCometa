package com.example.tartarugaCometaGw.geral.lancamentos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLancamento extends CrudRepository<Lancamento, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE lancamento SET ID_PRODUTO= :produto, ID_REMETENTE= :remetente, ID_DESTINATARIO= :destinatario WHERE ID_LANCAMENTO= :id", nativeQuery = true)
	public void alterar(@Param("id") Long id, @Param("produto") Long produto, @Param("remetente") Long remetente, @Param("destinatario") Long destinatario);
		
	//--------------------------------------------------------------------

	@Query(value = "SELECT * FROM lancamento WHERE ID_LANCAMENTO= :id", nativeQuery = true)
	public Lancamento getByIdQN(@Param("id") Long id);

}
