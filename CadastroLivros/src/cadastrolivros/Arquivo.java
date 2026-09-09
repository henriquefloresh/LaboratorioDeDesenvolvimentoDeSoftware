/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrolivros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 *
 * @author laboratorio
 */
public class Arquivo {

     
    private FileWriter arqW;
    private BufferedWriter escritor;

     
    private FileReader arqR;
    private BufferedReader leitor;

     
    private List<CadastroLivros> listaLivros;

     
    public String nomeArquivo;

    public Arquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;    
        listaLivros = new ArrayList<>();  
    }

    /**
     *  
     *  .
     *
     *  
     *
     * @return  
     */
    public List<CadastroLivros> lerArquivo() {

        listaLivros.clear();  

        try {
            arqR = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqR);

            String linha;

            
            while((linha = leitor.readLine()) != null) {
                String[] campos = linha.split(";");  

                String titulo = campos[0];
                String autor = campos[0];
                String anoPublicacao = campos[0];
                String categorias = campos[3];
                char tipo =  campos[1].charAt(0);
                char situacaoLeitura =  campos[2].charAt(0);

                CadastroLivros l = new CadastroLivros(titulo, autor, anoPublicacao, categorias, tipo, situacaoLeitura );

                listaLivros.add(l);
            }

             
            leitor.close();
            arqR.close();

        } catch (FileNotFoundException e) {
            
            System.out.println("Arquivo ainda não exite");

        } catch (IOException e){
             
            e.printStackTrace();
        }

        return listaLivros;
    }


    
    public List<CadastroLivros> getListaPessoas() {
        return listaLivros;
    }

    /**
     *  
     *  
     */
    public void gravaArquivo() {
        try {
            
            arqW = new FileWriter(nomeArquivo + ".txt", false);
            escritor = new BufferedWriter(arqW);

             
            for (CadastroLivros l : listaLivros){
                escritor.write(l.titulo +";"+ l.autor+";"+ l.categorias+";"+ l.anoPublicacao+";"+ l.tipo+";"+ l.situacaoLeitura );

                escritor.newLine();  
            }

             
            escritor.close();
            arqW.close();

            System.out.println("Lista salva no arquivo!");

        } catch (IOException e) {
             
            e.printStackTrace();
        }
    }
}

