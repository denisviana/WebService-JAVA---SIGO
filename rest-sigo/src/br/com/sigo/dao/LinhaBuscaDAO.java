package br.com.sigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sigo.config.BDConfig;
import br.com.sigo.entidade.Linha;
import br.com.sigo.entidade.LinhaBusca;

public class LinhaBuscaDAO {
	
	/**
	 * Este método consulta todas as linhas de onibus gravadas na tabela "Linha" do Banco de Dados
	 * Mas lê apenas 3 atributos que são o ID, Código da Linha e o Nome da Linha. No final retorna 
	 * um List com todos os resultados.
	 * */
	public List<LinhaBusca> listarLinhas() throws ClassNotFoundException, SQLException{
		List<LinhaBusca> lista = new ArrayList();
		
		Connection conexao = BDConfig.getConnection();
		
		String sql = "SELECT id_linha,nome_linha,cod_linha FROM \"Linha\"";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()){ //*Enquanto houver um próximo registro...
			LinhaBusca linhaBusca = new LinhaBusca();
			linhaBusca.setId_linha(resultSet.getInt("id_linha"));
			linhaBusca.setCod_linha(resultSet.getString("cod_linha"));
			linhaBusca.setNome_linha(resultSet.getString("nome_linha"));
			
			lista.add(linhaBusca);
		}
		
		return lista;
	}
	
	
	/** 
	 * Este método consulta apenas uma linha específica através do ID passado como parâmetro,
	 * trazendo todos os detalhes da linha de ônibus retornando um objeto do tipo Linha
	 * */
	
	public Linha buscarLinha(int idLinha) throws ClassNotFoundException, SQLException{
		Linha linha = null;
		
		Connection conexao = BDConfig.getConnection();
		
		String sql = "SELECT * FROM \"view_linhas_busca\" WHERE id_linha = ?";
		
		PreparedStatement statement= conexao.prepareStatement(sql);
		statement.setInt(1, idLinha);
		ResultSet result = statement.executeQuery();
		
		if(result.next()){ //Se houver algum registro
			linha = new Linha();
			linha.setId_linha(result.getInt("id_linha"));
			linha.setCod_linha(result.getString("cod_linha"));
			linha.setNome_linha(result.getString("nome_linha"));
			linha.setNome_empresa(result.getString("nome_empresa"));
			linha.setId_itinerario(result.getInt("itinerario_id_itinerario"));
			linha.setTarifa(result.getFloat("preco"));
			linha.setOrigem(result.getString("origem"));
			linha.setDestino(result.getString("destino"));
			linha.setLinha_integrada(result.getBoolean("linha_integrada"));
		}
		
		return linha;
		
	}

	
	
	
}
