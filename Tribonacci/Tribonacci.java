package Tribonacci;

import java.util.HashMap;

/**
 * Tribonacci
 * <hr>
 * Write a method tribonacci that takes in a number argument, n,
 * and returns the n-th number of the Tribonacci sequence.
 * The 0-th and 1-st numbers of the sequence are both 0.
 * The 2-nd number of the sequence is 1.
 * To generate further numbers of the sequence, calculate
 * the sum of previous three numbers.
 * 
 * Solve this recursively.
 * 
 * @author Sidharth Singh {@literal sidharth-singh@outlook.com}
 */
public class Tribonacci {
    static final HashMap<Integer, Long> memo = new HashMap<>();

    private static long tribonacci(int n){

        if(!memo.containsKey(n))
        memo.put(n, Long.valueOf(tribonacci(n-1)+ tribonacci(n-2)+ tribonacci(n-3)));

        return memo.get(n);
    }

    public static void main(String args[]){
        memo.put(0, Long.valueOf(0));
        memo.put(1, Long.valueOf(1));
        memo.put(2, Long.valueOf(1));

        int val = 6;

        if(args.length == 1){
            try{
                val = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e){
                System.out.println("Please enter an Integer value. Utilizing default value: "+ val);
            }
        }

        System.out.println(tribonacci(val));
    }
}
