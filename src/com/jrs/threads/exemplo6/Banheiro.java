package com.jrs.threads.exemplo6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banheiro {
    private Lock lock = new ReentrantLock();
    private Boolean eshSujo = true;
    
    public void fazNumero1(){
        String nomeThead = Thread.currentThread().getName();
        System.out.println(nomeThead+" Batendo na porta do banheiro");
        synchronized(this){
            System.out.println(nomeThead+" Entrando no banheiro");

            while(eshSujo){
                esperarForaDoBanheiro(nomeThead);
            }

            System.out.println(nomeThead+" Fazendo coisa rapida");
    
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println(nomeThead+" Deu erro no banheiro "+e.getMessage());
            }
    
            System.out.println(nomeThead+" Dando descarga");
            System.out.println(nomeThead+" Lavando as mãos");
            System.out.println(nomeThead+" Saindo do banheiro");
            this.eshSujo = true;
        }
    }

    public void fazNumero2(){
        String nomeThead = Thread.currentThread().getName();
        System.out.println(nomeThead+" Batendo na porta do banheiro");
        synchronized(this){
            System.out.println(nomeThead+" Entrando no banheiro");

            while(eshSujo){
                esperarForaDoBanheiro(nomeThead);
            }
            System.out.println(nomeThead+" Fazendo coisa demorada");
    
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println(nomeThead+" Deu erro no banheiro "+e.getMessage());
            }
    
            System.out.println(nomeThead+" Dando descarga");
            System.out.println(nomeThead+" Lavando as mãos");
            System.out.println(nomeThead+" Saindo do banheiro");
            this.eshSujo = true;
        }
    }

    public void esperarForaDoBanheiro(String nome){
        try {
            System.out.println(nome+" banheiro está sujo, vou esperar lá fora");
            this.wait();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
    

    public void limpaBanheiro(){
        String nomeThead = Thread.currentThread().getName();
        System.out.println(nomeThead+" Batendo na porta do banheiro");
        synchronized(this){
            System.out.println(nomeThead+" Entrando no banheiro");

            if(!eshSujo){
                System.out.println(nomeThead+" banheiro não está sujo, saindo ... ");
                return;
            }
            System.out.println(nomeThead+" Limpando banheiro ... ");
            
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println(nomeThead+" Deu erro no banheiro "+e.getMessage());
            }

            System.out.println(nomeThead+" Lavando as mãos");
            System.out.println(nomeThead+" Saindo do banheiro");
            this.eshSujo = false;
            this.notifyAll();
        }
    }
}


/*
 * Pode usando tanto o syncronized(this){ codigo }
 * quando o  
 *          this.lock.lock();
 *          codigo
 *          this.lock.unlock();
 *  */