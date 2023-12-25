package com.nelioalves.cursomc.modelagemconceitual.domain.enuns;

public enum TipoCliente {
	
	PESSOAFISICA(1,"Pesso Jurídica"),
	PESSOAJURIDICA(2, "Pessoa Fíica");
	
	private int cod;
	private String nome;
	
	private TipoCliente(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
			
			throw new IllegalArgumentException("Id Inválido:" + cod);
		
		}
		return null;
	}

}
