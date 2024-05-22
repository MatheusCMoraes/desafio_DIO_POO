package entities.contas;


import entities.Cliente;

public class Poupanca extends Conta{
	    
	
	public Poupanca(Cliente cliente) {
		super(cliente);
	}
	

	@Override
	public String imprimirExtrato() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("*** EXTRATO CONTA POUPANÇA ***" + "\n");
		sb.append("AGÊNCIA: " + this.getAgencia() + "\n");
		sb.append("CONTA: " + this.getNumero() + "\n");
		sb.append(" ---- TRANSAÇÕES ----" + "\n");
		for(Transacao transacao: this.transacaoConta) {
			sb.append(transacao.toString());
		}
		sb.append("------------------------" + "\n");
		
		return sb.toString();
	}
}
