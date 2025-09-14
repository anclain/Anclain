package EntryTest;


public class Question3 {             //找寻丑陋字符串
    public static long ugly(int N){
        int len = N;               //定义字符串长度
        long all = (long)Math.pow(2, len);       //定义所有可能情况
        int[][] arr = new int[len+1][2];         //定义字符串长度为n时可能的美丽字符串数量
        arr[1][0] = 2;
        arr[1][1] = 0;
        for(int i = 2; i <= len; i++){
            int num0 = arr[i-1][0] + arr[i-1][1];       //通过动态规划来进行计算
            int num1 = arr[i-1][0];
            arr[i][0] = num0 % 1000000007;
            arr[i][1] = num1 % 1000000007;
        }
        return (all - arr[len][1] - arr[len][0] + 1000000007) % 1000000007;
    }
}


