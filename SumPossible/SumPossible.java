package SumPossible;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * We are given an amount as well as an array filled with numbers.
 * We want to return 'true' or 'false' inidicating whether or not we
 * can use some numbers of the array to generate the given amount.
 * 
 * @author Sidharth Singh {@literal sidharth-singh@outlook.com}
 */
public class SumPossible {

    private static boolean sumPossible(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo){

        if (amount == 0)
            return true;

        if (amount < 0)
            return false;

        if(memo.containsKey(amount))
            return memo.get(amount);

        // Check every posssible tree
        for (int num: numbers){
            int subAmount = amount - num;
            if(sumPossible(subAmount, numbers, memo)){
                memo.put(amount, true);
                return true;
            }
        }

        // No solution was found
        memo.put(amount, false);
        return false;
    }

    public static boolean sumPossible(int amount, List<Integer> numbers){
        return sumPossible(amount, numbers, new HashMap<>());
    }
    

    public static void main(String... args){

        int amount = 4;
        List<Integer> numbers = new ArrayList<>();

        if(args.length>0){
        
        try{
            amount = Integer.parseInt(args[0]);
            for (int i =1; i<=args.length ; i++)
                numbers.add(Integer.parseInt(args[i]));

        }
        catch(NumberFormatException e){
            System.out.println("Pease provide only integer values. Using defaults!");
            numbers = List.of(1,2,3);
        }
    }

        

        System.out.println(sumPossible(amount, numbers));
    }
}
