package br.com.sigo.entidade;



/**
 * 
 * Classe simples com 3 atributos da Linha de ônibus. Essa classe tem poucos atributos
 * porque seus objetos são utilizados apenas para as buscas de linhas de ônibus no Endpoint.
 * 
 * o atributo ID_LINHA é utilizado para retornar os detalhes de uma linha específica de ônibus
 * 
 * @author Denis Viana
 *
 */
public class LinhaBusca {
	
	private int id_linha;
	private String cod_linha;
	private String nome_linha;
	
	
	public String getCod_linha() {
		return cod_linha;
	}
	public void setCod_linha(String cod_linha) {
		this.cod_linha = cod_linha;
	}
	public int getId_linha() {
		return id_linha;
	}
	public void setId_linha(int id_linnha) {
		this.id_linha = id_linnha;
	}
	public String getNome_linha() {
		return nome_linha;
	}
	public void setNome_linha(String nome_linha) {
		this.nome_linha = nome_linha;
	}
	
	

}
