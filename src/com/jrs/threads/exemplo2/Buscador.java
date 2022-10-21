package com.jrs.threads.exemplo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Buscador implements Runnable {

    private String nomeArquivo;
    private String nomeParaBusca;

    public Buscador(String arquivo, String nome){
        this.nomeArquivo = arquivo;
        this.nomeParaBusca = nome;
    }

    @Override
    public void run() {
       try {
        Scanner scanner = new Scanner(new File("arquivos/exemplo2/"+nomeArquivo));
        int numeroLinha = 0;
        while (scanner.hasNextLine()) {

            String linha = scanner.nextLine();

            if (linha.contains(this.nomeParaBusca)) {
                System.out.println(nomeArquivo + " - " + numeroLinha + " - " + linha);
            }

            numeroLinha++;

        }

        scanner.close();
       } catch (FileNotFoundException  e) {
            throw new RuntimeException("Erro ao ler arquivo "+e.getMessage());
       }
        
    }
    
}
