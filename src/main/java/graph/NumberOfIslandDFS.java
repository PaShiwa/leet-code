package LeetCode.src.main.java.graph;

public class NumberOfIslandDFS {
    public int numIslands(char[][] grid){
        if(grid==null || grid.length==0){
            return 0;
        }

        int numIsland =0;
        for (int row =0; row< grid.length; row++){
            for (int column =0; column<grid[0].length; column++){
                if (grid[row][column]==1){
                    numIsland++;
                    dfs(grid, row, column);
                }
            }
        }
        return numIsland;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (row<0 || column<0 || row >= grid.length || column>=grid[0].length)
            return;

        if(grid[row][column] != '1'){
            return;
        }
        // Make it visited
        grid[row][column] = '0';

        // dfs in all four directions
        dfs(grid, row-1, column);
        dfs(grid, row+1, column);
        dfs(grid, row, column-1);
        dfs(grid, row, column +1);
    }

    public static void main(String[] args) {
        NumberOfIslandDFS numberOfIslandDFS = new NumberOfIslandDFS();

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0','0', '0', '0'}
        };

//        char[][] grid2 = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0','0', '1', '0'}
//        };
        System.out.println(numberOfIslandDFS.numIslands(grid1));

    }
}
