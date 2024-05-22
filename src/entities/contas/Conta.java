package entities.contas;

import java.util.ArrayList;
import java.util.List;

import entities.Cliente;

public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected double chequeEspecial = 1000;
    
    protected List<Transacao> transacaoConta =  new ArrayList<Transacao>();
    
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor, boolean isTransferencia) {
    	if(saldo < valor) {
    		if(chequeEspecial < valor) {
    			System.out.println("**** SALDO INSUFICIENTE, OPERAÇÃO CANCELADA! ****" + "\n");
    		} else {
    			saldo -= valor;
    			chequeEspecial += saldo;
    			if(!isTransferencia) {
	    			Transacao operacao = new Transacao(TipoTransacao.valueOf("SAQUE"), valor, this);
	            	transacaoConta.add(operacao);
    			}
    		}    		
    	}else {
    		saldo -= valor;
    		if(!isTransferencia) {
	    		Transacao operacao = new Transacao(TipoTransacao.valueOf("SAQUE"), valor, this);
	        	transacaoConta.add(operacao);
    		}
    	}    	
        
    }
    
    @Override
    public void sacar(double valor) {
    	sacar(valor, false);
    }

    @Override
    public void depositar(double valor) {
    	Transacao operacao = new Transacao(TipoTransacao.valueOf("DEPOSITO"), valor, this);
    	transacaoConta.add(operacao);
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
    	Transacao operacao = new Transacao(TipoTransacao.valueOf("TRANSFERENCIA"), valor, contaDestino, this);
    	transacaoConta.add(operacao);
        this.sacar(valor, true);
        contaDestino.depositar(valor);
    }
    
    public void addTransacao(Transacao transacao){
		transacaoConta.add(transacao);
	}

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public double getChequeEspecial() {
    	return this.chequeEspecial;
    }

    protected String imprimirInfosComuns() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("\n");
    	sb.append(String.format("Titular: %s",this.cliente.getNomeCliente()) +"\n");
    	sb.append(String.format("Agencia: %d",this.agencia) + "\n");
    	sb.append(String.format("Conta: %d",this.numeroConta) + "\n");
    	
      return sb.toString();
        
    }

	@Override
	public String toString() {
		return imprimirInfosComuns();
	}
    
    
}

