create database BDAula01;

show databases;

use BDAula01;

CREATE TABLE pessoa(
		id int auto_increment PRIMARY KEY,
        nome VARCHAR(50) NOT NULL,
        sexo VARCHAR(1) NOT NULL,
        idioma VARCHAR(10) NOT NULL
);

show tables;
desc pessoa;

INSERT INTO pessoa(nome, sexo, idioma)
VALUES
("Ricardo", "M", "Português"),
("Rafael", "M", "Português"),
("Antony", "M", "Francês"),
("Joe", "M", "Espanhol"),
("Mary", "F", "Inglês");

select * from pessoa;

CREATE TABLE alunos(
		id int auto_increment PRIMARY KEY,
        nome VARCHAR(50) NOT NULL,
        idade INT,
        curso VARCHAR(50) NOT NULL
);

desc alunos;
INSERT INTO alunos(nome, idade, curso)
VALUES
("João", 20 ,"Matemática"),
("Maria", 22 ,"História"),
("Pedro", 21 ,"Ciência da Computação"),
("Ana", 19 ,"Biologia"),
("Carlos", 23 ,"Economia");

select * from alunos;

CREATE TABLE professores(
		id int auto_increment PRIMARY KEY,
        nome VARCHAR(50) NOT NULL,
        idade INT,
        disciplina VARCHAR(50) NOT NULL
);

desc professores;
INSERT INTO professores(nome, idade, disciplina)
VALUES
("Ricardo", 41 , "Laboratório de Desenvolvimento de Software"),
("Alexandre", 51 , "Pesquisa e Ordenação"),
("Ana", 55 , "Algoritmos e Programação B"),
("Leticia" , 42 , "Calculo 1"),
("Leandro", 48 , "Lógica Computacional");

select * from professores;

CREATE TABLE matriculas(
		id int auto_increment PRIMARY KEY,
        id_alunos INT,
        id_professores INT,
        data_matricula DATE,
        
		foreign key (id_alunos) references alunos(id),
        foreign key (id_professores) references professores(id)
);
desc matriculas;

INSERT INTO matriculas(id_aluno, id_professores, data_matricula)
VALUES
		(1,1,"2023-01-15"),
        (2,2,"2023-02-20"),
        (3,3,"2023-03-10"),
        (4,1,"2023-04-05"),
        (5,2,"2023-05-12");
select * from matriculas;
select nome, curso from alunos;
select nome, disciplina from professores;

select * from pessoa;
