package CRUDjdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ContatoCrudJDBC {
	public void salvar(Contato contato) {
		Connection conexao = this.geraConexao();
		String sql = "insert into contato(nome,telefone,email,dt_cad,obs) values(?,?,?,?,?)";
		java.sql.PreparedStatement statement= null;
		try {
			statement = conexao.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getNome());
			statement.setString(3, contato.getNome());
			statement.setDate(4, contato.getDatacadastro());
			statement.setString(5, contato.getNome());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir contato. Mensagem:" + e.getMessage());
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
System.out.println("Erro ao fechar operações de inserção. Mensagem:"+ e.getMessage());
			}
		}
	}

	public void atualizar(Contato contato) {

	}

	public void excluir(Contato contato) {

	}

	public List<Contato> listar() {
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
