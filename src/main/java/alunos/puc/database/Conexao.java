package alunos.puc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Padrão singleton
*/
public class Conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/agenda_telefonica";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres123";
    private static final String DRIVER = "org.postgresql.Driver";
    
    private static Conexao instancia;
    private Connection conexao;
    
    private Conexao() {
        // vazio
    }
    
    public static synchronized Conexao getInstance() {
        if (instancia == null) {
            instancia = new Conexao();
        }
        return instancia;
    }
    
    public Connection conectar() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                Class.forName(DRIVER);
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.out.println("Conectado ao banco de dados com sucesso!");
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC não encontrado: " + e.getMessage());
                throw new SQLException("Erro ao carregar driver JDBC", e);
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
                throw e;
            }
        }
        return conexao;
    }
    
    public Connection getConexao() {
        return conexao;
    }
    
    public void desconectar() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Desconectado do banco de dados.");
            } catch (SQLException e) {
                System.err.println("Erro ao desconectar: " + e.getMessage());
            }
        }
    }
}
