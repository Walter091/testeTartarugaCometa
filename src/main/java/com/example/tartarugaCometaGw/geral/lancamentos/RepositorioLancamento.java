package com.example.tartarugaCometaGw.geral.lancamentos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario.Destinatario;
import com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente.Remetente;
import com.example.tartarugaCometaGw.geral.transportadora.Produto;

@Repository
public interface RepositorioLancamento extends CrudRepository<Lancamento, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO lancamento (ID_PRODUTO, ID_REMETENTE, ID_DESTINATARIO) VALUES (:produto, :remetente, :destino)", nativeQuery = true)
	public void salvar(@Param("produto") Integer produto, @Param("remetente") Integer remetente, @Param("destino") Integer destino);

	@Modifying
	@Transactional
	@Query(value = "UPDATE lancamento SET ID_PRODUTO= :produto, ID_REMETENTE= :remetente, ID_DESTINATARIO= :destinatario WHERE ID_LANCAMENTO= :id", nativeQuery = true)
	public void alterar(@Param("id") Integer id, @Param("produto") Integer produto, @Param("remetente") Integer remetente, @Param("destinatario") Integer destinatario);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM lancamento WHERE ID_LANCAMENTO = :id", nativeQuery = true)
	public void excluir(@Param("id") Integer id);
	
	//--------------------------------------------------------------------
	
	@Query(value = "SELECT * FROM produto", nativeQuery = true)
	public List<Produto> getListProdutos();
	
	@Query(value = "SELECT * FROM remetente", nativeQuery = true)
	public List<Remetente> getListRemetentes();
	
	@Query(value = "SELECT * FROM destinatario", nativeQuery = true)
	public List<Destinatario> getListDestinatarios();

	@Query(value = "SELECT * FROM lancamento WHERE ID_LANCAMENTO= :id", nativeQuery = true)
	public Optional<Lancamento> getById(@Param("id") Integer id);

	@Query(value = "SELECT * FROM lancamento WHERE ID_LANCAMENTO= :id", nativeQuery = true)
	public Lancamento getByIdQN(@Param("id") Integer id);

}
