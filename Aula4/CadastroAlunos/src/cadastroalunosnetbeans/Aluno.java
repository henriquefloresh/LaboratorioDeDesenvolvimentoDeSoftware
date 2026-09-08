package cadastroalunosnetbeans;

/**
 * Classe modelo/entidade que representa um Aluno cadastrado,
 * agrupando dados pessoais, acadêmicos e de endereço.
 */
public class Aluno {
    private String nomeCompleto, dataNascimento, sexo, curso, cpf;
    private String rua, numero, bairro, cidade, cep, estado, telefone;
    private long matricula; // identificador numérico do aluno

    // Construtor completo: recebe todos os dados de uma vez para montar o objeto
    // (usado tanto ao cadastrar um aluno novo quanto ao reconstruir a partir do arquivo)
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

    // Único getter da classe - usado, por exemplo, para localizar/comparar um aluno pela matrícula
    public long getMatricula() { return matricula; }

    // Serializa o aluno em uma única linha de texto separada por ";",
    // no formato usado para gravar/ler em um arquivo (semelhante ao padrão de Pessoa/Arquivo).
    // Observação: o endereço (rua, número, bairro, cidade, cep) fica agrupado
    // com vírgulas dentro de um único campo, entre dois ";".
    @Override
    public String toString() {
        return nomeCompleto + ";" + dataNascimento + ";" + sexo + ";" + matricula + ";"
                + curso + ";" + cpf + ";" + rua + ", " + numero + ", " + bairro + ", "
                + cidade + ", " + cep + ";" + estado + ";" + telefone;
    }
}
