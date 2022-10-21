package com.jrs.threads.exemplo4;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Lista<String> lista = new Lista<>();

        for(int i = 0; i < 10; i++){
            new Thread(new ExecutorAdd(lista, "Thread de Numero "+i), "Thread de Numero "+i).start();
        }

        Thread.sleep(1000);

        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i) == null){
                System.out.println(lista.get(i-1));
                System.out.println(lista.get(i-2));
                int x = (i+10);
                while((i < x) && i < 10000){
                    System.out.println(i+" "+lista.get(i));
                    i++;
                }

                break;
            }
        }
    }

}
