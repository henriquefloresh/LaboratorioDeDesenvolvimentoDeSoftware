package javaapplication2;

public class Aluno {
    private String nomeCompleto;
    private String dataNascimento;
    private String sexo;
    private int matricula;
    private String curso;
    private String cpf;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;
    private String telefone;

    public Aluno(String nomeCompleto, String dataNascimento, String sexo, int matricula,
                 String curso, String cpf, String rua, String numero, String bairro,
                 String cidade, String cep, String estado, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.telefone = telefone;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        String enderecoCompleto = rua + ", " + numero + ", " + bairro + ", " + cidade + ", " + cep;
        return nomeCompleto + ";" +
               dataNascimento + ";" +
               sexo + ";" +
               matricula + ";" +
               curso + ";" +
               cpf + ";" +
               enderecoCompleto + ";" +
               estado + ";" +
               telefone;
    }
}
