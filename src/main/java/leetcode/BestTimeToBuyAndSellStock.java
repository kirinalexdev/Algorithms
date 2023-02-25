package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BestTimeToBuyAndSellStock {

    // Идея: для каждой цены найти мин. предшествущую цену
    //       а чтобы ее узнать, достаточно вычислять на каждом шаге от предудущих
    // (идея тут описана https://www.youtube.com/watch?v=1SS2WnsMcbU)
    // (код взял отсюда https://youtu.be/kU1gkusIoZ0?t=740)

    static public int maxProfit(int[] prices) {
        var minPrice = Integer.MAX_VALUE;
        var maxProfit= Integer.MIN_VALUE;
        int curProfit;

        for (int curPrice: prices) {
            minPrice = Math.min(minPrice, curPrice);
            curProfit = curPrice - minPrice;
            maxProfit = Math.max(maxProfit, curProfit);
        }

        return maxProfit;
    };

    public static void main(String[] args) {
        var res1 =  maxProfit(new int[] {7,1,5,3,6,4}); // Output: 5
        var res2 = maxProfit(new int[] {7,6,4,3,1}); // Output: 0

        System.out.println(res1);
        System.out.println(res2);
    };

//    static public int maxProfit_MY(int[] prices) {
//
//        var queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
//        for (int i = 1; i < prices.length; i++) {
//            queue.add(prices[i]);
//        }
//
//        int max = 0;
//
//        for (int i = 0; i < prices.length-1; i++) {
//            max = Math.max(max, queue.peek() - prices[i]);
//            queue.remove(prices[i + 1]);
//        }
//
//        return max;
//
//    }


}
