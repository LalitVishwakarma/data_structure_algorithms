package Challange500;

public class BestTimeToBuySellStocks {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int min = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        BestTimeToBuySellStocks bestTimeToBuySellStocks = new BestTimeToBuySellStocks();
        System.out.println(bestTimeToBuySellStocks.maxProfit(arr));
    }
}
