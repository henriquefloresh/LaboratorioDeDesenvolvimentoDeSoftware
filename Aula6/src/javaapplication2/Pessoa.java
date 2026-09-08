/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 * Classe simples (modelo/entidade) que representa uma pessoa cadastrada,
 * usada tanto pela tela RadioButton quanto pela classe Arquivo.
 *
 * @author laboratorio
 */
public class Pessoa {
    public String nome;
    public char sexo;    // 'M' ou 'F'
    public String idioma;

    // Construtor usado tanto para criar uma pessoa nova quanto para
    // reconstruir uma pessoa a partir dos dados lidos do arquivo
    public Pessoa(String nome, char sexo, String idioma) {
        this.nome = nome;
        this.sexo = sexo;
        this.idioma = idioma;
    }

    // Usado no System.out.println(pessoa) do RadioButton, para debug no console
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sexo=" + sexo + ", idioma=" + idioma + '}';
    }

    // Converte os atributos em um array de Object, no formato que a
    // DefaultTableModel espera para preencher uma linha da JTable
    public Object[] obterDados(){
        return new Object[] {nome, sexo, idioma};
    }



}
