public class MatrixMultiplication {
  static void simpleMatrixMultiply(int[][] a, int[][] b) {
    int[][] newMatrix = new int[a.length][b[0].length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        for (int k = 0; k < b.length; k++) {
          newMatrix[i][j] += a[i][k] * b[k][j];
        }
      }
    }

    for (int[] row : newMatrix) {
      for (int x : row) {
        System.out.print(x + " ");
      }
      System.out.println();
    }
  }

  static void advancedMatrixMultiply(int[][][][] mat1, int[][][] mat2, int n) {
    int[][] a = { { 1 } }; // 1x1 matrix
    int[][] b = { { 2 } }; // 1x1 matrix
    int[][] c = { { 3 } }; // 1x1 matrix
    int[][] d = { { 4 } }; // 1x1 matrix
    int[][] e = { { 5 } }; // 1x1 matrix
    int[][] f = { { 6 } }; // 1x1 matrix
    int[][] g = { { 7 } }; // 1x1 matrix
    int[][] h = { { 8 } }; // 1x1 matrix

    int[][][][] A = {
        { a, b },
        { c, d },
    };
    int[][][][] B = {
        { e, f },
        { g, h },
    };

    int[][][][] res = new int[n][n][n / 2][n / 2];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          // res[i][j]
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] a = { { 5, 6 }, { 7, 8 } }; // 2x2 matrix
    int[][] b = { { 1, 2 }, { 3, 4 } }; // 2x2 matrix
    int[][] c = { { 2, 3 }, { 5, 7 } }; // 2x2 matrix
    int[][] d = { { 6, 9 }, { 2, 8 } }; // 2x2 matrix
    int[][] e = { { 4, 3 }, { 2, 8 } }; // 2x2 matrix
    int[][] f = { { 2, 3 }, { 6, 8 } }; // 2x2 matrix
    int[][] g = { { 2, 3 }, { 2, 1 } }; // 2x2 matrix
    int[][] h = { { 2, 3 }, { 2, 1 } }; // 2x2 matrix

    // 4D Array, 4X4 matrix
    int[][][][] A = {
        { a, b, c, d },
        { e, f, g, h },
        { a, b, c, d },
        { e, f, g, h },
    };

    // 4D Array, 4X4 matrix
    int[][][][] B = {
        { a, b, c, d },
        { e, f, g, h },
        { a, b, c, d },
        { e, f, g, h },
    };

    // Then do AXB

    simpleMatrixMultiply(a, b);

  }
}