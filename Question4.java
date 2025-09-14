package EntryTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Question4 {
    private static int[] root,size;      //定义每个人的团队代表人员与团队大小

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);           
        int n = sc.nextInt();
        int m = sc.nextInt();

        root = new int[n+1];
        size = new int[n+1];
        for(int i = 1; i <= n; i++){
            root[i] = i;
            size[i] = 1;
        }

        boolean flag = false;
        for(int i = 1; i <= m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            combine(a,b);

            if (size[find(a)] == n) {
                System.out.println(i);
                flag = true;                     //如果全部并入一个团体则输出操作完成全部合并的最后一次操作
                break;
            }
        }
        if(!flag){
            System.out.println("-1");           //如果没有完成全部并入一个团队则返回-1
        }
    }

    private static int find(int i){                  //定义通过递归寻找团队代表的方法
        if(i == root[i]){
            return i;
        }
        return root[i] = find(root[i]);
    }

    private static void combine(int i, int j){            //定义团队混合操作
        int rooti =  find(i);
        int rootj =  find(j);

        if (rooti != rootj) {
            if (size[rooti] >= size[rootj]) {
                root[rootj] = rooti;
                size[rooti] += size[rootj];
            } else {
                root[rooti] = rootj;
                size[rootj] += size[rooti];
            }
        }
    }
}

