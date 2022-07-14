package com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente;

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
	@Query(value = "INSERT INTO remetente (ID_REMETENTE, CNPJ_CNPF, RAZAO_SOCIAL, NOME) VALUES (:id, :cnpj, :razaoSocial, :nome)", nativeQuery = true)
	public void salvarRemetente(@Param("id") Long id, @Param("cnpj") String cnpj, @Param("razaoSocial") String razaoSocial, @Param("nome") String nome);

}
