package com.jrs.threads.exemplo5;

public class Main {
    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro();
        Thread convidado1 = new Thread(new Convidado("João", banheiro, AcaoEnum.NUMERO1), "João");
        Thread convidado2 = new Thread(new Convidado("João", banheiro, AcaoEnum.NUMERO2), "Pedro");
        Thread convidado3 = new Thread(new Convidado("João", banheiro, AcaoEnum.LIMPEZA), "Maria");
        // Thread convidado4 = new Thread(new Convidado("João", banheiro, AcaoEnum.NUMERO1), "Ana");


        convidado1.start();
        convidado2.start();
        convidado3.start();
        // convidado4.start();
    }
}
