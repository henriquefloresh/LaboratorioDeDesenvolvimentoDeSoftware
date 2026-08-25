package cadastroalunosnetbeans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import javax.swing.*;

public class TelaCadastroAluno extends JFrame {
    private final ArrayList<Aluno> alunos = new ArrayList<>();

    private JTextField nome = new JTextField(), nascimento = new JTextField(), matricula = new JTextField();
    private JTextField curso = new JTextField(), cpf = new JTextField(), rua = new JTextField();
    private JTextField numero = new JTextField(), bairro = new JTextField(), cidade = new JTextField();
    private JTextField cep = new JTextField(), telefone = new JTextField();
    private JComboBox<String> sexo = new JComboBox<>(new String[]{"Masculino","Feminino","Outro","Prefiro não informar"});
    private JComboBox<String> estado = new JComboBox<>(new String[]{"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"});
    private JTextArea area = new JTextArea(9, 65);

    public TelaCadastroAluno() {
        setTitle("Cadastro de Alunos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel campos = new JPanel(new java.awt.GridLayout(13, 2, 6, 6));
        campos.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        adicionar(campos, "Nome completo:", nome);
        adicionar(campos, "Data de nascimento (DD/MM/AAAA):", nascimento);
        adicionar(campos, "Sexo:", sexo);
        adicionar(campos, "Matrícula:", matricula);
        adicionar(campos, "Curso:", curso);
        adicionar(campos, "CPF:", cpf);
        adicionar(campos, "Rua:", rua);
        adicionar(campos, "Número:", numero);
        adicionar(campos, "Bairro:", bairro);
        adicionar(campos, "Cidade:", cidade);
        adicionar(campos, "CEP:", cep);
        adicionar(campos, "Estado:", estado);
        adicionar(campos, "Telefone:", telefone);

        JButton cadastrar = new JButton("Cadastrar Aluno");
        JButton limpar = new JButton("Limpar Campos");
        cadastrar.addActionListener(e -> cadastrar());
        limpar.addActionListener(e -> limpar());

        JPanel botoes = new JPanel();
        botoes.add(cadastrar);
        botoes.add(limpar);

        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        JLabel titulo = new JLabel("CADASTRO DE ALUNOS", SwingConstants.CENTER);
        titulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 22));

        JPanel centro = new JPanel(new java.awt.BorderLayout());
        centro.add(campos, java.awt.BorderLayout.NORTH);
        centro.add(botoes, java.awt.BorderLayout.CENTER);
        centro.add(new JScrollPane(area), java.awt.BorderLayout.SOUTH);

        add(titulo, java.awt.BorderLayout.NORTH);
        add(centro, java.awt.BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void adicionar(JPanel p, String rotulo, JComponent campo) {
        p.add(new JLabel(rotulo));
        p.add(campo);
    }

    private void cadastrar() {
        if (vazio()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }
        try {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(nascimento.getText().trim(), f);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use DD/MM/AAAA.");
            return;
        }

        long mat;
        try { mat = Long.parseLong(matricula.getText().trim()); }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Matrícula deve conter apenas números.");
            return;
        }

        for (Aluno a : alunos) {
            if (a.getMatricula() == mat) {
                JOptionPane.showMessageDialog(this, "Matrícula já cadastrada.");
                return;
            }
        }

        Aluno a = new Aluno(nome.getText().trim(), nascimento.getText().trim(),
            sexo.getSelectedItem().toString(), mat, curso.getText().trim(), cpf.getText().trim(),
            rua.getText().trim(), numero.getText().trim(), bairro.getText().trim(),
            cidade.getText().trim(), cep.getText().trim(), estado.getSelectedItem().toString(),
            telefone.getText().trim());

        alunos.add(a);
        area.append(a + System.lineSeparator());
        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
        limpar();
    }

    private boolean vazio() {
        JTextField[] c = {nome,nascimento,matricula,curso,cpf,rua,numero,bairro,cidade,cep,telefone};
        for (JTextField x : c) if (x.getText().trim().isEmpty()) return true;
        return false;
    }

    private void limpar() {
        JTextField[] c = {nome,nascimento,matricula,curso,cpf,rua,numero,bairro,cidade,cep,telefone};
        for (JTextField x : c) x.setText("");
        sexo.setSelectedIndex(0);
        estado.setSelectedIndex(0);
        nome.requestFocus();
    }
}
