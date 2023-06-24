/*
 * Given that, fruits are arranged in a 2 dimensional grid. Among which
 * few fruits are rotten. In one day, a rotten fruit rot adjacent fruits that comes to its
 * contact. You need to find the maximum number of days in which the fruits of
 * whole grid will rot.
 */
package stack;

import java.util.Arrays;

public class RottenFruit {
    static void DFSRottenFruit(int[][] mat, int[][] rottenTimes, int cols, int rows, int currCol, int currRow,
            int day) {

        // Base case when it reaches the end.
        if (currCol < 0 || currCol >= cols || currRow < 0 || currRow >= rows)
            return;

        // When there is no fruit or it's already rotten
        if (mat[currRow][currCol] == 0 || rottenTimes[currRow][currCol] <= day)
            return;

        // Update rotten time
        rottenTimes[currRow][currCol] = day;

        // Exhaustively search for all cells
        DFSRottenFruit(mat, rottenTimes, cols, rows, currCol - 1, currRow, day + 1);
        DFSRottenFruit(mat, rottenTimes, cols, rows, currCol + 1, currRow, day + 1);
        DFSRottenFruit(mat, rottenTimes, cols, rows, currCol, currRow - 1, day + 1);
        DFSRottenFruit(mat, rottenTimes, cols, rows, currCol, currRow + 1, day + 1);
    }

    static int maxNoOfDays(int[][] mat) {
        int cols = mat[0].length;
        int rows = mat.length;
        int[][] rottenTimes = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rottenTimes[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    DFSRottenFruit(mat, rottenTimes, cols, rows, i, j, 0);
                }
            }
        }
        System.out.println("Traversed array:");
        for (int[] arr : rottenTimes)
            System.out.println(Arrays.toString(arr));
        int maxDays = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (mat[i][j] == 1) {
                    if (rottenTimes[i][j] == Integer.MAX_VALUE) {
                        return -1;
                    }
                    maxDays = Math.max(maxDays, rottenTimes[i][j]);
                }
            }
        }
        return maxDays;

    }

    public static void main(String[] args) {
        // 0 -> no fruit
        // 1 -> fresh
        // 2 -> rotten
        int[][] arr = {
                { 0, 0, 1, 0, 0 },
                { 0, 1, 1, 1, 0 },
                { 1, 1, 2, 1, 1 },
                { 0, 1, 1, 1, 0 },
                { 0, 0, 1, 0, 0 },
        };
        int noOfDays = maxNoOfDays(arr);
        System.out.printf("Max No. of days = %d", noOfDays);

    }
}
