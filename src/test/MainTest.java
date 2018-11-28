package test;

/**
 * @Author: Marvin
 * @Date: 2018/11/23 9:26
 * @Version 1.0
 * @Describe:
 */
public class MainTest {

    public static void main(String[] args) {
        int[]  arr = {1,2,3};
        System.out.println(sum(arr));
    }

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr,int i){
        if (i == arr.length){
            return 0;
        }
        return arr[i]+sum(arr,i+1);
    }

}
