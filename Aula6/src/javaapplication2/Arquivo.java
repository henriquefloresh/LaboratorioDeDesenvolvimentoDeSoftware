/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por persistir a lista de Pessoas em um arquivo de texto,
 * usando ";" como separador de campos (uma pessoa por linha).
 *
 * @author laboratorio
 */
public class Arquivo {

    // Usados apenas dentro de gravaArquivo() para escrever no disco
    private FileWriter arqW;
    private BufferedWriter escritor;

    // Usados apenas dentro de lerArquivo() para ler do disco
    private FileReader arqR;
    private BufferedReader leitor;

    // Lista em memória que espelha o conteúdo do arquivo
    private List<Pessoa> listaPessoas;

    // Nome base do arquivo (sem extensão) - ex: "pessoas"
    public String nomeArquivo;

    public Arquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;   // a extensão ".txt" é adicionada depois, na hora de ler/gravar
        listaPessoas = new ArrayList<>(); // começa vazia até que lerArquivo() seja chamado
    }

    /**
     * Lê o arquivo "nomeArquivo.txt" linha a linha e reconstrói a lista de
     * objetos Pessoa a partir do texto salvo.
     *
     * Formato esperado de cada linha: nome;sexo;idioma
     *
     * @return a lista de pessoas carregada (ou vazia, se o arquivo não existir)
     */
    public List<Pessoa> lerArquivo() {

        listaPessoas.clear(); // evita duplicar dados caso o método seja chamado mais de uma vez

        try {
            arqR = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqR);

            String linha;

            // Lê o arquivo até o final (readLine retorna null ao chegar no EOF)
            while((linha = leitor.readLine()) != null) {
                String[] campos = linha.split(";"); // quebra a linha nos 3 campos esperados

                String nome = campos[0];
                char sexo =  campos[1].charAt(0);   // pega só o primeiro caractere ('M' ou 'F')
                String idioma = campos[2];

                Pessoa p = new Pessoa(nome, sexo, idioma);

                listaPessoas.add(p);
            }

            // Fecha os recursos de leitura para não deixar o arquivo travado/aberto
            leitor.close();
            arqR.close();

        } catch (FileNotFoundException e) {
            // Situação normal na primeira execução: arquivo ainda não existe.
            // Não é um erro grave, então apenas avisa e segue com a lista vazia.
            System.out.println("Arquivo ainda não exite");

        } catch (IOException e){
            // Erro inesperado de leitura (ex: arquivo corrompido, sem permissão etc.)
            e.printStackTrace();
        }

        return listaPessoas;
    }


    // Getter simples para acessar a lista carregada em outras classes
    public List<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    /**
     * Grava TODA a lista de pessoas no arquivo, sobrescrevendo o conteúdo
     * anterior por completo (não é um "append").
     */
    public void gravaArquivo() {
        try {
            // O segundo parâmetro "false" indica que o arquivo é reescrito do zero
            // a cada chamada, em vez de anexar (append) ao final do que já existia.
            arqW = new FileWriter(nomeArquivo + ".txt", false);
            escritor = new BufferedWriter(arqW);

            // Percorre cada pessoa da lista e escreve uma linha "nome;sexo;idioma;"
            for (Pessoa p : listaPessoas){
                escritor.write(
                    p.nome + ";" +
                    p.sexo + ";" +
                    p.idioma + ";"
                );

                escritor.newLine(); // garante que a próxima pessoa fique em outra linha
            }

            // Fecha os recursos de escrita para garantir que tudo seja salvo em disco
            escritor.close();
            arqW.close();

            System.out.println("Lista salva no arquivo!");

        } catch (IOException e) {
            // Erro ao gravar (ex: sem permissão de escrita, disco cheio etc.)
            e.printStackTrace();
        }
    }
}
