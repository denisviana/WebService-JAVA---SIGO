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
 * Essa classe contém as implementações para retornar os objetos JSON para o cliente
 * 
 * @author Denis Viana
 *
 */


/** 
 * Anotação "patch" recebe uma string como parâmentro e indica qual é o caminho da URL.
 * */
@Path("/linhas")
public class LinhasBuscaService {

	private LinhaBuscaDAO linhaBuscaDAO;
	
	@PostConstruct
	private void init(){
		linhaBuscaDAO = new LinhaBuscaDAO();
	}
	
	
	/**
	 * A anotação "@GET" lista os recursos. Ela é responsável por retornar os objetos para o cliente.
	 * A anotação "@Produces" indica qual o mime-type do conteúdo da resposta que será enviada para o cliente.
	 * No exemplo acbaixo será retornado um JSON 
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
	 * A anotação "@Consumes" indica qual o mime-type do conteúdo da requisição. Em geral é utilizado principalmente em 
	 * requisições do tipo POST ou PUT, em que o cliente precisa enviar a informação do que ele deseja adicionar/alterar.
	 * 
	 * Nesse caso, o webservice recebe um ID, passado através do "Path". Esse ID é o responsável por localizar uma linha de ônibus
	 * específica no Banco de Dados e retornar seu objeto.
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
