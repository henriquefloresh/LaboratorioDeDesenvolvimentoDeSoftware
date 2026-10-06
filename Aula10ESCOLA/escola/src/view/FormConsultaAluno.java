package view;

import beans.Aluno;
import dao.AlunoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormConsultaAluno extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormConsultaAluno.class.getName());

    public FormConsultaAluno() {
        initComponents();
        setLocationRelativeTo(null);
        consultarAlunos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Alunos");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nome", "Matrícula", "E-mail", "Curso"}
        ) {
            Class[] types = new Class [] {
                Integer.class, String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean [] {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConsultar)
                        .addGap(10, 10, 10)
                        .addComponent(btnEditar)
                        .addGap(10, 10, 10)
                        .addComponent(btnFechar)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnEditar)
                    .addComponent(btnFechar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        consultarAlunos();
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (Integer) tabela.getValueAt(linha, 0);
        Aluno alunoSelecionado = null;
        for (Aluno aluno : new AlunoDAO().consultar()) {
            if (aluno.getId() == id) {
                alunoSelecionado = aluno;
                break;
            }
        }

        if (alunoSelecionado != null) {
            new FormAluno(alunoSelecionado).setVisible(true);
        }
    }

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void consultarAlunos() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        List<Aluno> alunos = new AlunoDAO().consultar();
        for (Aluno aluno : alunos) {
            modelo.addRow(new Object[]{
                aluno.getId(), aluno.getNome(), aluno.getMatricula(),
                aluno.getEmail(), aluno.getCurso()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
