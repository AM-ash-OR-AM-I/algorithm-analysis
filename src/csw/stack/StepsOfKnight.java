package stack;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Given a chessboard and a knight start position. You need to find
 * minimum number of steps required to move a knight from start position to final
 * position.
 */

public class StepsOfKnight {
  private static void displayTraversedTime(int[][] steps) {
    System.out.println("Steps required array:");
    for (int[] arr : steps) {
      System.out.println(Arrays.toString(arr));
    }
  }

  static void traverseAllCells(int size, int[][] chessboardSteps, int currRow, int currCol,
      int steps) {
    if (currRow < 0 || currRow >= size || currCol < 0 || currCol >= size) // Boundary conditions
      return;
    if (chessboardSteps[currRow][currCol] <= steps) // If no. of steps taken is more than current value return
      return;

    // No. of steps taken to reach
    chessboardSteps[currRow][currCol] = steps;

    // Traverse for all possible steps
    traverseAllCells(size, chessboardSteps, currRow + 2, currCol - 1, steps + 1);
    traverseAllCells(size, chessboardSteps, currRow + 2, currCol + 1, steps + 1);
    traverseAllCells(size, chessboardSteps, currRow - 2, currCol - 1, steps + 1);
    traverseAllCells(size, chessboardSteps, currRow - 2, currCol + 1, steps + 1);
    traverseAllCells(size, chessboardSteps, currRow + 1, currCol - 2, steps + 1);
    traverseAllCells(size, chessboardSteps, currRow + 1, currCol + 2, steps + 1);
    traverseAllCells(size, chessboardSteps, currRow - 1, currCol - 2, steps + 1);
    traverseAllCells(size, chessboardSteps, currRow - 1, currCol + 2, steps + 1);

  }

  static int calculateMinSteps(int size, int startRow, int startCol, int targetRow, int targetCol) {
    int[][] chessboardSteps = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        chessboardSteps[i][j] = Integer.MAX_VALUE;
      }
    }
    traverseAllCells(size, chessboardSteps, startRow, startCol, 0);
    displayTraversedTime(chessboardSteps);
    int steps = chessboardSteps[targetRow][targetCol];
    if (steps == Integer.MAX_VALUE)
      return -1;
    return steps;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
    int size = Integer.parseInt(sc.nextLine());

    System.out.print("Enter the cell to start from: ");
    String source = sc.nextLine();
    String[] sourceCell = source.split(" ");
    int startRow = Integer.parseInt(sourceCell[0]), startCol = Integer.parseInt(sourceCell[1]);

    System.out.printf("Enter the cell to reach: ");
    String target = sc.nextLine();
    String[] targetCell = target.split(" ");
    int targetRow = Integer.parseInt(targetCell[0]), targetCol = Integer.parseInt(targetCell[1]);

    int stepsTaken = calculateMinSteps(size, startRow, startCol, targetRow, targetCol);
    System.out.printf("Min steps required = %d%n", stepsTaken);
  }
}

/*
 * 2 3 2 3 2 3 4 3
 * 1 2 1 4 3 2 3 4
 * 2 3 2 1 2 3 4 3
 * 3 2 3 2 3 2 3 4
 * 2 3 2 1 2 3 4 3
 * 1 2 1 4 3 2 3 4
 * 2 3 2 3 2 3 4 3
 * 3 2 3 2 3 4 3 4
 * 
 * 2 3 2 3 2 3 4 3
 * 1 2 1 4 3 2 3 4
 * 2 3 2 1 2 3 4 3
 * 3 0 3 2 3 2 3 4
 * 2 3 2 1 2 3 4 3
 * 1 2 1 4 3 2 3 4
 * 2 3 2 3 2 3 4 3
 * 3 2 3 2 3 4 3 4
 */