package com.jrs.threads.exemplo4;

public class ExecutorAdd<T> implements Runnable {

    private Lista<T> lista;
    private T elemento;

    public ExecutorAdd (Lista lista, T elemento){
        this.lista = lista;
        this.elemento = elemento;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.lista.add(elemento);
        }
    }
    
}
