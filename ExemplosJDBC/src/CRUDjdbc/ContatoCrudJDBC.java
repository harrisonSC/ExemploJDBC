package CRUDjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoCrudJDBC {
	public void salvar(Contato contato) {
		Connection conexao = this.geraConexao();
		String sql = "insert into contato(nome,telefone,email,dt_cad,obs) values(?,?,?,?,?)";
		java.sql.PreparedStatement inserir = null;
		try {
			inserir = conexao.prepareStatement(sql);
			inserir.setString(1, contato.getNome());
			inserir.setString(2, contato.getNome());
			inserir.setString(3, contato.getNome());
			inserir.setDate(4, contato.getDatacadastro());
			inserir.setString(5, contato.getNome());
			inserir.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir contato. Mensagem:" + e.getMessage());
		} finally {
			try {
				inserir.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar operações de inserção. Mensagem:" + e.getMessage());
			}
		}
	}

	public void atualizar(Contato contato) {

	}

	public void excluir(Contato contato) {

	}

	public List<Contato> listar() {

		Connection conexao = this.geraConexao();
		List<Contato> contatos = new ArrayList<Contato>();
		Statement consulta = null;
		ResultSet resultado = null;
		String sql = "select * from contato";
		
		try {
			consulta = conexao.createStatement();
			// to do 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}

		return null;

	}

	public Contato buscaContato(int valor) {
		return null;

	}

	public Connection geraConexao() {
		return null;

	}

	public static void main(String[] args) {

	}
}
