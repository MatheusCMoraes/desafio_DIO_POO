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
		sb.append("SALDO: " + this.getSaldo() + "\n");
		if(this.getSaldo() < 0) {
			sb.append("CHEQUE ESPECIAL UTILIZADO, VALOR DISPONÍVEL: " + String.format("%.2f", this.getChequeEspecial()) + "\n");
		}
		sb.append(" ---- TRANSAÇÕES ----" + "\n");
		for(Transacao transacao: this.transacaoConta) {
			sb.append(transacao.toString());
		}
		sb.append("------------------------" + "\n");
		
		
		return sb.toString();
		
	}
	
	
}
