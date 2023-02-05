package divide_conquer;

public class KaratsubaFastMultiply {

  static void debug2(int a1, int a0, int b1, int b0, int n) {
    int newA = (a1 << (n / 2)) + a0;
    int newB = (b1 << (n / 2)) + b0;
    System.out.printf("%s %s, %s %s%n",
        Integer.toBinaryString(a1), Integer.toBinaryString(a0),
        Integer.toBinaryString(b1), Integer.toBinaryString(b0));
    System.out.printf("%s %s, %s %s%n", a1, a0, b1, b0);
    System.out.printf("%s, %s%n", newA, newB);
  }

  static void debug1(String a, String b) {
    System.out.println(a + "\n" + b);
  }

  static int getBits(int n) {
    int bits = 0;
    while (n > 0) {
      n >>= 1;
      bits++;
    }
    return bits;
  }

  static int fastMultiplyBitwise(int a, int b) {
    // debug1(a, b);
    int n1 = getBits(a), n2 = getBits(b);
    int a1 = a >> n1 / 2, a0 = a - (a1 << n1 / 2);
    int b1 = b >> n2 / 2, b0 = b - (b1 << n2 / 2);
    int a1b1 = a1 * b1;
    int a0b0 = a0 * b0;
    debug2(a1, a0, b1, b0, n1);
    int res = (a1b1 << (n1 + n2) / 2) + ((a1 * b0) << n1 / 2) + ((b1 * a0) << n2 / 2) + (a0b0);
    return res;
  }

  static String padZeroes(String s, int n) {
    return String.format("%" + n + "s", s).replace(" ", "0");
  }

  /**
   * Multiplies 2 numbers using their binary representation.
   * 
   * @param a
   * @param b
   * @return
   */
  static int fastMultiply(int a, int b) {
    String binaryA = padZeroes(Integer.toBinaryString(a), 64);
    String binaryB = padZeroes(Integer.toBinaryString(b), 64);
    debug1(binaryA, binaryB);
    int n = 64;
    int a1 = Integer.parseInt(binaryA.substring(0, 32));
    int a0 = Integer.parseInt(binaryA.substring(32, 64));

    int b1 = Integer.parseInt(binaryB.substring(0, 32));
    int b0 = Integer.parseInt(binaryB.substring(32, 64));
    int a1b1 = (a1 * b1);
    int a0b0 = (a0 * b0);
    int p = (a1 + a0) * (b1 + b0);
    debug2(a1, a0, b1, b0, n);
    int res = (a1b1 << n) + ((a1 * b0 + b1 * a0) << n / 2) + (a0b0);
    return res;
  }

  public static void main(String[] args) {
    int a = 35343425, b = 453543435;
    int result = fastMultiply(a, b);
    int correctResult = a * b;
    if (result != correctResult) {
      System.out.printf("Wrong result = %d, correct result = %d%n", result, correctResult);
    } else {
      System.out.println("Correct");
    }
  }
}
