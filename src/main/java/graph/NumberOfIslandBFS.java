package LeetCode.src.main.java.graph;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandBFS {
public int numIslands(char[][] grid){
    int numOfIsland =0;
    for(int row =0; row< grid.length; row++){
        for (int column =0; column<grid[0].length; column++){
            if (grid[row][column]=='1'){
                numOfIsland++;
                bfs(grid, row, column);
            }
        }
    }
   return numOfIsland;
}

    private void bfs(char[][] grid, int startRow, int startColumn) {
        int edgeRow = grid.length;
        int edgeColumn = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startColumn,startColumn});

        grid[startRow][startColumn] = '0';

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!queue.isEmpty()){
           int[] cell = queue.poll();

           int row = cell[0];
           int column = cell[1];

           for(int[] direction: directions){
               int newRow = row + direction[0];
               int newCol = column + direction[1];

               if(newRow >=0 && newRow < edgeRow && newCol >=0 && newCol <edgeColumn && grid[newRow][newCol]=='1'){
                   grid[newRow][newCol] ='0';
                   queue.offer(new int[]{newRow,newCol});
               }
           }
        }
    }

    public static void main(String[] args) {
        NumberOfIslandBFS numberOfIslandBFS = new NumberOfIslandBFS();

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0','0', '0',  '0'}
        };
        System.out.println(numberOfIslandBFS.numIslands(grid1));

    }
}
