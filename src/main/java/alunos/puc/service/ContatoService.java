package alunos.puc.service;

import alunos.puc.model.Contato;

import java.util.List;

public class ContatoService {
    private final AgendaTelefonica agendaTelefonica;

    public ContatoService() {
        this.agendaTelefonica = new AgendaTelefonica();
    }

    public boolean salvar(Contato contato) {
        return agendaTelefonica.adicionarContato(contato);
    }

    public Contato buscarPorNome(String nome) {
        return agendaTelefonica.buscarContatoPorNome(nome);
    }

    public List<Contato> listar() {
        return agendaTelefonica.listarContatos();
    }

    public boolean atualizar(Contato contato) {
        return agendaTelefonica.atualizarContato(contato);
    }

    public boolean remover(String nome) {
        return agendaTelefonica.removerContato(nome);
    }
}
