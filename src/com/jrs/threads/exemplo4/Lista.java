package com.jrs.threads.exemplo4;

public class Lista<T> {
    private T[] elementos;
    private int indice = 0;

    public Lista(){
        this.elementos = (T[])new Object[10000];
    }

    //Outra forma de fazer colocando o synchronized direto no método
    public synchronized void add(T elemento){
        this.elementos[this.indice] = elemento;
        this.indice++;
    }

    //Outra forma de fazer colocando o synchronized na ação que deve ser sincronizada
    public void addE(T elemento){
        synchronized(this){
            this.elementos[this.indice] = elemento;
            this.indice++;
        }
    }
    
    public int size(){
        return this.indice;
    }

    public T get(int indice){
        return this.elementos[indice];
    }


    
}
