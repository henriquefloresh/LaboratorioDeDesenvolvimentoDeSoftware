package cadastroalunosnetbeans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TelaCadastroAluno extends javax.swing.JFrame {

    private final ArrayList<Aluno> alunos = new ArrayList<>();

    public TelaCadastroAluno() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNascimento = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        lblMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblRua = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblCep = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        lblResultado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaAlunos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Alunos");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setText("Cadastro de Alunos");

        lblNome.setText("Nome completo:");
        lblNascimento.setText("Data de nascimento:");
        lblSexo.setText("Sexo:");
        lblMatricula.setText("Matrícula:");
        lblCurso.setText("Curso:");
        lblCpf.setText("CPF:");
        lblRua.setText("Rua:");
        lblNumero.setText("Número:");
        lblBairro.setText("Bairro:");
        lblCidade.setText("Cidade:");
        lblCep.setText("CEP:");
        lblEstado.setText("Estado:");
        lblTelefone.setText("Telefone:");
        lblResultado.setText("Alunos cadastrados:");

        txtNascimento.setToolTipText("DD/MM/AAAA");

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Masculino", "Feminino", "Outro", "Prefiro não informar"
        }));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT",
            "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO",
            "RR", "SC", "SP", "SE", "TO"
        }));

        btnCadastrar.setText("Cadastrar Aluno");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar Campos");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtAreaAlunos.setColumns(20);
        txtAreaAlunos.setRows(5);
        txtAreaAlunos.setEditable(false);
        txtAreaAlunos.setLineWrap(true);
        txtAreaAlunos.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAreaAlunos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(lblResultado)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblNascimento)
                            .addComponent(lblSexo)
                            .addComponent(lblMatricula)
                            .addComponent(lblCurso)
                            .addComponent(lblCpf)
                            .addComponent(lblRua))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtNascimento)
                            .addComponent(cmbSexo, 0, 220, Short.MAX_VALUE)
                            .addComponent(txtMatricula)
                            .addComponent(txtCurso)
                            .addComponent(txtCpf)
                            .addComponent(txtRua))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumero)
                            .addComponent(lblBairro)
                            .addComponent(lblCidade)
                            .addComponent(lblCep)
                            .addComponent(lblEstado)
                            .addComponent(lblTelefone))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumero)
                            .addComponent(txtBairro)
                            .addComponent(txtCidade)
                            .addComponent(txtCep)
                            .addComponent(cmbEstado, 0, 200, Short.MAX_VALUE)
                            .addComponent(txtTelefone)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNascimento)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatricula)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCep)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRua)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar))
                .addGap(20, 20, 20)
                .addComponent(lblResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }
    // </editor-fold>

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (temCampoVazio()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }

        try {
            DateTimeFormatter formato = DateTimeFormatter
                    .ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(txtNascimento.getText().trim(), formato);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use DD/MM/AAAA.");
            txtNascimento.requestFocus();
            return;
        }

        long matricula;
        try {
            matricula = Long.parseLong(txtMatricula.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "A matrícula deve conter somente números.");
            txtMatricula.requestFocus();
            return;
        }

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                JOptionPane.showMessageDialog(this, "Essa matrícula já está cadastrada.");
                txtMatricula.requestFocus();
                return;
            }
        }

        Aluno aluno = new Aluno(
                txtNome.getText().trim(),
                txtNascimento.getText().trim(),
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
        txtAreaAlunos.append(aluno.toString() + System.lineSeparator());

        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
        limparCampos();
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
    }

    private boolean temCampoVazio() {
        return txtNome.getText().trim().isEmpty()
                || txtNascimento.getText().trim().isEmpty()
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
        txtNascimento.setText("");
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

    // Variables declaration - do not modify
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtAreaAlunos;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration
}
