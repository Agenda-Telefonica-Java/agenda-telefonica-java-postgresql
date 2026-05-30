package alunos.puc.controller;

import alunos.puc.model.Contato;
import alunos.puc.service.ContatoService;
import alunos.puc.view.MenuView;

import java.util.List;

public class ContatoController {
    private final ContatoService service;
    private final MenuView view;
    
    public ContatoController() {
        this.service = new ContatoService();
        this.view = new MenuView();
    }
    
    public void iniciar() {
        while (true) {
            int opcao = view.mostrarMenu();
            
            switch(opcao) {
                case 1:
                    cadastrarContato();
                    break;
                case 2:
                    buscarContato();
                    break;
                case 3:
                    listarContatos();
                    break;
                case 4:
                    atualizarContato();
                    break;
                case 5:
                    deletarContato();
                    break;
                case 6:
                    view.exibir("Encerrando...");
                    return;
                default:
                    view.exibir("Opcao invalida!");
                    break;
            }
        }
    }

    private void buscarContato() {
        String nome = view.lerNome();

        if (textoVazio(nome)) {
            view.exibir("Nome obrigatorio.");
            return;
        }

        Contato contato = service.buscarPorNome(nome);

        if (contato == null) {
            view.exibir("Contato nao encontrado.");
            return;
        }

        view.exibirContato(contato);
    }
    
    private void deletarContato() {
        String nome = view.lerNome();

        if (textoVazio(nome)) {
            view.exibir("Nome obrigatorio.");
            return;
        }

        boolean sucesso = service.remover(nome);
        if (sucesso) {
            view.exibir("Contato removido com sucesso!");
        } else {
            view.exibir("Contato nao encontrado.");
        }
    }

    private void atualizarContato() {
        String nome = view.lerNome();

        if (textoVazio(nome)) {
            view.exibir("Nome obrigatorio.");
            return;
        }

        Contato contatoExistente = service.buscarPorNome(nome);

        if (contatoExistente == null) {
            view.exibir("Contato nao encontrado.");
            return;
        }

        Contato contatoAtualizado = view.lerContato();
        if (contatoInvalido(contatoAtualizado)) {
            view.exibir("Todos os campos sao obrigatorios.");
            return;
        }

        contatoAtualizado.setId(contatoExistente.getId());

        boolean sucesso = service.atualizar(contatoAtualizado);
        if (sucesso) {
            view.exibir("Contato atualizado com sucesso!");
        } else {
            view.exibir("Erro ao atualizar contato!");
        }
    }

    private void listarContatos() {
        List<Contato> contatos = service.listar();
        view.exibirContatos(contatos);
    }

    private void cadastrarContato() {
        Contato contato = view.lerContato();
        if (contatoInvalido(contato)) {
            view.exibir("Todos os campos sao obrigatorios.");
            return;
        }

        boolean sucesso = service.salvar(contato);
        if (sucesso) {
            view.exibir("Contato salvo com sucesso!");
        } else {
            view.exibir("Erro ao salvar contato!");
        }
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
