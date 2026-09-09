/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastrolivros;

/**
 *
 * @author laboratorio
 */
public class CadastroLivros {
    public String titulo, autor, categorias, anoPublicacao;
    char tipo, situacaoLeitura;

    public CadastroLivros(String titulo, String autor, String categorias, String anoPublicacao, char tipo, char situacaoLeitura) {
        this.titulo = titulo;
        this.autor = autor;
        this.categorias = categorias;
        this.anoPublicacao = anoPublicacao;
        this.tipo = tipo;
        this.situacaoLeitura = situacaoLeitura;
    }

    @Override
    public String toString() {
        return "CadastroLivros{" + "titulo=" + titulo + ", autor=" + autor + ", categorias=" + categorias + ", anoPublicacao=" + anoPublicacao + ", tipo=" + tipo + ", situacaoLeitura=" + situacaoLeitura + '}';
    }

    
    
    public Object[] obterDados(){
        return new Object[] {titulo, autor, tipo, categorias, situacaoLeitura, anoPublicacao };
    }
    
}
