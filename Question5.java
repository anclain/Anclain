package EntryTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> layerList = new ArrayList<>();
        List<int[]> creamList = new ArrayList<>();
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
            int layers = layerList.get(i);
            int[] cream = creamList.get(i);
            boolean[] visited = new boolean[layers];
            Arrays.fill(visited, false);
            for(int j = 0; j < layers; j++) {
                int depth = cream[j];
                if(depth >= j+1){
                    for(int n = 0; n < j+1; n++){
                        visited[n] = true;
                    }
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
                }else if(j == layers - 1) {
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
