# Sistema Escola

Projeto Java (Swing + JDBC + MySQL) com cadastro de **Alunos** e **Professores**, usando o banco `escola`.

## Estrutura

```
src/
├── beans/     Aluno, Professor
├── conexao/   Conexao (JDBC)
├── dao/       AlunoDAO, ProfessorDAO
└── view/      FormPrincipal, FormAluno, FormProfessor (.java + .form)
sql/
└── script_escola.sql
```

## Como executar

1. Rode `sql/script_escola.sql` no MySQL (ajuste conforme suas tabelas).
2. No NetBeans, crie um projeto *Java with Ant* e copie a pasta `src/` para dentro dele.
3. Adicione o **MySQL Connector/J 8.1.0** em *Libraries*.
4. Ajuste usuário e senha em `src/conexao/Conexao.java`.
5. Execute `view/FormPrincipal.java`.

## Tecnologias

Java, Swing (NetBeans GUI Builder), JDBC, MySQL Connector/J 8.1.0.
