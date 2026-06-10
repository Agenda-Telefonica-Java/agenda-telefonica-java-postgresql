package alunos.puc;

import java.sql.Connection;

import alunos.puc.database.Conexao;

public class App {
    public static void main(String[] args) {
        try {
            Connection con = Conexao.getInstance().conectar();
            
            if (con != null) {
                AgendaUI.main(args);
            } else {
                System.err.println("> Conexão nula!");
            }
        } catch (Exception ex) {
            System.err.println("> Erro capturado:" + ex.getMessage());
        }
        
        System.out.println("Aplicação encerrada.");
    }
}
