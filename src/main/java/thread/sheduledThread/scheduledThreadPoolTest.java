package thread.sheduledThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

//Para agendamento de tarefas
public class scheduledThreadPoolTest {

    private static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    private static void beep(){
        //scheduledExecutorService.schedule(Runnable, 5, TimeUnit.SECONDS);

        final Runnable beeper = new Runnable() {
            public void run() {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date())+ " beep");
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //1 s de dely e a cada 5s execute o mesmo beep
        //scheduledExecutorService.scheduleAtFixedRate(beeper, 1, 5, TimeUnit.SECONDS);
        //scheduledExecutorService.scheduleWithFixedDelay(beeper, 1, 5, TimeUnit.SECONDS);

        final ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(beeper, 1, 5, TimeUnit.SECONDS);
        // Runnable retorna não retorna o valor  callable retorna o valor
        scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                System.out.println("Cancelando");
                scheduledFuture.cancel(false);
                scheduledExecutorService.shutdown();

            }

        }, 10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        beep();
    }
}
