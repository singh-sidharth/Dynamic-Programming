package NonAdjacentSum;

import java.util.HashMap;
import java.util.List;

/**
 * Given an array of numbers, calculate the maximum sum
 * of non adjacent elements.
 * ex: [2,4,5,12,7] = 16 (4+12)
 * [7,5,5,12] = 19 (7+12)
 * 
 * @author Sidharth Singh {@literal sidharth-singh@outlook.com}
 */
public class NonAdjacentSum {

    public static int nonAdjacentSum(List<Integer> array){        
        return nonAdjacentSum(array, 0, new HashMap<>() );
    }

    public static int nonAdjacentSum( List<Integer> nums, int startIdx, HashMap<Integer, Integer> memo){
        if (startIdx >= nums.size()) return 0;

        if(!memo.containsKey(startIdx)){
            int result =  Math.max(
                nums.get(startIdx)+nonAdjacentSum(nums, startIdx+2, memo),
                nonAdjacentSum(nums, startIdx + 1, memo)
                );
            memo.put(startIdx, result);
        }

        return memo.get(startIdx);
    }

    public static void main(String[] args) {

        List<Integer> arr = List.of(7,5,5,12);

        System.out.println(nonAdjacentSum(arr));

    }
    
}
