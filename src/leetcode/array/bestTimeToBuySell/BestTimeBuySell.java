package leetcode.array.bestTimeToBuySell;

public class BestTimeBuySell {
    public static void main(String[] args) {
        System.out.println(bestTimeBuySell(new int[]{7,1,5,3,6,4}));
    }

    static int bestTimeBuySell(int[] arr){
        int profit = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1])
                profit+= arr[i]-arr[i-1];
        }
        return profit;
    }
}
