package cadastroalunosnetbeans;

public class Aluno {
    private String nomeCompleto, dataNascimento, sexo, curso, cpf;
    private String rua, numero, bairro, cidade, cep, estado, telefone;
    private long matricula;

    public Aluno(String nomeCompleto, String dataNascimento, String sexo, long matricula,
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

    public long getMatricula() { return matricula; }

    @Override
    public String toString() {
        return nomeCompleto + ";" + dataNascimento + ";" + sexo + ";" + matricula + ";"
                + curso + ";" + cpf + ";" + rua + ", " + numero + ", " + bairro + ", "
                + cidade + ", " + cep + ";" + estado + ";" + telefone;
    }
}
