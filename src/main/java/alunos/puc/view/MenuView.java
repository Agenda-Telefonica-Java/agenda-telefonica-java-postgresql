package alunos.puc.view;

import alunos.puc.model.Contato;

import java.util.List;
import java.util.Scanner;

public class MenuView {
    private final Scanner scanner;

    public MenuView() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println();
        System.out.println("========== AGENDA TELEFONICA ==========");
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Buscar contato");
        System.out.println("3 - Listar contatos");
        System.out.println("4 - Atualizar contato");
        System.out.println("5 - Remover contato");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opcao: ");

        String entrada = scanner.nextLine();

        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void exibir(String mensagem) {
        System.out.println(mensagem);
    }

    public Contato lerContato() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine().trim();

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        return new Contato(nome, telefone, email);
    }

    public String lerNome() {
        System.out.print("Nome do contato: ");
        return scanner.nextLine().trim();
    }

    public void exibirContato(Contato contato) {
        System.out.println("ID: " + contato.getId());
        System.out.println("Nome: " + contato.getNome());
        System.out.println("Telefone: " + contato.getTelefone());
        System.out.println("Email: " + contato.getEmail());
        System.out.println("------------------------------");
    }

    public void exibirContatos(List<Contato> contatos) {
        if (contatos.isEmpty()) {
            exibir("Nenhum contato cadastrado.");
            return;
        }

        for (Contato contato : contatos) {
            exibirContato(contato);
        }
    }

}
