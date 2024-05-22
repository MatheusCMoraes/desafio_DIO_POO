package entities;

import java.util.ArrayList;
import java.util.List;

import entities.contas.Conta;

public class Cliente {
	
	private String nomeCliente;
	private int CPF;
	private String email;
	
	private List<Conta> contas = new ArrayList<Conta>();
	
	public Cliente() {}
	
	public Cliente(String nome, int cpf) {
		this.nomeCliente = nome;
		this.CPF = cpf;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void addContas(Conta conta) {
        contas.add(conta);
    }
    
    public void removeContas(Conta conta) {
    	contas.remove(conta);
    }
	
	

}
