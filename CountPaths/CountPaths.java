package CountPaths;

import java.util.List;
import java.util.HashMap;

/**
 * We are given a grid. Traveller from top-left corner to bottom-right corner.
 * We are only allowed to move right or down. Find the total number of ways to
 * travel from top-left to bottom-right corner. There will be blocks of path that
 * we cannot travel through.
 * 
 * @author Sidharth Singh {@literal sidharth-singh@outlook.com}
 */
public class CountPaths {

    public static int countPaths(List<List<String>> grid){
        return countPaths(0, 0, grid, new HashMap<>());
    }
    

    public static int countPaths(int r, int c, List<List<String>> grid, HashMap<List<Integer>, Integer> memo){

        // There are 0 ways to travel from invalid positions
        if( r == grid.size() || c == grid.get(0).size()) return 0;

        // Check for open positions
        if (grid.get(r).get(c) == "X") return 0;

        // Check for bound lengths
        if ( r==grid.size()-1 && c == grid.get(0).size() -1){
            return 1;
        }

        List<Integer> pos = List.of(r, c);

        if(memo.containsKey(pos)) return memo.get(pos);

        int pathCount = countPaths(r+1, c, grid, memo) + countPaths(r, c+1, grid, memo);
        memo.put(pos, pathCount);
        return pathCount;
    }

    public static void main(String[] args) {

        List<List<String>> grid = List.of(
            List.of("O","O", "X"),
            List.of("O","O", "O"),
            List.of("O","O", "O")
        );        

        System.out.println(countPaths(grid));
        
    }
}
