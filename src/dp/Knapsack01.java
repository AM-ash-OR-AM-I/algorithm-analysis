package dp;

/**
 * o | w | p
 * ---------
 * 1 | 2 | 5
 * 2 | 4 | 12
 * 3 | 1 | 3
 * 4 | 9 | 5
 * 5 | 10| 4
 * <br>
 * </br>
 * 
 * <h3>optimal solution for first i objects</h3>
 * 
 * <pre>
 * opt[n][c] = max(
 *     profit[n] + opt[n - 1][c - weight[n]],
 *     opt[n - 1][c])
 * </pre>
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
    this.noOfObjects = weights.length;
    this.profits = profits;
    this.capacity = capacity;
    profitMatrix = new int[noOfObjects + 1][capacity + 1];
  }

  void maximizeProfit() {
    for (int n = 1; n < noOfObjects; n++) {
      for (int c = 1; c < capacity; c++) {
        if (c >= weights[n]) {
          profitMatrix[n][c] = Math.max(
              profits[n] + profitMatrix[n - 1][c - weights[n]],
              profitMatrix[n - 1][c]);
        } else {
          profitMatrix[n][c] = profitMatrix[n - 1][c];
        }
      }
    }
  }

  void displayMatrix() {
    for (int[] row : profitMatrix) {
      for (int x : row) {
        System.out.print(x + "\t");
      }
      System.out.println();
    }
  }

}

public class Knapsack01 {

  public static void main(String[] args) {
    int capacity = 10;
    int[] weights = { 12, 34, 5, 6 };
    int[] profits = { 24, 43, 5, 55 };
    Knapsack knaspsack = new Knapsack(capacity, weights, profits);
    knaspsack.maximizeProfit();
    knaspsack.displayMatrix();

  }
}
