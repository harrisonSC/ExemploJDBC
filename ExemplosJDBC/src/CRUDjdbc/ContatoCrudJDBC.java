package CRUDjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
			inserir.setString(2, contato.getTelefone());
			inserir.setString(3, contato.getEmail());
			inserir.setDate(4, contato.getDatacadastro());
			inserir.setString(5, contato.getObservacao());
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

	public List<Contato> listar() {
		Connection conexao = this.geraConexao();
		List<Contato> contatos = new ArrayList<Contato>();
		Statement consulta = null;
		ResultSet resultado = null;
		Contato contato = null;
		String sql = "select * from contato";
		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				contato = new Contato();
				contato.setCodigo(new Integer(resultado.getInt("codigo")));
				contato.setNome(resultado.getString("nome"));
				contato.setTelefone(resultado.getString("telefone"));
				contato.setEmail(resultado.getString("email"));
				contato.setDatacadastro(resultado.getDate("dt_cad"));
				contato.setObservacao(new String(resultado.getString("obs")));
				contatos.add(contato);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao buscar código do contato. Mensagem:" + e.getMessage());
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar operações de consulta. Mensagem:" + e.getMessage());
			}
		}
		return contatos;
	}

	public Contato buscaContato(int valor) {
		return null;
	}
	public void atualizar(Contato contato) {
		
	}
	
	public void excluir(Contato contato) {
		
	}

	@SuppressWarnings("null")
	public Connection geraConexao() {
		java.sql.Connection con = null;
		String url = "jdbc:mysql://localhost:3306/agenda";
		String usuario = "root";
		String senha = "root";
		try {
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou essa Porra!!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro de SQL:" + e.getMessage());
			
			}
	
		return con;
	}

	public static void main(String[] args) {
		ContatoCrudJDBC contatoCrud = new ContatoCrudJDBC();
		Contato contato1 = new Contato();
		contato1.setNome("Maria");
		contato1.setTelefone("(11)5555-4237");
		contato1.setEmail("cvb@gmail.com");
		contato1.setDatacadastro(new Date(System.currentTimeMillis()));
		contato1.setObservacao("Novo tsbsfdsa");
		contatoCrud.salvar(contato1);

		Contato contato2 = new Contato();
		contato2.setNome("Paulo");
		contato2.setTelefone("(11)5445-4237");
		contato2.setEmail("paulo@gmail.com");
		contato2.setDatacadastro(new Date(System.currentTimeMillis()));
		contato2.setObservacao("Novo possivel cliente");
		contatoCrud.salvar(contato2);	
		
		System.out.println("Contatos cadastrados:"+ contatoCrud.listar().size());
		
	}
}
