# Sistema Escola

Projeto Java Swing + JDBC + MySQL, preparado para abrir no **NetBeans como Java Application**.

## Funcionalidades

- Cadastro de Alunos.
- Cadastro de Professores.
- Consulta de Alunos em tabela.
- Consulta de Professores em tabela.
- Seleção de registro e **Editar**.
- Atualização do registro existente no MySQL.
- Telas com arquivos `.java` + `.form`, compatíveis com o **NetBeans GUI Builder / Design**.

## Como abrir no NetBeans

1. Extraia o ZIP.
2. No NetBeans, use **File > Open Project** e selecione a pasta `escola`.
3. Adicione o **MySQL Connector/J** às Libraries do projeto.
4. Rode `sql/script_escola.sql` no MySQL.
5. Confira usuário e senha em `src/conexao/Conexao.java`.
6. Execute `view.FormPrincipal`.

Para editar visualmente uma tela, abra o arquivo `.java` correspondente e selecione a aba **Design**.

## Como funciona o editar

Na tela principal:
- **Cadastro de Alunos** e **Cadastro de Professores** continuam sendo usados para novos registros.
- **Consultar / Editar Alunos** e **Consultar / Editar Professores** exibem os registros do banco.
- Selecione uma linha e clique em **Editar**.
- A tela de cadastro será aberta preenchida com os dados.
- O botão **Salvar** passa a ser **Atualizar**.
- Ao atualizar, o registro é alterado pelo `id` no banco.
