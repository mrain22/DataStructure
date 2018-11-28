package test.BST;

import com.marvin.BST.BST;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: Marvin
 * @Date: 2018/11/24 9:04
 * @Version 1.0
 * @Describe:
 */
public class BSTtest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()){
           nums.add(bst.removeMin());
        }

        System.out.println(nums);
    }
}
