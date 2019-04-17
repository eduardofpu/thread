package thread.deadlock;

public class DeadlockTest {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new ThreadExemplo1().start();
        new ThreadExemplo2().start();
    }

    private static class ThreadExemplo1 extends  Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("thread 1: Segurando lock 1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 1: Esperando pelo lock 2");

                synchronized (lock2){
                    System.out.println("thread 1: Segurando lock 1 e lock 2");
                }
            }
        }
    }

    private static class ThreadExemplo2 extends  Thread{
        public void run(){
            synchronized (lock2){
                System.out.println("thread 2: Segurando lock 2");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 2: Esperando pelo lock 1");

                synchronized (lock1){
                    System.out.println("thread 2: Segurando lock 2 e lock 2");
                }
            }
        }
    }
}
