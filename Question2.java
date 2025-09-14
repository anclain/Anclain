package EntryTest;

public class Question2 {
    public static int zip(String[] arr){
        int left = 0;
        int right = 0;
        int count = 0;
        int allcount = 0;                 //定义两个指针与计数器
        while(right <  arr.length){
            if(right < arr.length-1 && arr[right].equals(arr[right+1])){     //处理连续多个相同的数
                count++;
                right++;
            }if(right < arr.length-1 && !arr[right].equals(arr[right+1])){      //相邻两个数不同时结束本次遍历，移动left指针
                String temp = arr[right];
                count++;
                arr[left] = temp;
                String num = String.valueOf(count);
                for(int i = 0; i < num.length(); i++){
                    left++;
                    allcount++;
                    arr[left] = String.valueOf(num.charAt(i));            //更改原数组，进行压缩
                }left++;
                allcount++;
                right++;
                count = 0;
            }if(right == arr.length-1){                     //处理最后一位数字
                if(arr[right].equals(arr[right-1])){
                    count++;
                    String temp = arr[right];
                    arr[left] = temp;
                    String num = String.valueOf(count);
                    for(int i = 0; i < num.length(); i++){
                        left++;
                        allcount++;
                        arr[left] = String.valueOf(num.charAt(i));
                    }
                }else{
                    allcount++;
                    arr[left] = arr[right];
                }right++;
            }
        }
        return allcount+1;                   //返回结果
    }
}

