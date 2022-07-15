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
	@Query(value = "UPDATE destinatario SET CNPJ_CNPF= :cnpj, RAZAO_SOCIAL= :razaoSocial, NOME=:nome, ENDERECO= :endereco WHERE ID_DESTINATARIO= :id", nativeQuery = true)
	public void alterar(@Param("id") Long id, @Param("cnpj") String cnpj, @Param("razaoSocial") String razaoSocial, @Param("nome") String nome, @Param("endereco") String endereco);
	
	// -----------------------------------------------------------------------------------------------
	
	@Query(value = "SELECT * FROM destinatario where CNPJ_CNPF=:cnpj", nativeQuery = true)
	public Destinatario validarCnpjRepetido(@Param("cnpj") String cnpj);
	
	@Query(value = "SELECT MAX(ID_DESTINATARIO) FROM destinatario", nativeQuery = true)
	public Integer obterId(); 

	@Query(value = "SELECT * FROM destinatario WHERE ID_DESTINATARIO= :id", nativeQuery = true)
	public Destinatario getByIdQN(@Param("id") Long id);
	
}
