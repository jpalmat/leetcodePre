package leetcode.array.bestTimeToBuySell;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else if(prices[i]-min>max)
                max = prices[i] - min;
        }
        return max;
        //my solution
//        int sumTotal = 0, sumTemp = 0;
//        for (int i = prices.length -1; i >= 0; i--) {
//            for (int j = i - 1; j >= 0; j--) {
//                sumTemp = prices[i] - prices[j]> 0 ? prices[i] - prices[j] : 0;
//                if(sumTemp > sumTotal)
//                    sumTotal = sumTemp;
//            }
//        }
//        return sumTotal;
        //end my solution
    }
}