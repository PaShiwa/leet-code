package LeetCode.src.main.java.grid;

public class NumberOfIslands {

    public int numIslands(char[][] grid){

        if(grid == null || grid.length == 0)
            return 0;

        int islandCount =0;

        // Traversing every cell in the grid
        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                // if a land is found, run DFS and increase the count
              if(grid[i][j]=='1'){
                  islandCount++;
                  dfs(grid,i,j);
              }
            }
        }
        return islandCount;
    }
    private void dfs(char[][] grid, int i, int j){
        // out of bounds or water cell
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j] == '0'){
            System.out.println("At grid " + i +" " + j);
            return;
        }
        // mark the cell as visited
        grid[i][j] = '0';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NumberOfIslands solution = new NumberOfIslands();
        int result = solution.numIslands(grid);

        System.out.println("Number of islands: " + result);
    }
}
