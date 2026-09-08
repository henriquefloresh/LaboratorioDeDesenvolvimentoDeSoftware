package cadastroalunosnetbeans;

// Classe de entrada do programa (é ela quem está configurada como
// "main.class" no project.properties do NetBeans - por isso é preciso
// usar "Run Project" para executar, e não "Run File" na TelaCadastroAluno).
public class CadastroAlunosNetBeans {
    public static void main(String[] args) {
        // invokeLater garante que a interface gráfica seja criada e exibida
        // na Event Dispatch Thread (EDT), como recomendado pelo Swing
        java.awt.EventQueue.invokeLater(() -> new TelaCadastroAluno().setVisible(true));
    }
}
