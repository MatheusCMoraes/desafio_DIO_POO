package entities;

import java.util.ArrayList;
import java.util.List;

import entities.contas.Conta;

public class Banco {
	
	private String nomeBanco;
    private List<Conta> contasClientes =  new ArrayList<Conta>();
    
    public Banco(String nome) {
    	this.nomeBanco = nome;
    }

    public String getNome() {
        return nomeBanco;
    }


    public void addContas(Conta conta) {
        contasClientes.add(conta);
    }
    
    public void removeContas(Conta conta) {
    	contasClientes.remove(conta);
    }

	@Override
	public String toString() {
		return nomeBanco + "\n" + contasClientes.toString();
	}
    
    
}
