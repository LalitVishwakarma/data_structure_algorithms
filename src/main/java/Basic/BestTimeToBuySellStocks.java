package Basic;

public class BestTimeToBuySellStocks {
    public int maxProfit(int[] arr) {
        int minSoFar = arr[0];
        int maxProfit = 0;
        for(int i = 1; i < arr.length; i++) {
            minSoFar = Math.min(minSoFar, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minSoFar);
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        BestTimeToBuySellStocks bestTimeToBuySellStocks = new BestTimeToBuySellStocks();
        System.out.println(bestTimeToBuySellStocks.maxProfit(arr));
    }
}
