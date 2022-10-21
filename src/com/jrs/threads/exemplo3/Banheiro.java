package com.jrs.threads.exemplo3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banheiro {
    private Lock lock = new ReentrantLock();
    
    public void fazNumero1(){
        String nomeThead = Thread.currentThread().getName();
        System.out.println(nomeThead+" Batendo porta do banheiro");
        this.lock.lock();
            System.out.println(nomeThead+" Entrando no banheiro");
            System.out.println(nomeThead+" Fazendo coisa rapiada");
    
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println(nomeThead+" Deu erro no banheiro "+e.getMessage());
            }
    
            System.out.println(nomeThead+" Dando descarga");
            System.out.println(nomeThead+" Lavando as mãos");
            System.out.println(nomeThead+" Saindo do banheiro");
        this.lock.unlock();
    }

    public void fazNumero2(){
        String nomeThead = Thread.currentThread().getName();
        System.out.println(nomeThead+" Batendo porta do banheiro");
        this.lock.lock();
            System.out.println(nomeThead+" Entrando no banheiro");
            System.out.println(nomeThead+" Fazendo coisa demorada");
    
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println(nomeThead+" Deu erro no banheiro "+e.getMessage());
            }
    
            System.out.println(nomeThead+" Dando descarga");
            System.out.println(nomeThead+" Lavando as mãos");
            System.out.println(nomeThead+" Saindo do banheiro");
        this.lock.unlock();
    }
    
}


/*
 * Pode usando tanto o syncronized(this){ codigo }
 * quando o  
 *          this.lock.lock();
 *          codigo
 *          this.lock.unlock();
 *  */