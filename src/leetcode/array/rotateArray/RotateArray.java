package leetcode.array.rotateArray;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[]nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotateCyclicReplacements(nums, k);
    }

    public static void rotateBruteForce(int[] nums, int k) {
        // speed up the rotation
//        k %= nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        Arrays.stream(nums).forEach(x -> System.out.println(x));
    }

    public static void rotateCyclicReplacements(int[] nums, int k) {
        //k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
        Arrays.stream(nums).forEach(x -> System.out.println(x));
    }
}
