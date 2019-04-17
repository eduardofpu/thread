package thread.Callable;

import java.util.concurrent.*;

import static java.util.concurrent.ThreadLocalRandom.current;

// O metodo Callable retorna ao contrario do Runnable
public class CallableTest implements Callable<String> {


    public String call() throws Exception {

        int count = current().nextInt(1, 11);

        for(int i = 0 ; i < count; i++){
            System.out.println(Thread.currentThread().getName() + " executando...");
        }
        return "Trabalho finalizado o numero aleatorio eh: "+count;
    }

    public static void main(String[] args) {
        CallableTest ct = new CallableTest();
        executor(ct);

    }

    private static void executor(CallableTest ct) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> resultFuture = executorService.submit(ct);
        try {

            String s = resultFuture.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
