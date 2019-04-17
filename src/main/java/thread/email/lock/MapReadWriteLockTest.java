package thread.email.lock;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite{
    private Map<String, String> map = new LinkedHashMap<String, String>();

    public void  put(String key, String value){
        map.put(key,value);
    }

    public Object[] allKeys(){
        return map.keySet().toArray();
    }
}

public class MapReadWriteLockTest {

    private final static MapReadWrite mapReadWrite = new MapReadWrite();
    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Write());
        Thread t2 = new Thread(new ReadA());
        Thread t3 = new Thread(new ReadB());

        t1.start();
        t2.start();
        t3.start();

    }

    // Para escrita somente uma thread para cada lock
    static class Write implements Runnable{

        public void run() {
            for(int i = 0; i < 100; i++){
                rwl.writeLock().lock();
                try {
                  mapReadWrite.put(String.valueOf(i), String.valueOf(i));
                }finally {
                  rwl.writeLock().unlock();
                }
            }
        }
    }


    // Para leitura mais de uma thread segura os lock
    static class ReadA implements Runnable{

        public void run() {
            for(int i = 0; i < 10; i++){
                rwl.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " " + Arrays.toString(mapReadWrite.allKeys()));
                }finally {
                    rwl.readLock().unlock();
                }
            }
        }
    }

    static class ReadB implements Runnable{

        public void run() {
            for(int i = 0; i < 10; i++){
                rwl.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " " + Arrays.toString(mapReadWrite.allKeys()));
                }finally {
                    rwl.readLock().unlock();
                }
            }
        }
    }


}
