package javaapplication2;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CadastroAluno extends JFrame {

    private final ArrayList<Aluno> alunos = new ArrayList<>();

    private JTextField txtNome;
    private JTextField txtDataNascimento;
    private JComboBox<String> cmbSexo;
    private JTextField txtMatricula;
    private JTextField txtCurso;
    private JTextField txtCpf;
    private JTextField txtRua;
    private JTextField txtNumero;
    private JTextField txtBairro;
    private JTextField txtCidade;
    private JTextField txtCep;
    private JComboBox<String> cmbEstado;
    private JTextField txtTelefone;
    private JTextArea txaAlunos;
    private JButton btnCadastrar;
    private JButton btnLimpar;

    public CadastroAluno() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel painelFormulario = new JPanel(new GridBagLayout());
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Aluno"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        txtNome = new JTextField(28);
        txtDataNascimento = new JTextField(12);
        cmbSexo = new JComboBox<>(new String[]{"Selecione", "Masculino", "Feminino", "Outro"});
        txtMatricula = new JTextField(12);
        txtCurso = new JTextField(25);
        txtCpf = new JTextField(14);
        txtRua = new JTextField(25);
        txtNumero = new JTextField(8);
        txtBairro = new JTextField(18);
        txtCidade = new JTextField(18);
        txtCep = new JTextField(10);
        cmbEstado = new JComboBox<>(new String[]{
            "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
            "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO",
            "RR", "SC", "SP", "SE", "TO"
        });
        txtTelefone = new JTextField(16);

        int linha = 0;
        adicionarCampo(painelFormulario, gbc, linha++, "Nome completo:", txtNome);
        adicionarCampo(painelFormulario, gbc, linha++, "Data de nascimento (DD/MM/AAAA):", txtDataNascimento);
        adicionarCampo(painelFormulario, gbc, linha++, "Sexo:", cmbSexo);
        adicionarCampo(painelFormulario, gbc, linha++, "Matrícula:", txtMatricula);
        adicionarCampo(painelFormulario, gbc, linha++, "Curso:", txtCurso);
        adicionarCampo(painelFormulario, gbc, linha++, "CPF:", txtCpf);
        adicionarCampo(painelFormulario, gbc, linha++, "Rua:", txtRua);
        adicionarCampo(painelFormulario, gbc, linha++, "Número:", txtNumero);
        adicionarCampo(painelFormulario, gbc, linha++, "Bairro:", txtBairro);
        adicionarCampo(painelFormulario, gbc, linha++, "Cidade:", txtCidade);
        adicionarCampo(painelFormulario, gbc, linha++, "CEP:", txtCep);
        adicionarCampo(painelFormulario, gbc, linha++, "Estado:", cmbEstado);
        adicionarCampo(painelFormulario, gbc, linha++, "Telefone:", txtTelefone);

        JPanel painelBotoes = new JPanel();
        btnCadastrar = new JButton("Cadastrar Aluno");
        btnLimpar = new JButton("Limpar Campos");
        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnLimpar);

        txaAlunos = new JTextArea(9, 75);
        txaAlunos.setEditable(false);
        txaAlunos.setLineWrap(false);
        JScrollPane scroll = new JScrollPane(txaAlunos);
        scroll.setBorder(BorderFactory.createTitledBorder("Alunos cadastrados - atributos separados por ;"));

        btnCadastrar.addActionListener(evt -> cadastrarAluno());
        btnLimpar.addActionListener(evt -> limparCampos());

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(painelFormulario, BorderLayout.CENTER);
        topo.add(painelBotoes, BorderLayout.SOUTH);

        setLayout(new BorderLayout(10, 10));
        add(topo, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void adicionarCampo(JPanel painel, GridBagConstraints gbc, int linha, String texto, java.awt.Component campo) {
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.weightx = 0;
        painel.add(new JLabel(texto), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        painel.add(campo, gbc);
    }

    private void cadastrarAluno() {
        if (temCampoVazio()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (cmbSexo.getSelectedIndex() == 0 || cmbEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione o sexo e o estado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!dataValida(txtDataNascimento.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato DD/MM/AAAA.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int matricula;
        try {
            matricula = Integer.parseInt(txtMatricula.getText().trim());
            if (matricula <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "A matrícula deve ser um número inteiro positivo.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (matriculaJaExiste(matricula)) {
            JOptionPane.showMessageDialog(this, "Já existe um aluno com essa matrícula.", "Matrícula duplicada", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Aluno aluno = new Aluno(
            txtNome.getText().trim(),
            txtDataNascimento.getText().trim(),
            cmbSexo.getSelectedItem().toString(),
            matricula,
            txtCurso.getText().trim(),
            txtCpf.getText().trim(),
            txtRua.getText().trim(),
            txtNumero.getText().trim(),
            txtBairro.getText().trim(),
            txtCidade.getText().trim(),
            txtCep.getText().trim(),
            cmbEstado.getSelectedItem().toString(),
            txtTelefone.getText().trim()
        );

        alunos.add(aluno);
        txaAlunos.append(aluno.toString() + System.lineSeparator());
        limparCampos();
        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
    }

    private boolean matriculaJaExiste(int matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }

    private boolean dataValida(String data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate.parse(data, formato);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean temCampoVazio() {
        return txtNome.getText().trim().isEmpty()
                || txtDataNascimento.getText().trim().isEmpty()
                || txtMatricula.getText().trim().isEmpty()
                || txtCurso.getText().trim().isEmpty()
                || txtCpf.getText().trim().isEmpty()
                || txtRua.getText().trim().isEmpty()
                || txtNumero.getText().trim().isEmpty()
                || txtBairro.getText().trim().isEmpty()
                || txtCidade.getText().trim().isEmpty()
                || txtCep.getText().trim().isEmpty()
                || txtTelefone.getText().trim().isEmpty();
    }

    private void limparCampos() {
        txtNome.setText("");
        txtDataNascimento.setText("");
        cmbSexo.setSelectedIndex(0);
        txtMatricula.setText("");
        txtCurso.setText("");
        txtCpf.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtCep.setText("");
        cmbEstado.setSelectedIndex(0);
        txtTelefone.setText("");
        txtNome.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroAluno().setVisible(true));
    }
}
