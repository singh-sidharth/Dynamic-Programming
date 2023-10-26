package Fibonacci;

import java.util.HashMap;

class Fibonacci {
    static final HashMap<Integer, Long> map = new HashMap<>();  

    public static long fibonacci(int n){

        if(!map.containsKey(n))
            map.put(n, Long.valueOf(fibonacci(n-1)+fibonacci(n-2)));

        return map.get(n);
    }

    public static void main(String[] args){
        map.put(1,Long.valueOf(1));
        map.put(2,Long.valueOf(1));
        int val = 6;
        if(args.length == 1)
        {
            try{
            val = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e){
                System.err.println("Please provide an integer value. Using default value "+val);
            }
        }
        System.out.println(fibonacci(val));
    }
}