package ConectaMySQL;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySQL {
	public static void main(String[] args) {
		java.sql.Connection con = null;
		String url = "jdbc:mysql://localhost:3306/agenda";
		String usuario = "root";
		String senha = "root";
		try {
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou essa Porra!!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro de SQL:" + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexão!");
			}
		}
	}

}
