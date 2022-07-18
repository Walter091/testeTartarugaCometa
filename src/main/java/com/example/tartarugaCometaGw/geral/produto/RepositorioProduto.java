package com.example.tartarugaCometaGw.geral.produto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProduto extends CrudRepository<Produto, Long>{
	
	@Query(value = "SELECT id_produto FROM produto "
			+ "where NOME=:nome or VALOR=:valor", nativeQuery = true)
	public Long obterPelosCampos(@Param("nome") String nome, @Param("valor") Float valor);

}
