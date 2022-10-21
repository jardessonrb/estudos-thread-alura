package com.jrs.threads.exemplo6;

public class Main {
    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro();
        Thread convidado1 = new Thread(new Convidado("João", banheiro, AcaoEnum.NUMERO1), "João");
        Thread convidado2 = new Thread(new Convidado("João", banheiro, AcaoEnum.NUMERO1), "Pedro");
        Thread limpeza = new Thread(new Convidado("João", banheiro, AcaoEnum.LIMPEZA), "Limpeza");
        limpeza.setDaemon(true);
        // Thread convidado4 = new Thread(new Convidado("João", banheiro, AcaoEnum.NUMERO1), "Ana");


        convidado1.start();
        convidado2.start();
        limpeza.start();
        // convidado4.start();
    }
}
