package com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario.Destinatario;

@Repository
public interface RepositorioRemetente extends CrudRepository<Remetente, Long>{
		
	@Query(value = "SELECT * FROM remetente where CNPJ=:cnpj", nativeQuery = true)
	public Remetente validarCnpjRepetido(@Param("cnpj") String cnpj);

	@Query(value = "SELECT * FROM remetente where CPF=:cpf", nativeQuery = true)
	public Destinatario validarCpfRepetido(@Param("cpf") String cpf);

	@Query(value = "SELECT id_remetente FROM remetente "
			+ "where CNPJ=:cnpj or CPF=:cpf", nativeQuery = true)
	public Long obterPelosCampos(@Param("cnpj") String cnpj, @Param("cpf") String cpf);
		
}
