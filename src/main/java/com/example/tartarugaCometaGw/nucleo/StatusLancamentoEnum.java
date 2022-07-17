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
	
	public static String obterPorID(Integer id) {
		String result = null;
		if (id == 0) {
			result = StatusLancamentoEnum.RECEBIDO.descricao; 
		}
		if (id == 1) {
			result = StatusLancamentoEnum.PENDENTE.descricao; 
		}
		return result;
	}
	
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
