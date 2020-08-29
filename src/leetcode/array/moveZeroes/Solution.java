package leetcode.array.moveZeroes;

public class Solution {
    public static void main(String[] args) {
        int[] test = {0,1,0,3,12};
        moveZeroes(test);
    }
    public static void moveZeroes(int[] nums) {
        boolean move = false;
        for (int i = 0; i < nums.length; i++) {
            move = false;
            for (int j = 0; j < nums.length; j++) {
                if(!move && nums[j]!= 0){
                    continue;
                }
                move = true;
                if(j == nums.length - 1)
                    nums[j] = 0;
                else
                    nums[j] = nums[j + 1];
            }
        }
    }
}
