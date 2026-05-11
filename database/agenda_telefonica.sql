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