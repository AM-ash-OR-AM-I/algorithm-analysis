package dp;

/**
 * w | p
 * -----
 * 2 | 5
 * 4 | 12
 * 1 | 3
 * 9 | 5
 * 10| 4
 */
class Knapsack {
  private int maxLength = 4;
  private final int noOfObjects;
  private final int[] weights;
  private final int[] profits;
  private final int capacity;
  private int[][] profitMatrix;

  Knapsack(int capacity, int[] weights, int[] profits) {
    this.weights = weights;
    this.profits = profits;
    this.noOfObjects = weights.length;
    this.capacity = capacity;
    profitMatrix = new int[noOfObjects + 1][capacity + 1];
  }

  /**
   * @param length - length of the integer to be used to print matrix
   */
  void setLength(int length) {
    this.maxLength = length;
  }

  /**
   * <h3>optimal solution for first i objects</h3>
   * 
   * <pre>
   * opt[n][c] = max(
   *     profit[n] + opt[n - 1][c - weight[n]],
   *     opt[n - 1][c])
   * </pre>
   * 
   * @param n - No. of objects selected
   * @param c - capacity of the knapsack
   * @return String
   */
  void optimal(int n, int c) {
    if (c >= weights[n - 1]) {
      profitMatrix[n][c] = Math.max(
          profits[n - 1] + profitMatrix[n - 1][c - weights[n - 1]],
          profitMatrix[n - 1][c]);
    } else {
      profitMatrix[n][c] = profitMatrix[n - 1][c];
    }
  }

  int maximumProfit() {
    for (int n = 1; n <= noOfObjects; n++) {
      for (int c = 1; c <= capacity; c++) {
        optimal(n, c);
      }
    }
    return profitMatrix[noOfObjects][capacity];
  }

  void printBorder() {
    System.out.println("=".repeat((capacity + 1) * maxLength));
  }

  void displayMatrix() {
    printBorder();
    for (int[] row : profitMatrix) {
      for (int x : row) {
        System.out.printf("%-" + maxLength + "s", x);
      }
      System.out.println();
    }
    printBorder();
  }

}

public class Knapsack01 {

  public static void main(String[] args) {
    int capacity = 10;
    int[] weights = { 1, 2, 3, 4 };
    int[] profits = { 5, 6, 432, 324 };
    Knapsack knapsack = new Knapsack(capacity, weights, profits);
    knapsack.setLength(6);
    int maxProfit = knapsack.maximumProfit();
    knapsack.displayMatrix();
    System.out.printf("%nMaxProfit = %d", maxProfit);

  }
}
