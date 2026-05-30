# Agenda Telefonica em Java com PostgreSQL

Projeto academico desenvolvido para o **Projeto Integrador II-A**, com o objetivo de criar uma aplicacao em Java para armazenar e gerenciar contatos telefonicos utilizando operacoes CRUD e persistencia em banco de dados PostgreSQL.

A aplicacao e executada via terminal, com um menu simples para interacao do usuario, permitindo cadastrar, consultar, atualizar, listar e excluir contatos.

## 1. Objetivo do Projeto

Desenvolver uma aplicacao de Agenda Telefonica em Java capaz de armazenar e gerenciar contatos telefonicos com os seguintes dados:

- Nome;
- Telefone;
- E-mail.

A aplicacao implementa as operacoes basicas de CRUD:

- **Create**: criar/adicionar contatos;
- **Read**: consultar/listar contatos;
- **Update**: atualizar dados de contatos;
- **Delete**: excluir contatos.

Os dados sao persistidos em um banco de dados relacional PostgreSQL.

## 2. Tecnologias Utilizadas

- Java;
- JDK 17 ou superior;
- PostgreSQL;
- JDBC;
- Maven;
- Git;
- GitHub;
- IDE de desenvolvimento compativel com Java.

## 3. Escopo do Projeto

O sistema e uma aplicacao Java com execucao no terminal. O projeto contem:

- Classe `Contato`;
- Classe `AgendaTelefonica`;
- Classe principal `AgendaTeste`;
- Conexao com banco de dados PostgreSQL;
- Operacoes CRUD completas;
- Tratamento de excecoes;
- Interface simples via menu no console;
- Dump `.sql` do banco de dados populado;
- Video explicativo demonstrando o funcionamento da aplicacao.

## 4. Funcionalidades do Sistema

1. Adicionar um novo contato;
2. Buscar um contato pelo nome;
3. Listar todos os contatos cadastrados;
4. Atualizar dados de um contato;
5. Remover um contato existente;
6. Sair do programa.

## 5. Estrutura do Projeto

```text
agenda-telefonica-java/
|-- src/
|   |-- main/java/alunos/puc/
|   |   |-- AgendaTeste.java
|   |   |-- App.java
|   |   |-- controller/
|   |   |   `-- ContatoController.java
|   |   |-- database/
|   |   |   `-- Conexao.java
|   |   |-- model/
|   |   |   `-- Contato.java
|   |   |-- repository/
|   |   |   |-- ConexaoRepository.java
|   |   |   |-- ContatoDAO.java
|   |   |   `-- IConexaoRepository.java
|   |   |-- service/
|   |   |   |-- AgendaTelefonica.java
|   |   |   `-- ContatoService.java
|   |   `-- view/
|   |       `-- MenuView.java
|   `-- test/java/alunos/puc/
|       `-- AppTest.java
|-- database/
|   `-- agenda_telefonica.sql
|-- entregas/
|   `-- bruna/explicacao_funcionamento_aplicacao.pdf
|-- pom.xml
|-- README.md
`-- .gitignore
```

## 6. Organizacao das Classes

### Contato.java

Classe responsavel por representar o contato telefonico.

- Armazena os dados de um contato;
- Possui construtores;
- Possui metodos getters e setters;
- Representa o objeto principal do sistema.

### Conexao.java

Classe responsavel por realizar a conexao com o banco de dados PostgreSQL.

- Define URL de conexao;
- Define usuario e senha do banco;
- Cria o metodo de conexao via JDBC;
- Trata possiveis erros de conexao.

### ContatoDAO.java

Classe responsavel pela comunicacao direta com o banco de dados.

- Insere contatos no banco;
- Busca contato pelo nome;
- Lista todos os contatos;
- Atualiza dados de um contato;
- Remove contato;
- Executa comandos SQL;
- Utiliza `PreparedStatement` para melhorar a seguranca da aplicacao.

### AgendaTelefonica.java

Classe responsavel pela regra de negocio da agenda.

- Gerencia as operacoes da agenda;
- Chama os metodos da classe `ContatoDAO`;
- Valida informacoes antes de enviar ao banco;
- Organiza os metodos principais solicitados na proposta.

Metodos principais:

