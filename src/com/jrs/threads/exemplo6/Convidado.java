package com.jrs.threads.exemplo6;

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
        }else if(this.acao.equals(AcaoEnum.NUMERO2)){
            this.banheiro.fazNumero2();
        }else {
            while(true){
                this.banheiro.limpaBanheiro();
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
    }
}
