package br.com.sigo.entidade;

/**
 * 
 * Classe simples com os atributos de uma linha de ônibus e seus Getters e Setters
 * 
 * @author Denis Viana
 *
 */
public class Linha {
	
	
	
	private int id_linha;
	private int id_itinerario;
	private String nome_linha;
	private String cod_linha;
	private String nome_empresa;
	private String origem;
	private String destino;
	private float tarifa;
	private boolean linha_integrada;
	
	public int getId_linha() {
		return id_linha;
	}
	public void setId_linha(int id_linha) {
		this.id_linha = id_linha;
	}
	public int getId_itinerario() {
		return id_itinerario;
	}
	public void setId_itinerario(int id_itinerario) {
		this.id_itinerario = id_itinerario;
	}

	public String getNome_empresa() {
		return nome_empresa;
	}
	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}
	public float getTarifa() {
		return tarifa;
	}
	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	public String getNome_linha() {
		return nome_linha;
	}
	public void setNome_linha(String nome_linha) {
		this.nome_linha = nome_linha;
	}
	public String getCod_linha() {
		return cod_linha;
	}
	public void setCod_linha(String cod_linha) {
		this.cod_linha = cod_linha;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public boolean isLinha_integrada() {
		return linha_integrada;
	}
	public void setLinha_integrada(boolean linha_integrada) {
		this.linha_integrada = linha_integrada;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cod_linha+" - "+nome_linha;
	}
	
}
