package entities.contas;

public interface IConta {
	
		void sacar(double valor);

	    void depositar(double valor);

	    void transferir(double valor, Conta contaDestino);

	    String imprimirExtrato();
	    
	    public void addTransacao(Transacao transacao);
}
