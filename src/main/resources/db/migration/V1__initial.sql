-- src/main/resources/db/migration/V1__initial.sql

-- Criação da tabela Curso
CREATE TABLE Curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

-- Criação da tabela Perfil
CREATE TABLE Perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Criação da tabela Usuario
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfis INT,
    FOREIGN KEY (perfis) REFERENCES Perfil(id)
);

CREATE TABLE Topico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    dataCriacao DATETIME NOT NULL,
    status VARCHAR(255) NOT NULL,
    autor INT,
    curso INT,
    FOREIGN KEY (autor) REFERENCES Usuario(id),
    FOREIGN KEY (curso) REFERENCES Curso(id)
);

CREATE TABLE Resposta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    topico INT,
    dataCriacao DATETIME NOT NULL,
    autor INT,
    solucao BOOLEAN,
    FOREIGN KEY (topico) REFERENCES Topico(id),
    FOREIGN KEY (autor) REFERENCES Usuario(id)
);


-- Inserção de dados iniciais
INSERT INTO Curso (nome, categoria) VALUES ('Curso de Python', 'Programação');
INSERT INTO Curso (nome, categoria) VALUES ('Curso de MySQL', 'Banco de Dados');

INSERT INTO Perfil (nome) VALUES ('Administrador');
INSERT INTO Perfil (nome) VALUES ('Usuário');

INSERT INTO Usuario (nome, email, senha, perfis) VALUES ('João Silva', 'joao@example.com', 'senha123', 1);
INSERT INTO Usuario (nome, email, senha, perfis) VALUES ('Maria Oliveira', 'maria@example.com', 'senha456', 2);

INSERT INTO Topico (titulo, mensagem, dataCriacao, status, autor, curso) VALUES ('Como usar MySQL?', 'Estou com dúvida em como usar MySQL...', NOW(), 'aberto', 1, 2);

INSERT INTO Resposta (mensagem, topico, dataCriacao, autor, solucao) VALUES ('Você pode começar instalando o MySQL no seu computador.', 1, NOW(), 2, FALSE);
