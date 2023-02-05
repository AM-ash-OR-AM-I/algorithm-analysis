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
  final int noOfObjects;
  final int[] weights;
  final int[] profits;
  final int capacity;
  int[][] profitMatrix;
  int maxProfit = 0;

  Knapsack(int capacity, int[] weights, int[] profits) {
    this.weights = weights;
    this.profits = profits;
    this.noOfObjects = weights.length;
    this.capacity = capacity;
    profitMatrix = new int[noOfObjects + 1][capacity + 1];
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

  void maximizeProfit() {
    for (int n = 1; n <= noOfObjects; n++) {
      for (int c = 1; c <= capacity; c++) {
        optimal(n, c);
      }
    }
    maxProfit = profitMatrix[noOfObjects][capacity];
  }

  void displayMatrix() {
    System.out.println("=".repeat((capacity + 1) * 8));
    for (int[] row : profitMatrix) {
      for (int x : row) {
        System.out.printf("%-8s", x);
      }
      System.out.println();
    }
    System.out.println("=".repeat((capacity + 1) * 8));
  }

}

public class Knapsack01 {

  public static void main(String[] args) {
    int capacity = 10;
    int[] weights = { 1, 2, 3, 4 };
    int[] profits = { 5, 6, 53425, 324 };
    Knapsack knaspsack = new Knapsack(capacity, weights, profits);
    knaspsack.maximizeProfit();
    knaspsack.displayMatrix();
    System.out.printf("%nMaxProfit = %d", knaspsack.maxProfit);

  }
}
