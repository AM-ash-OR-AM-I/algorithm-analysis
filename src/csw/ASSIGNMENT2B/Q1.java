package ASSIGNMENT2B;

import java.util.Scanner;
import java.util.TreeSet;

import utils.Util;

public class Q1 {
  static Scanner sc = new Scanner(System.in);

  private static void removeElement(TreeSet<Integer> treeSet) {
    System.out.println("Enter element to remove: ");
    int element = sc.nextInt();
    treeSet.remove(element);
    System.out.println("Removed " + element);
  }

  private static void displayTreeSet(TreeSet<Integer> treeSet) {
    System.out.println("TreeSet: ");
    System.out.println(treeSet);
  }

  private static void checkNumber(TreeSet<Integer> treeSet) {
    System.out.println("Enter a number to search: ");
    int x = sc.nextInt();
    if (treeSet.contains(x)) {
      System.out.println("Number is present.");
    } else {
      System.out.println("Number isn't present.");
    }
  }

  private static void showMenu() {
    System.out.println("""
        Enter your choice:
        0. Exit
        1. Display TreeSet
        2. Check number exists
        3. Remove element
        """);
  }

  public static void main(String[] args) {
    TreeSet<Integer> treeSet = new TreeSet<Integer>();
    int[] arr = Util.takeUserInput();
    for (int x : arr) {
      treeSet.add(x);
    }
    int choice;
    do {
      showMenu();
      choice = sc.nextInt();
      switch (choice) {
        case 1 -> displayTreeSet(treeSet);
        case 2 -> checkNumber(treeSet);
        case 3 -> removeElement(treeSet);
      }
    } while (choice != 0);
    sc.close();
  }

}