```java
adicionarContato(Contato contato)
removerContato(String nome)
buscarContato(String nome)
buscarContatoPorNome(String nome)
listarContatos()
atualizarContato(Contato contato)
atualizarContato(String nome, Contato contatoAtualizado)
```

### AgendaTeste.java

Classe principal do projeto.

- Contem o metodo `main`;
- Inicia o fluxo da aplicacao;
- Chama o controller responsavel pelo menu;
- Permite que o usuario continue usando o sistema ate escolher sair.

## 7. Banco de Dados

O banco escolhido para o projeto e o PostgreSQL.

```sql
CREATE DATABASE agenda_telefonica;

CREATE TABLE IF NOT EXISTS contatos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO contatos (nome, telefone, email) VALUES
('Ana Souza', '(62) 99999-1111', 'ana@email.com'),
('Carlos Lima', '(62) 98888-2222', 'carlos@email.com'),
('Mariana Alves', '(62) 97777-3333', 'mariana@email.com');
```

O arquivo final do banco esta em `database/agenda_telefonica.sql`.

## 8. Menu da Aplicacao

```text
========== AGENDA TELEFONICA ==========
1 - Adicionar contato
2 - Buscar contato
3 - Listar contatos
4 - Atualizar contato
5 - Remover contato
6 - Sair
Escolha uma opcao:
```

## 9. Regras de Funcionamento

- O usuario escolhe uma opcao no menu;
- O sistema solicita os dados necessarios conforme a operacao escolhida;
- O sistema salva, consulta, atualiza ou exclui os dados no PostgreSQL;
- O sistema exibe mensagens claras de sucesso ou erro;
- O sistema impede operacoes invalidas;
- O sistema trata contato nao encontrado, campos vazios, erro de conexao, opcao invalida e falha ao executar SQL.

## 10. Tratamento de Excecoes

O projeto trata:

- Erro ao conectar no banco de dados;
- Erro ao inserir contato;
- Erro ao buscar contato inexistente;
- Erro ao remover contato inexistente;
- Erro ao atualizar contato inexistente;
- Entrada invalida no menu;
- Campos obrigatorios nao preenchidos.

## 11. Divisao de Tarefas

### Pessoa 1 - Filipe

Responsavel por: estrutura inicial do projeto e modelagem principal.

Atividades:

- Criar a estrutura inicial do projeto Java;
- Criar o repositorio no GitHub;
- Organizar as pastas do projeto;
- Criar a classe `Contato.java`;
- Definir os atributos nome, telefone e email;
- Criar construtores, getters e setters;
- Criar a primeira versao da classe principal;
- Garantir que o projeto compile corretamente.

### Pessoa 2 - Phil

Responsavel por: banco de dados e conexao com PostgreSQL.

Atividades:

- Criar o banco de dados `agenda_telefonica`;
- Criar a tabela `contatos`;
- Popular o banco com dados de exemplo;
- Criar o arquivo `agenda_telefonica.sql`;
- Criar a classe `Conexao.java`;
- Configurar a conexao JDBC com PostgreSQL;
- Testar a conexao entre Java e banco de dados;
- Garantir que o dump `.sql` esteja correto para entrega.

### Pessoa 3 - Bruna

Responsavel por: implementacao do CRUD e regras de negocio.

Atividades:

- Criar a classe `ContatoDAO.java`;
- Implementar o metodo de adicionar contato;
- Implementar o metodo de buscar contato pelo nome;
- Implementar o metodo de listar contatos;
- Implementar o metodo de atualizar contato;
- Implementar o metodo de remover contato;
- Criar ou ajustar a classe `AgendaTelefonica.java`;
- Garantir que os metodos exigidos estejam implementados.

Entregas esperadas:

- CRUD completo funcionando;
- Metodos da agenda implementados;
- Integracao entre Java e PostgreSQL validada;
- Regras de negocio organizadas.

### Pessoa 4 - Marcos Paulo

Responsavel por: menu, validacoes, testes finais, documentacao e video.

Atividades:

