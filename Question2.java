package EntryTest;

public class Question2 {
    public static int zip(String[] arr){
        int left = 0;
        int right = 0;
        int count = 0;
        int allcount = 0;
        while(right <  arr.length){
            if(right < arr.length-1 && arr[right].equals(arr[right+1])){
                count++;
                right++;
            }if(right < arr.length-1 && !arr[right].equals(arr[right+1])){
                String temp = arr[right];
                count++;
                arr[left] = temp;
                String num = String.valueOf(count);
                for(int i = 0; i < num.length(); i++){
                    left++;
                    allcount++;
                    arr[left] = String.valueOf(num.charAt(i));
                }left++;
                allcount++;
                right++;
                count = 0;
            }if(right == arr.length-1){
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
        return allcount+1;
    }
}
