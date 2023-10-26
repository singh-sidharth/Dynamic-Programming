package MinChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * You are given an amount and an array containing denominations for
 * coins. Calculate the minimum number of coins needed to provide the
 * amount. Return -1, if such a combination is not possible.
 * 
 * @author Sidharth Singh {@literal sidharth-singh@outlook.com}
 */
public class MinChange {

    public static int minChange (int amount, List<Integer> coins){
        return minChange(amount, coins, new HashMap<>());
    }

    static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memo) { 
        
        if(amount == 0) return 0;

        if(amount < 0 ) return -1;

        if(memo.containsKey(amount)) return memo.get(amount);
        
        int minCoins = -1;

        for (int coin : coins){
            
            int subAmount = amount - coin;
            int currCoins = minChange(subAmount, coins);
            
            if (currCoins != -1){
                int numCoins = currCoins + 1;
                
                if( numCoins < minCoins || minCoins == -1)
                    minCoins = numCoins;
            }
        }
        
        memo.put(amount, minCoins);
        return minCoins;

    }

    public static void main(String[] args){

        int amount = 3;
        List<Integer> coins = new ArrayList<>();

        if(args.length > 1){
            try{
                amount = Integer.parseInt(args[0]);
                for (int i=1;i<args.length;++i)
                    coins.add(Integer.parseInt(args[i]));
            }
            catch(NumberFormatException e){
                System.out.println("Please provide integral values. Using defaults");
                coins.add(1);
                coins.add(2);
                coins.add(5);
                
            }
        }
        else {
            coins.add(1);
            coins.add(2);
            coins.add(5);
        }
        System.out.println(coins);


        System.out.println(minChange(amount, coins));
    }
    
}
