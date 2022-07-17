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
	@Query(value = "UPDATE destinatario SET CNPJ= :cnpj, CPF= :cpf, RAZAO_SOCIAL= :razaoSocial, NOME=:nome, ENDERECO= :endereco WHERE ID_DESTINATARIO= :id", nativeQuery = true)
	public void alterar(@Param("id") Long id, @Param("cnpj") String cnpj, @Param("cpf") String cpf, @Param("razaoSocial") String razaoSocial, @Param("nome") String nome, @Param("endereco") String endereco);
	
	// -----------------------------------------------------------------------------------------------
	
	@Query(value = "SELECT * FROM destinatario where CNPJ=:cnpj", nativeQuery = true)
	public Destinatario validarCnpjRepetido(@Param("cnpj") String cnpj);

	@Query(value = "SELECT * FROM destinatario where CPF=:cpf", nativeQuery = true)
	public Destinatario validarCpfRepetido(@Param("cpf") String cpf);
		
}
