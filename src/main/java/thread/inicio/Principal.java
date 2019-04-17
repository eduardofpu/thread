package thread.inicio;

public class Principal {



    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(new ThreadExemploRunnable('A'), "T1");
        Thread t2 = new Thread(new ThreadExemploRunnable('B'), "T2");
        Thread t3 = new Thread(new ThreadExemploRunnable('C'), "T3");
        Thread t4 = new Thread(new ThreadExemploRunnable('D'), "T4");
        //prioridade
        t4.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        // enquanto não terminar t1 o main não ira iniciar as outras threads
        t1.join();
        t2.start();
        t3.start();
        t4.start();
    }
}
