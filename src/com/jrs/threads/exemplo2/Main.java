package com.jrs.threads.exemplo2;

public class Main {
    public static void main(String[] args) {
        String nomeBuscado = "Jon";

        Thread threadAutores = new Thread(new Buscador("autores.txt", nomeBuscado));
        Thread threadAssinaturas1 = new Thread(new Buscador("assinaturas1.txt", nomeBuscado));
        Thread threadAssinaturas2 = new Thread(new Buscador("assinaturas2.txt", nomeBuscado));

        threadAutores.start();
        threadAssinaturas1.start();
        threadAssinaturas2.start();
    }
}
