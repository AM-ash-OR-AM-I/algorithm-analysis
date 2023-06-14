package ASSIGNMENT2A;

import java.util.Stack;

import utils.Util;

public class Q3 {
  static String decimalToBinary(int decimal) {
    Stack<Integer> stack = new Stack<>();
    while (decimal > 0) {
      stack.add(decimal % 2);
      decimal /= 2;
    }
    String bString = "";
    while (!stack.isEmpty()) {
      bString += stack.pop();
    }
    return bString;
  }

  public static void main(String[] args) {
    int x = Util.nextLineInteger();
    String bString = decimalToBinary(x);
    System.out.println(bString);
  }
}

/*
 * O/P:
 * 4324
 * 100001110010
 */