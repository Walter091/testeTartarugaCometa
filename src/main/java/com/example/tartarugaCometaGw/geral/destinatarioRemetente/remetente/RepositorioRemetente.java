package com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRemetente extends CrudRepository<Remetente, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO remetente (ID_REMETENTE, CNPJ_CNPF, RAZAO_SOCIAL, NOME, ENDERECO) VALUES (:id, :cnpj, :razaoSocial, :nome, :endereco)", nativeQuery = true)
	public void salvarRemetente(@Param("id") Long id, @Param("cnpj") String cnpj, @Param("razaoSocial") String razaoSocial, @Param("nome") String nome, @Param("endereco") String endereco);

	@Modifying
	@Transactional
	@Query(value = "UPDATE remetente SET CNPJ_CNPF= :cnpj, RAZAO_SOCIAL= :razaoSocial, NOME=:nome, ENDERECO= :endereco WHERE ID_REMETENTE= :id", nativeQuery = true)
	public void alterar(@Param("id") Long id, @Param("cnpj") String cnpj, @Param("razaoSocial") String razaoSocial, @Param("nome") String nome, @Param("endereco") String endereco);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM remetente WHERE ID_REMETENTE = :id", nativeQuery = true)
	public void excluir(@Param("id") Long id);
//	
	// -----------------------------------------------------------------------------------------------
	
	@Query(value = "SELECT * FROM remetente", nativeQuery = true)
	public List<Remetente> obterListaRemetente(); 

	@Query(value = "SELECT * FROM remetente where CNPJ_CNPF=:cnpj", nativeQuery = true)
	public Remetente validarCnpjRepetido(@Param("cnpj") String cnpj);
	
	@Query(value = "SELECT MAX(ID_REMETENTE) FROM remetente", nativeQuery = true)
	public Integer obterId(); 

	@Query(value = "SELECT * FROM remetente WHERE ID_REMETENTE= :id", nativeQuery = true)
	public Optional<Remetente> getById(@Param("id") Long id);

	@Query(value = "SELECT * FROM remetente WHERE ID_REMETENTE= :id", nativeQuery = true)
	public Remetente getByIdQN(@Param("id") Long id);
	
}
