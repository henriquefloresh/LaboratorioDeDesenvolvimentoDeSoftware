package view;

import beans.Professor;
import dao.ProfessorDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormConsultaProfessor extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormConsultaProfessor.class.getName());

    public FormConsultaProfessor() {
        initComponents();
        setLocationRelativeTo(null);
        consultarProfessores();
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
        setTitle("Consultar Professores");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nome", "E-mail", "Departamento", "Titulação"}
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
        consultarProfessores();
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um professor para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (Integer) tabela.getValueAt(linha, 0);
        Professor professorSelecionado = null;
        for (Professor professor : new ProfessorDAO().consultar()) {
            if (professor.getId() == id) {
                professorSelecionado = professor;
                break;
            }
        }

        if (professorSelecionado != null) {
            new FormProfessor(professorSelecionado).setVisible(true);
        }
    }

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void consultarProfessores() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        List<Professor> professores = new ProfessorDAO().consultar();
        for (Professor professor : professores) {
            modelo.addRow(new Object[]{
                professor.getId(), professor.getNome(), professor.getEmail(),
                professor.getDepartamento(), professor.getTitulacao()
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
