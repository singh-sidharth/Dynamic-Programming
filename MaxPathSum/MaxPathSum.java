package MaxPathSum;

import java.util.HashMap;
import java.util.List;

/** 
 * Write a method, maxPathSum, that takes in a grid 
 * as an argument. The method should return the 
 * maximum sum possible by traveling a path from the
 * top-left corner to the bottom-right corner. You 
 * may only travel through the grid by moving down 
 * or right.
 * 
 * You can assume that all numbers are non-negative.
 * 
 * <pre>{@code
 * List<List<Integer>> grid = List.of(
 * List.of(1, 3, 12),
 * List.of(5, 1, 1),
 * List.of(3, 6, 1)
 * );
 * Source.maxPathSum(grid); // -> 18}</pre>
 * 
 * @author Sidharth Singh {@literal sidharth-singh@outlook.com}
 */

public class MaxPathSum {

    public static int maxPathSum(List<List<Integer>> grid){
        return maxPathSum(0, 0, grid, new HashMap<>());
    }

    public static int maxPathSum(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>, Integer> memo){

        // Checking out of bounds
        if(r == grid.size() || c == grid.get(0).size()) return Integer.MIN_VALUE;

        // Checking final destinations
        if(r == grid.size()-1 && c == grid.get(0).size()-1) return grid.get(r).get(c);

        List<Integer> position = List.of(r,c);

        if(memo.containsKey(position)) return memo.get(position);

        int result = grid.get(r).get(c) + Math.max(
            maxPathSum(r+1, c, grid, memo),
             maxPathSum(r, c+1, grid, memo)
             );

             memo.put(position, result);

             return result;

    }

    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(
            List.of(1,3,12),
            List.of(5,6,2)
        );

        System.out.println(maxPathSum(grid));
    }
    
}
