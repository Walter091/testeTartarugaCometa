package com.example.tartarugaCometaGw.nucleo;


public enum StatusLancamentoEnum implements ItfcEnumBase{
		
	RECEBIDO("RECEBIDO", "IN", 0),
	PENDENTE("PENDENTE", "AL", 1);

	private String descricao;
	private String sigla;
	private int id;
	
	private StatusLancamentoEnum(String descricao, String sigla, int id) {
		this.descricao = descricao;
		this.sigla = sigla;
		this.id = id;
	}
	
	// -------------------------------------------------------------------------------------

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String getSigla() {
		return sigla;
	}

	@Override
	public int getId() {
		return id;
	}
	
}