- Finalizar a classe `AgendaTeste.java`;
- Criar o menu interativo no terminal;
- Implementar leitura de dados com `Scanner`;
- Validar opcoes invalidas;
- Validar campos vazios;
- Testar todas as funcionalidades do CRUD;
- Revisar o codigo final;
- Criar ou atualizar o `README.md`;
- Preparar o roteiro do video explicativo;
- Gravar ou organizar a demonstracao da aplicacao;
- Conferir se todos os arquivos exigidos estao prontos para entrega.

## 12. Status das Funcionalidades

| Funcionalidade | Responsavel | Status |
| --- | --- | --- |
| Estrutura inicial do projeto | Filipe | Concluido |
| Classe Contato | Filipe | Concluido |
| Banco PostgreSQL | Phil | Concluido |
| Dump .sql populado | Phil | Concluido |
| Conexao JDBC | Phil | Concluido |
| Classe ContatoDAO | Bruna | Concluido |
| CRUD completo | Bruna | Concluido |
| Classe AgendaTelefonica | Bruna | Concluido |
| Menu no terminal | Marcos Paulo | Concluido |
| Validacoes | Marcos Paulo | Concluido |
| Testes finais | Marcos Paulo | Concluido |
| README | Marcos Paulo | Concluido |
| Video explicativo | Marcos Paulo | A preparar |

## 13. Entregaveis do Projeto

- Projeto Java exportado;
- Codigo-fonte completo;
- Arquivo `.sql` do banco de dados PostgreSQL;
- Banco de dados populado;
- README com explicacao do projeto;
- Video com audio e imagem demonstrando o CRUD completo.

## 14. Roteiro Sugerido para o Video

1. Apresentar o objetivo do projeto;
2. Mostrar a estrutura de pastas;
3. Explicar a classe `Contato`;
4. Explicar a conexao com PostgreSQL;
5. Explicar a tabela `contatos`;
6. Demonstrar o menu da aplicacao;
7. Adicionar um novo contato;
8. Buscar um contato pelo nome;
9. Listar todos os contatos;
10. Atualizar um contato;
11. Remover um contato;
12. Mostrar o banco de dados com os dados alterados;
13. Explicar o arquivo `.sql`;
14. Finalizar mostrando que o CRUD completo esta funcionando.

## 15. Como Executar o Projeto

1. Clonar o repositorio:

```bash
git clone URL_DO_REPOSITORIO
```

2. Acessar a pasta do projeto:

```bash
cd agenda-telefonica-java
```

3. Criar o banco de dados no PostgreSQL:

```sql
CREATE DATABASE agenda_telefonica;
```

4. Criar a tabela e popular os dados usando o arquivo:

```bash
database/agenda_telefonica.sql
```

5. Configurar a conexao no arquivo `Conexao.java`, se necessario:

```java
private static final String URL = "jdbc:postgresql://localhost:5433/agenda_telefonica";
private static final String USUARIO = "postgres";
private static final String SENHA = "postgres123";
```

6. Compilar e testar o projeto:

```bash
mvn test
```

7. Executar a aplicacao:

```bash
mvn compile exec:java
```

## 16. Requisitos de Qualidade

- Codigo organizado;
- Separacao correta de responsabilidades;
- Aplicacao dos conceitos de orientacao a objetos;
- Persistencia dos dados em PostgreSQL;
- CRUD completo funcionando;
- Tratamento de excecoes;
- Interface simples e compreensivel via terminal;
- Banco de dados exportado em `.sql`;
- Video explicativo claro;
- README atualizado.

## 17. Integrantes

| Nome | Pessoa | Responsabilidade Principal |
| --- | --- | --- |
| Filipe | Pessoa 1 | Estrutura inicial e classe Contato |
| Phil | Pessoa 2 | Banco PostgreSQL e conexao JDBC |
| Bruna | Pessoa 3 | CRUD e regras de negocio |
| Marcos Paulo | Pessoa 4 | Menu, testes, documentacao e video |

## 18. Observacao Importante

Embora o desenvolvimento esteja organizado entre os integrantes, a atividade possui orientacao de entrega individual. Portanto, todos os participantes devem ter acesso ao projeto completo, compreender seu funcionamento e realizar a submissao conforme as regras definidas pela disciplina.

## 19. Status do Projeto

Em fase final de entrega academica, com CRUD funcional, persistencia em PostgreSQL, README atualizado e testes executados.
