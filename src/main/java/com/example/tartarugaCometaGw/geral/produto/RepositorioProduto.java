package com.example.tartarugaCometaGw.geral.produto;

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
	public void salvarDestinatario(@Param("id") Long id, @Param("nome") String nome, @Param("peso") Float peso, @Param("volume") String volume, @Param("valor") Float valor);

}
