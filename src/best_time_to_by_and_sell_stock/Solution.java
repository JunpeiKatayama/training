package best_time_to_by_and_sell_stock;

// my answer
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// O(n^2) の解消ができず、case 203 でタイムリミットとなった
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if(profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.maxProfit(new int[]{1,2,3,4,5});
        int b = s.maxProfit(new int[]{7,6,4,3,1});
        int c = s.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("may be: 4, actual: " + a);
        System.out.println("may be: 0, actual: " + b);
        System.out.println("may be: 5, actual: " + c);
    }
}

// using dynamic programming
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions/1735493/java-c-best-ever-explanation-could-possible/
class Solution2 {
    public int maxProfit(int[] prices) {
        // ここには、for ループの中で「今日までの中での最低価格」が入る
        int minPrice = Integer.MAX_VALUE;
        // ここには、for ループの中で算出された中での「最高利益」が入る
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            // 「今日までの中の最低価格」で買ったとして、
            // この日に売ればいくらの利益になるか
            int todayProfit = price - minPrice;
            if (todayProfit > maxProfit) {
                maxProfit = todayProfit;
            }
        }
        return maxProfit;
    }
}

class Test2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int a = s.maxProfit(new int[]{1,2,3,4,5});
        int b = s.maxProfit(new int[]{7,6,4,3,1});
        int c = s.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("may be: 4, actual: " + a);
        System.out.println("may be: 0, actual: " + b);
        System.out.println("may be: 5, actual: " + c);
    }
}