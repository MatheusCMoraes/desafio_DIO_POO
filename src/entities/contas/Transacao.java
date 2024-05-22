package entities.contas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {

	private String dataOperacao;
	private static SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private TipoTransacao tipo;
	private double valorOperacao;
	private Conta contaDestino;
	private Conta contaOrigem;
	
	

	public Transacao(TipoTransacao tipo, double valorOperacao, Conta contaDestino,Conta contaOrigem) {

		this.dataOperacao = spf.format(new Date(System.currentTimeMillis()));
		this.tipo = tipo;
		this.valorOperacao = valorOperacao;
		this.contaDestino = contaDestino;
		this.contaOrigem = contaOrigem;
	}
	
	public Transacao(TipoTransacao tipo, double valorOperacao,Conta contaOrigem) {

		this.dataOperacao = spf.format(new Date(System.currentTimeMillis()));
		this.tipo = tipo;
		this.valorOperacao = valorOperacao;
		this.contaDestino = null;
		this.contaOrigem = contaOrigem;
	}

	public String getDataOperacao() {
		return dataOperacao;
	}

	public double getValorOperacao() {
		return valorOperacao;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}
	
	public String getTipo() {
		return this.tipo.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		sb.append("Data - " + this.getDataOperacao());
		sb.append(" -- " + "Operação: " + this.getTipo() + " -- ");
		sb.append("Valor: $" + String.format("%.2f", this.getValorOperacao()) + "\n");
		return  sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
