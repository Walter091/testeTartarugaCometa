package com.example.tartarugaCometaGw.geral.produto;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProduto extends CrudRepository<Produto, Long>{
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO produto (ID_PRODUTO, NOME, PESO, VOLUME, VALOR) VALUES (:id, :nome, :peso, :volume, :valor)", nativeQuery = true)
	public void salvarProduto(@Param("id") Long id, @Param("nome") String nome, @Param("peso") Float peso, @Param("volume") String volume, @Param("valor") Float valor);

	@Modifying
	@Transactional
	@Query(value = "UPDATE produto SET NOME= :nome, PESO= :peso, VOLUME=:volume, VALOR= :valor WHERE ID_PRODUTO= :id", nativeQuery = true)
	public void alterar(@Param("id") Long id, @Param("nome") String nome, @Param("peso") Float peso, @Param("volume") String volume, @Param("valor") Float valor);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM produto WHERE ID_PRODUTO = :id", nativeQuery = true)
	public void excluir(@Param("id") Long id);
	
	// -----------------------------------------------------------------------------------------------
	
	@Query(value = "SELECT * FROM produto", nativeQuery = true)
	public List<Produto> obterListaProduto(); 
	
	@Query(value = "SELECT MAX(ID_PRODUTO) FROM produto", nativeQuery = true)
	public Integer obterId(); 

	@Query(value = "SELECT * FROM produto WHERE ID_PRODUTO= :id", nativeQuery = true)
	public Optional<Produto> getById(@Param("id") Long id);

	@Query(value = "SELECT * FROM produto WHERE ID_PRODUTO= :id", nativeQuery = true)
	public Produto getByIdQN(@Param("id") Long id);
	

}
