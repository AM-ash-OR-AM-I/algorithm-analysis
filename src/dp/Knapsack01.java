package dp;

class Knapsack {
  private int maxLength = 4;
  private final int noOfObjects;
  private final int[] weights;
  private final int[] profits;
  private final int capacity;
  private int[][] profitMatrix;

  /**
   * <h2>0/1 Knapsack:</h2>
   * It adds items to bag/knapsack only if their weight is not greater
   * than the available capacity
   * {@code T(N) = O(n*c)}
   * 
   * @param capacity - Capacity of the knapsack
   * @param weights  - Weight of each item
   * @param profit   - Profit of each item
   */
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

  // ___________Code to Display Result below 👇🏻____________________

  void displayBorder() {
    System.out.println("=".repeat((capacity + 1) * maxLength));
  }

  String center(String s, int n) {
    int spaceSize = n - s.length();
    int prefixSize = spaceSize / 2;
    int suffixSize = (spaceSize + 1) / 2;
    return n > s.length()
        ? " ".repeat(prefixSize) + s + " ".repeat(suffixSize)
        : s;
  }

  void displayHeading() {
    System.out.printf(center("[MATRIX]", (capacity + 1) * maxLength));
  }

  void displayMatrix() {
    displayHeading();
    displayBorder();
    for (int[] row : profitMatrix) {
      for (int x : row) {
        System.out.printf("%-" + maxLength + "s", x);
      }
      System.out.println();
    }
    displayBorder();
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
