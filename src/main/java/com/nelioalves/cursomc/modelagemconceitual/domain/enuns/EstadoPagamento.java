package com.nelioalves.cursomc.modelagemconceitual.domain.enuns;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public enum EstadoPagamento {
	
	
	PENDENTE(0,"Pagamento Pendente"),
	QUITADO(1, "Pagamento Realizado"),
	CANCELADO(2, "Pagamento Cancelado");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod;
	
	private String nome;
	
	private EstadoPagamento() {
		
	}
	
	private EstadoPagamento(int cod, String nome) {
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
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
			
			throw new IllegalArgumentException("Id Inválido:" + cod);
		
		}
		return null;
	}

}
