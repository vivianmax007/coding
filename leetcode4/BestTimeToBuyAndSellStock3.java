import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 0) {
            return 0;
        }

        int[] history = new int[len];
        int[] future = new int[len];

        int min = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }

            history[i] = Math.max(history[i - 1], prices[i] - min);
        }

        int max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }

            future[i] = Math.max(future[i + 1], max - prices[i]);
        }

        int profit = 0;

        for (int i = 0; i < len; i++) {
            profit = Math.max(profit, history[i] + future[i]);
        }

        return profit;
    }
}
