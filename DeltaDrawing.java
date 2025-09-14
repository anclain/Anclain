package EntryTest;

import java.util.Arrays;
import java.util.Scanner;

public class DeltaDrawing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int depth = sc.nextInt();
        int width = depth*2-1;                  //确定图像的宽与高
        char[][] map = new char[depth][width];  //初始化
        for(int i=0;i<depth-1;i++){
            for(int j=0;j<width;j++){
                map[i][j] = ' ';             //将所有元素填为单个空格
            }
        }
        Arrays.fill(map[map.length-1], '*');      //将最后一行所有元素改为符号*
        int startPoint = width/2;

        for(int i=0;i<width/2;i++){
            map[i][startPoint-i] = '*';
            map[i][startPoint+i] = '*';           //逐行进行特定填充
        }

        for(int j=0;j<depth;j++){
            for(int k=0;k<width;k++){
                System.out.print(map[j][k]);
            }
            System.out.println();                 //输出图形
        }
    }
}

