-- Ajuste conforme as tabelas que você criou em aula
CREATE DATABASE IF NOT EXISTS escola;
USE escola;

CREATE TABLE IF NOT EXISTS aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    curso VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS professor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    departamento VARCHAR(100),
    titulacao VARCHAR(50)
);
