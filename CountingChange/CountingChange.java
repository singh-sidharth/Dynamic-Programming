package CountingChange;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Counting Change
 * <hr>
 * Write a method, countingChange, that takes in an amount
 * and an array of coins. The method should return the 
 * number of different ways it is possible to make change
 * for the given amount using the coins.
 * 
 * You may reuse a coin as many times as necessary.
 * 
 * For example,
 * countingChange(4, List.of(1,2,3)) -> 4
 * 
 * There are 4 different ways to make an amount of 4:
 * 
 * 1. 1+1+1+1
 * 2. 1+1+2
 * 3. 1+3
 * 4. 2+2
 * 
 * @author Sidharth Singh {@literal sidharth-singh@outlook.com}
 */

public class CountingChange {

    public static int countingChange(int amount, List<Integer> coins){
        return countingChange(amount, coins, 0, new HashMap<>());
    }

    public static int countingChange(int amount, List<Integer> coins, int coinIdx, Map<List<Integer>, Integer> memo){

        if (amount == 0){
            return 1;
        }

        if(coinIdx >= coins.size()) return 0;

        List<Integer> key = List.of(amount, coinIdx);

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int currCoin = coins.get(coinIdx);

        int result = 0;

        for ( int qty = 0; qty*currCoin <= amount; qty++){
            int subAmount = amount - qty*currCoin;
            result += countingChange(subAmount, coins, coinIdx+1, memo);
        }
        
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {

        int amount = 24;
        List<Integer> coins = List.of(5,7,3);
        
        System.out.println(countingChange(amount, coins));
    }
    
}
