package br.com.sigo.rest;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.sigo.dao.LinhaBuscaDAO;
import br.com.sigo.entidade.Linha;
import br.com.sigo.entidade.LinhaBusca;



/**
 * 
 * Essa classe cont�m as implementa��es para retornar os objetos JSON para o cliente
 * 
 * @author Denis Viana
 *
 */


/** 
 * Anota��o "patch" recebe uma string como par�mentro e indica qual � o caminho da URL.
 * */
@Path("/linhas")
public class LinhasBuscaService {

	private LinhaBuscaDAO linhaBuscaDAO;
	
	@PostConstruct
	private void init(){
		linhaBuscaDAO = new LinhaBuscaDAO();
	}
	
	
	/**
	 * A anota��o "@GET" lista os recursos. Ela � respons�vel por retornar os objetos para o cliente.
	 * A anota��o "@Produces" indica qual o mime-type do conte�do da resposta que ser� enviada para o cliente.
	 * No exemplo acbaixo ser� retornado um JSON 
	 *  */
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LinhaBusca> listarLinhas(){
		List<LinhaBusca> lista = null;
				
		try{
			lista = linhaBuscaDAO.listarLinhas();
		} catch (Exception e){
			e.printStackTrace();
		}
				
	return lista;	
	}
	
	/** 
	 * A anota��o "@Consumes" indica qual o mime-type do conte�do da requisi��o. Em geral � utilizado principalmente em 
	 * requisi��es do tipo POST ou PUT, em que o cliente precisa enviar a informa��o do que ele deseja adicionar/alterar.
	 * 
	 * Nesse caso, o webservice recebe um ID, passado atrav�s do "Path". Esse ID � o respons�vel por localizar uma linha de �nibus
	 * espec�fica no Banco de Dados e retornar seu objeto.
	 * */
	@GET
	@Path("/get/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Linha buscarLinhaPorID(@PathParam("id") int idLinha){
		Linha linha = null;
		
		try{
			linha = linhaBuscaDAO.buscarLinha(idLinha);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return linha;
		
	}
	
	
}
