DROP TABLE IF EXISTS contatos;

CREATE TABLE contatos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    CONSTRAINT contatos_nome_unique UNIQUE (nome)
);

INSERT INTO contatos (nome, telefone, email) VALUES
('Ana Souza', '(62) 99999-1111', 'ana@email.com'),
('Carlos Lima', '(62) 98888-2222', 'carlos@email.com'),
('Mariana Alves', '(62) 97777-3333', 'mariana@email.com');