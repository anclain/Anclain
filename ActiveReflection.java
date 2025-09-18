package EntryTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ActiveReflection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String className = sc.nextLine();
        try{
            Class<?> myClass = Class.forName(className);
            Constructor<?> cons = myClass.getDeclaredConstructor();
            Object instance = cons.newInstance();
            Method printM = myClass.getDeclaredMethod("print");
            printM.invoke(instance);
        }catch (Exception e) {
            // 这一个 catch 块就能捕获所有异常
            System.out.println("在执行反射操作时发生错误。");
            e.printStackTrace(); // 打印详细的错误堆栈信息
        }
        sc.close();
    }
}
