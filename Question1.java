package EntryTest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question1 {           //进行大数运算
    public static String plus(String a, String b) {
        int len = Math.max(a.length(), b.length());

        int[] la = new int[len];                //初始化数组
        int[] lb = new int[len];
        int[] result = new int[len+1];
        Arrays.fill(la,0);
        Arrays.fill(lb,0);
        Arrays.fill(result,0);

        String[] oa = a.split("");             //改为字符串数组
        String[] ob = b.split("");
        for (int i = 0; i < len; i++) {
            if (i < a.length()) {
                la[i] = Integer.parseInt(oa[a.length() - 1 - i]);
            }
            if (i < b.length()) {
                lb[i] = Integer.parseInt(ob[b.length() - 1 - i]);
            }
        }

        int over = 0;                             //进行位数加法
        for(int i = 0; i < la.length; i++){
            int sum = la[i]+lb[i]+over;
            result[i] = sum%10;
            over = sum/10;
        }if (over > 0) {
            result[len] = over;
        }

        StringBuffer sb = new StringBuffer();         //连接各个位上的数字
        boolean flag = false;
        for(int i = len; i >= 0; i--){
            if(!flag){
                if(result[i]==0){
                    continue;
                }else{
                    flag = true;
                    sb.append(String.valueOf(result[i]));
                }
            }else if(flag){
                sb.append(String.valueOf(result[i]));
            }
        }
        return sb.toString();
    }
}


