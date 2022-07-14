package com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDestinatario extends CrudRepository<Destinatario, Long>{
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO destinatario (ID_DESTINATARIO, CNPJ_CNPF, RAZAO_SOCIAL, NOME, ID_ENDERECO) VALUES (:id, :cnpj, :razaoSocial, :nome, :endereco)", nativeQuery = true)
	public void salvarDestinatario(@Param("id") Long id, @Param("cnpj") String cnpj, @Param("razaoSocial") String razaoSocial, @Param("nome") String nome, @Param("endereco") Long endereco);

}
