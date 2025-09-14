package EntryTest;

import com.sun.source.doctree.SystemPropertyTree;

public class MultipleThread {
    private static final Object lock = new Object();
    private static int counter = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while(counter <= 100) {
                    if(counter%2 == 0){
                        System.out.println(counter);
                        counter++;
                        lock.notify();
                    }else{
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"thread1");
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                while(counter <= 100) {
                    if(counter%2 == 1){
                        System.out.println(counter);
                        counter++;
                        lock.notify();
                    }else{
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
