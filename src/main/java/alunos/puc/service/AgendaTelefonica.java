package alunos.puc.service;

import alunos.puc.model.Contato;
import alunos.puc.repository.ContatoDAO;

import java.util.List;

public class AgendaTelefonica {
    private final ContatoDAO contatoDAO;

    public AgendaTelefonica() {
        this.contatoDAO = new ContatoDAO();
    }

    public boolean adicionarContato(Contato contato) {
        if (contatoInvalido(contato)) {
            return false;
        }

        return contatoDAO.adicionarContato(contato);
    }

    public Contato buscarContatoPorNome(String nome) {
        if (textoVazio(nome)) {
            return null;
        }

        return contatoDAO.buscarContatoPorNome(nome);
    }

    public Contato buscarContato(String nome) {
        return buscarContatoPorNome(nome);
    }

    public List<Contato> listarContatos() {
        return contatoDAO.listarContatos();
    }

    public boolean atualizarContato(Contato contato) {
        if (contato == null || contato.getId() <= 0 || contatoInvalido(contato)) {
            return false;
        }

        return contatoDAO.atualizarContato(contato);
    }

    public boolean atualizarContato(String nome, Contato contatoAtualizado) {
        Contato contatoExistente = buscarContatoPorNome(nome);

        if (contatoExistente == null || contatoInvalido(contatoAtualizado)) {
            return false;
        }

        contatoAtualizado.setId(contatoExistente.getId());
        return atualizarContato(contatoAtualizado);
    }

    public boolean removerContato(String nome) {
        if (textoVazio(nome)) {
            return false;
        }

        return contatoDAO.removerContato(nome);
    }

    private boolean contatoInvalido(Contato contato) {
        return contato == null
                || textoVazio(contato.getNome())
                || textoVazio(contato.getTelefone())
                || textoVazio(contato.getEmail());
    }

    private boolean textoVazio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
