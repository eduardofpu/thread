package thread.estendendothread;

public class Simplethread extends Thread {
    private String meunome;

    public Simplethread(String str) {
        this.meunome = str;
    }

    public void run(){

        //Codigo executado pela thread
        for(int i = 0; i < 5 ; i++){
            System.out.println(i + " " + meunome);
            System.out.println( "DONE! " + meunome);
        }
    }

    // Executando duas thread 5 vezes cada uma
    public static void main(String[] args) {
        new Simplethread("Thread 1").start();
        new Simplethread("Thread 2").start();
    }

}
