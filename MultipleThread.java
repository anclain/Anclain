package EntryTest;

import com.sun.source.doctree.SystemPropertyTree;

public class MultipleThread {
    private static final Object lock = new Object();      //定义锁与计数器
    private static int counter = 1;

    public static void main(String[] args) {     
        Thread t1 = new Thread(() -> {         //线程1
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
        
        Thread t2 = new Thread(() -> {             //线程2
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
        t1.start();              //执行
        t2.start();
    }
}

