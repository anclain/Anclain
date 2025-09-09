package EntryTest;


public class Question3 {
    public static long ugly(int N){
        int len = N;
        long all = (long)Math.pow(2, len);
        int[][] arr = new int[len+1][2];
        arr[1][0] = 2;
        arr[1][1] = 0;
        for(int i = 2; i <= len; i++){
            int num0 = arr[i-1][0] + arr[i-1][1];
            int num1 = arr[i-1][0];
            arr[i][0] = num0 % 1000000007;
            arr[i][1] = num1 % 1000000007;
        }
        return (all - arr[len][1] - arr[len][0] + 1000000007) % 1000000007;
    }
}
