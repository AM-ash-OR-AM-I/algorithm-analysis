/*
 * Given that, fruits are arranged in a 2 dimensional grid. Among which
 * few fruits are rotten. In one day, a rotten fruit rot adjacent fruits that comes to its
 * contact. You need to find the maximum number of days in which the fruits of
 * whole grid will rot.
 */
package stack;

public class RottenFruit {
    static void DFSRottenFruit(int[][] mat, int[][] traversedTime, int rows, int cols, int currRow, int currCol,
            int day) {

        // Base case when it reaches the end.
        if (currCol < 0 || currCol >= cols || currRow < 0 || currRow >= rows)
            return;

        // When there is no fruit or it's already rotten in less number of days
        if (mat[currRow][currCol] == 0 || traversedTime[currRow][currCol] <= day)
            return;

        // Update rotten time
        traversedTime[currRow][currCol] = day;

        // Exhaustively search for all cells
        DFSRottenFruit(mat, traversedTime, rows, cols, currRow - 1, currCol, day + 1);
        DFSRottenFruit(mat, traversedTime, rows, cols, currRow + 1, currCol, day + 1);
        DFSRottenFruit(mat, traversedTime, rows, cols, currRow, currCol - 1, day + 1);
        DFSRottenFruit(mat, traversedTime, rows, cols, currRow, currCol + 1, day + 1);
    }

    static int findMaxNoOfDays(int[][] mat) {
        int cols = mat[0].length;
        int rows = mat.length;
        int[][] traversedTime = new int[rows][cols];

        // Initialize cell to max value to indicate it has not been visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                traversedTime[i][j] = Integer.MAX_VALUE;
            }
        }

        // Iterate through each cell and use dfs for neighbouring cell if the cell
        // contains
        // a rotten fruit.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    DFSRottenFruit(mat, traversedTime, rows, cols, i, j, 0);
                    System.out.println(i + "  " + j);
                }
            }
        }

        // Display time taken to traverse the array.
        displayTraversedTime(traversedTime);

        // Extract the maximum time taken to rot all fruits.
        int maxDays = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    if (traversedTime[i][j] == Integer.MAX_VALUE) { // When there is a fresh fruit remaining
                        return -1;
                    }
                    maxDays = Math.max(maxDays, traversedTime[i][j]);
                }
            }
        }
        return maxDays;

    }

    private static void displayTraversedTime(int[][] rottenTimes) {
        System.out.println("Time taken array:");
        for (int[] arr : rottenTimes) {
            for (int x : arr) {
                System.out.printf("%-10d\t", x);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 0 -> no fruit
        // 1 -> fresh
        // 2 -> rotten
        int[][] arr = {
                { 1, 1, 1, 0 },
                { 1, 2, 1, 0 },
                { 0, 1, 1, 1 },
                { 1, 1, 2, 1 },
                { 0, 1, 1, 1 },
                { 1, 2, 1, 0 },
                { 0, 1, 1, 1 },
        };
        int noOfDays = findMaxNoOfDays(arr);
        System.out.printf("Max No. of days = %d", noOfDays);

    }
}
