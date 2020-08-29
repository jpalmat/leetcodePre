package leetcode.array.mergeSortedArray;

public class Solution {
    public static void main(String[] args) {
        int[] num1 = {2, 0};
        int[] num2 = {1};

        merge(num1, 1, num2, 1);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n > 0) {
            int i = 0, j = 0, k = 0;
            int[] result = new int[m + n];
            while (k < m + n) {
                if (i < m && j < n) {
                    if (nums1[i] <= nums2[j]) {
                        result[k++] = nums1[i];
                        i++;
                    } else {
                        result[k++] = nums2[j];
                        j++;
                    }
                } else {
                    if (i < m)
                        result[k++] = nums1[i++];
                    else
                        result[k++] = nums2[j++];
                }
            }
            for (int l = 0; l < m + n; l++) {
                nums1[l] = result[l];
            }
        }
        //end my solution
    }
}