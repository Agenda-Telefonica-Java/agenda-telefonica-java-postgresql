package alunos.puc.repository;

import alunos.puc.database.Conexao;
import alunos.puc.model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    public boolean adicionarContato(Contato contato) {
        String sql = "INSERT INTO contatos (nome, telefone, email) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conectar().prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar contato: " + e.getMessage());
            return false;
        }
    }

    public Contato buscarContatoPorNome(String nome) {
        String sql = "SELECT id, nome, telefone, email FROM contatos WHERE nome ILIKE ? ORDER BY nome LIMIT 1";

        try (PreparedStatement stmt = conectar().prepareStatement(sql)) {
            stmt.setString(1, nome);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return criarContato(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar contato: " + e.getMessage());
        }

        return null;
    }

    public List<Contato> listarContatos() {
        String sql = "SELECT id, nome, telefone, email FROM contatos ORDER BY nome";
        List<Contato> contatos = new ArrayList<>();

        try (PreparedStatement stmt = conectar().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                contatos.add(criarContato(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar contatos: " + e.getMessage());
        }

        return contatos;
    }

    public boolean atualizarContato(Contato contato) {
        String sql = "UPDATE contatos SET nome = ?, telefone = ?, email = ? WHERE id = ?";

        try (PreparedStatement stmt = conectar().prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            stmt.setInt(4, contato.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar contato: " + e.getMessage());
            return false;
        }
    }

    public boolean removerContato(String nome) {
        String sql = "DELETE FROM contatos WHERE nome ILIKE ?";

        try (PreparedStatement stmt = conectar().prepareStatement(sql)) {
            stmt.setString(1, nome);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao remover contato: " + e.getMessage());
            return false;
        }
    }

    private Connection conectar() throws SQLException {
        return Conexao.getInstance().conectar();
    }

    private Contato criarContato(ResultSet rs) throws SQLException {
        return new Contato(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("telefone"),
                rs.getString("email")
        );
    }
}
