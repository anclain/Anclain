package EntryTest;

import com.sun.source.doctree.SystemPropertyTree;

public class MultipleThread {                    //进行多线程操作
    private static final Object lock = new Object();      //定义锁与计数器
    private static int counter = 1;

    public static void main(String[] args) {     
        Thread t1 = new Thread(() -> {         //线程1
            synchronized (lock) {
                while(counter <= 100) {
                    if(counter%2 == 0){        //打印偶数
                        System.out.println(counter);
                        counter++;
                        lock.notify();        //激活另一个线程
                    }else{
                        try {
                            lock.wait();       //线程锁定
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
                    if(counter%2 == 1){           //打印奇数
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




