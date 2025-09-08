package LeetCode.src.main.java.graph;

import java.util.*;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        // Directions for 4-neighbors (up, down, left, right)
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Collect initial rotten oranges & count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c}); // Add rotten orange to queue
                } else if (grid[r][c] == 1) {
                    freshCount++; // Count fresh oranges
                }
            }
        }

        // If no fresh oranges, no time is needed
        if (freshCount == 0 )
            return 0;

        if(queue.isEmpty())
            return -1;

        int minutes = -1; // Track time; will be incremented in BFS

        // Step 2: BFS from all rotten oranges simultaneously
        while (!queue.isEmpty()) {
            minutes++; // One level = one minute
            int size = queue.size();
            for (int i = 0; i <size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                // Check all 4 neighbors
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];

                    // Infect fresh oranges
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Turn to rotten
                        freshCount--;     // One less fresh
                        queue.offer(new int[]{nr, nc}); // Add to queue
                    }
                }
            }
        }
        // Step 3: If freshCount == 0, all oranges rotten → return time
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {0,0,0},
                {0,2,1},
                {0,1,1}
        };
        System.out.println(new RottenOranges().orangesRotting(grid));
    }
}

