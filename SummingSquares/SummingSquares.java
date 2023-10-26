package SummingSquares;

import java.util.HashMap;
import java.util.Map;

/** 
 * Summing Squares
 * <hr>
 * Write a function, summingSquares, that takes a target number as an argument.
 * The function should return the minimum number of perfect squares that sum
 * to the target. A perfect square is a number of the form (i*i) where i >= 1.
 * 
 * Ex: 12
 * 4+4+4 = 12 (Answer)
 * 9+1+1+1 = 12
 * 
 * @author Sidharth Singh {@literal sidharth-singh@outlook.com}
 */
public class SummingSquares {

    public static int summingSquares(int num){
        return summingSquares(num, new HashMap<>());
    }
    
    public static int summingSquares(int num, Map<Integer, Integer> memo){
        
        if(num == 0) return 0;

        if(!memo.containsKey(num)){
            int minSquares = Integer.MAX_VALUE;
        
            int sqrt = (int)Math.sqrt(num);
            for (int i=1; i<=sqrt; ++i){
                int square = i*i;
                int numSquares = 1 + summingSquares( num - square, memo);
                if(numSquares < minSquares) {
                    minSquares = numSquares;
                }
                memo.put(num, minSquares);
            }
        }      

        return memo.get(num);
    }


    public static void main(String[] args) {

        int val = 15;

        if(args.length == 1)
        {
            try{
                val = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e){
                System.err.println("Please provide an integer value. Using default value "+val);
            }
        }

        System.out.println(summingSquares(val));
    }
}
