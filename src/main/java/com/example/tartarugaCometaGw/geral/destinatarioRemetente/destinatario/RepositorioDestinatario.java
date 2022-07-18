package com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDestinatario extends CrudRepository<Destinatario, Long>{
		
	@Query(value = "SELECT * FROM destinatario where CNPJ=:cnpj", nativeQuery = true)
	public Destinatario validarCnpjRepetido(@Param("cnpj") String cnpj);

	@Query(value = "SELECT * FROM destinatario where CPF=:cpf", nativeQuery = true)
	public Destinatario validarCpfRepetido(@Param("cpf") String cpf);

	@Query(value = "SELECT id_destinatario FROM destinatario "
			+ "where CNPJ=:cnpj or CPF=:cpf", nativeQuery = true)
	public Long obterPelosCampos(@Param("cnpj") String cnpj, @Param("cpf") String cpf);

}
