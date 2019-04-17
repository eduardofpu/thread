package thread.inicio;

public class ThreadExemploRunnable implements Runnable {

    private char c;

    public ThreadExemploRunnable(char c){
        this.c = c;
    }

    public void run() {
        System.out.println("Thread executiando"+Thread.currentThread().getName());
        for(int i = 0 ; i < 10; i++){
            System.out.print(c);
            if(i % 100 == 0){
                System.out.println();
            }
            // nao tem a mesma garantia que o sleep faz a thread que esta sendo executada voltar para o estado runable mas pode nao ter nenhum efeito
//            if(Thread.currentThread().getName().equalsIgnoreCase("T4")){
//                Thread.yield();
//            }



            try {
                // metodo static faz a thread dormir
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
