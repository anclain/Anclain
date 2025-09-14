package EntryTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();           //获取测试样例数
        List<Integer> layerList = new ArrayList<>();       //获取各个测试样例中的蛋糕层数
        List<int[]> creamList = new ArrayList<>();         //获取各个测试样例中的奶油加入操作
        for(int i = 0; i < N; i++) {
            int layers = sc.nextInt();
            layerList.add(layers);
            int[] cream = new int[layers];
            for (int j = 0; j < layers; j++) {
                cream[j] = sc.nextInt();
            }
            creamList.add(cream);
        }

        for(int i = 0; i < N; i++) {
            int layers = layerList.get(i);                //获取本次样例中的蛋糕层数与加奶油方法
            int[] cream = creamList.get(i);
            boolean[] visited = new boolean[layers];       //创建布尔数组存储各层蛋糕的浸染情况
            Arrays.fill(visited, false);
            for(int j = 0; j < layers; j++) {            //从蛋糕的最低一层开始向上遍历
                int depth = cream[j];                   //获取本次奶油使用量，即向下浸染层数
                if(depth >= j+1){
                    for(int n = 0; n < j+1; n++){       //更改visited数组表示奶油对蛋糕层的浸染
                        visited[n] = true;
                    }                                   //判断浸染层数是否超过蛋糕层数
                }else if(depth < j+1){
                    for(int n = j - depth + 1; n < j+1; n++){
                        visited[n] = true;
                    }
                }
            }
            for(int j = 0; j < layers; j++) {
                if(j < layers - 1) {
                    if(!visited[j]) {
                        System.out.print(0+" ");
                    }else{
                        System.out.print(1+" ");
                    }
                }else if(j == layers - 1) {               //对各层蛋糕的浸染情况进行输出
                    if(!visited[j]) {
                        System.out.println(0);
                    }else{
                        System.out.println(1);
                    }
                }
            }
        }

    }
}

