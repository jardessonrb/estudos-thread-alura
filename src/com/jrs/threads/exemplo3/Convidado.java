package com.jrs.threads.exemplo3;

public class Convidado implements Runnable{
    private String nome;
    private Banheiro banheiro;
    private AcaoEnum acao;

    public Convidado(String nome, Banheiro banheiro, AcaoEnum acao){
        this.nome = nome;
        this.banheiro = banheiro;
        this.acao = acao;
    }

    @Override
    public void run() {
        if(this.acao.equals(AcaoEnum.NUMERO1)){
            this.banheiro.fazNumero1();
        }else {
            this.banheiro.fazNumero2();
        }
        
    }
}
