package thread.estendendothread;

import java.applet.Applet;

public class Clock extends Applet implements  Runnable {
    private  Thread clockThread = null;

    public void start(){
        if(clockThread == null){
            clockThread = new Thread(this, "Clock");
            clockThread.start();
        }
    }

    @Override
    public void run() {
        Thread myThread = Thread.currentThread();

        while (clockThread == myThread){
            repaint();
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Clock c = new Clock();
        c.start();
        System.out.println("Iniciando ...");
    }
}
