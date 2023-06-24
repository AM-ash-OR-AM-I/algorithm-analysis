package dp;

class Knapsack {
  private int maxLength = 4;
  private final int noOfObjects;
  private final int[] weights;
  private final int[] profits;
  private final int capacity;
  private final int minProfit;
  private int[][] profitMatrix;
  private int[][] weightMatrix;

  /**
   * <h2>0/1 Knapsack:</h2>
   * It adds items to bag/knapsack only if their weight is not greater
   * than the available capacity
   * {@code T(N) = O(n*c)}
   * 
   * @param weights  - Weight of each item
   * @param profits  - Profit of each item
   * @param profit   - Minimum profit to be achieved
   * @param capacity - Max Capacity of the knapsack
   */
  Knapsack(int[] weights, int[] profits, int profit, int capacity) {
    this.weights = weights;
    this.profits = profits;
    this.noOfObjects = weights.length;
    profitMatrix = new int[noOfObjects + 1][capacity + 1];
    weightMatrix = new int[noOfObjects + 1][profit + 1];
    this.capacity = capacity;
    this.minProfit = profit;
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
  void optimal_profit(int n, int c) {
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
        optimal_profit(n, c);
      }
    }
    return profitMatrix[noOfObjects][capacity];
  }

  void optimal_weight(int n, int p) {
    if (p <= profits[n - 1]) {
      weightMatrix[n][p] = Math.min(
          weights[n - 1] + weightMatrix[n - 1][Math.max(0, p - profits[n - 1])],
          weightMatrix[n - 1][p]);
    } else {
      weightMatrix[n][p] = weights[n - 1] + weightMatrix[n - 1][p];
    }
  }

  int minimizeWeight() {
    // for (int p = 0; p <= minProfit; p++) {
    // weightMatrix[0][p] = Integer.MAX_VALUE;
    // }
    for (int n = 1; n <= noOfObjects; n++) {
      for (int p = 1; p <= minProfit; p++) {
        optimal_weight(n, p);
      }
    }
    return weightMatrix[noOfObjects][minProfit];
  }

  // ___________Code to Display Result below 👇🏻____________________

  void displayBorder() {
    System.out.println("=".repeat((capacity + 1) * maxLength));
  }

  String center(String s, int n) {
    int spaceSize = n - s.length();
    int prefixSize = spaceSize / 2;
    return n > s.length()
        ? " ".repeat(prefixSize) + s
        : s;
  }

  void displayHeading() {
    System.out.printf(center("[MATRIX]\n", (capacity + 1) * maxLength));
  }

  void displayProfitsMatrix() {
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

  void displayWeightsMatrix() {
    displayHeading();
    displayBorder();
    for (int[] row : weightMatrix) {
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
    int minProfit = 15;
    int[] weights = { 1, 2, 3, 4 };
    int[] profits = { 1, 4, 10, 21 };
    Knapsack knapsack = new Knapsack(weights, profits, minProfit, capacity);
    knapsack.setLength(6);
    int maxProfit = knapsack.maximumProfit();
    knapsack.displayProfitsMatrix();
    System.out.printf("%nMaxProfit = %d", maxProfit);
    int minWeight = knapsack.minimizeWeight();
    knapsack.displayWeightsMatrix();
    System.out.printf("%nMinWeight = %d", minWeight);

  }
}
