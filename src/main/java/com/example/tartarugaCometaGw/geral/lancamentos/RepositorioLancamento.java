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
	@Query(value = "UPDATE lancamento SET ID_PRODUTO= :produto, ID_REMETENTE= :remetente, ID_DESTINATARIO= :destinatario, IND_STATUS_LANCAMENTO= :status WHERE ID_LANCAMENTO= :id", nativeQuery = true)
	public void alterar(@Param("id") Long id, @Param("produto") Long produto, @Param("remetente") Long remetente, @Param("destinatario") Long destinatario, @Param("status") int status );
		
	//--------------------------------------------------------------------

	@Query(value = "SELECT * FROM lancamento WHERE ID_LANCAMENTO= :id", nativeQuery = true)
	public Lancamento getByIdQN(@Param("id") Long id);

//	@Query(value = "SELECT l.id_lancamento, p.nome, r.razaoSocial, d.razaoSocial"
//			+ "* FROM l lancamento "
//			+ "inner join p produto on (l.id_produto == p.id_produto)"
//			+ "inner join r remetente on (l.id_remetente == r.id_remetente)"
//			+ "inner join d destinatario on (l.id_destinatario == d.id_destinatario);", nativeQuery = true)
//	public List<String> getLancamentoToString();

}
