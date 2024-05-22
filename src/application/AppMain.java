package application;

import entities.Banco;
import entities.Cliente;
import entities.contas.Conta;
import entities.contas.ContaCorrente;
import entities.contas.Poupanca;


public class AppMain {

	public static void main(String[] args) {
		
		Banco bancoTeste = new Banco("Banco Teste");
		
		Cliente c1 = new Cliente("Alex", 887458569);
		
		Conta poupanca = new Poupanca(c1);
		
		Conta cCorrente = new ContaCorrente(c1);
		
		
		bancoTeste.addContas(cCorrente);
		bancoTeste.addContas(poupanca);
		
		cCorrente.depositar(1500);
		
		cCorrente.transferir(500, poupanca);
		
		cCorrente.sacar(700);
		
		
		System.out.println(cCorrente.imprimirExtrato());
		System.out.println(poupanca.imprimirExtrato());

	}

}
