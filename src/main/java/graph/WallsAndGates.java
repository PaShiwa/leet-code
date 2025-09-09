package LeetCode.src.main.java.graph;

import java.util.*;

public class WallsAndGates {
    // Directions: up, down, left, right
    private static final int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
    private static final int INF = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;

        int rows = rooms.length, cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all gates (0s) into the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rooms[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        // Step 2: BFS from all gates simultaneously
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Skip out of bounds or non-INF cells
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols
                        || rooms[newRow][newCol] != INF) {
                    continue;
                }

                // Update distance (neighbor = current + 1)
                rooms[newRow][newCol] = rooms[row][col] + 1;
                queue.add(new int[]{newRow, newCol});
            }
        }
    }
}

