package entities.contas;


import entities.Cliente;

public class ContaCorrente extends Conta{
	 

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	

	@Override
	public String imprimirExtrato() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("*** EXTRATO CONTA CORRENTE ***" + "\n");
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
