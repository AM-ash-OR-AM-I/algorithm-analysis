package ASSIGNMENT2B;

import java.util.Scanner;
import java.util.TreeMap;

class Address {
  int plotNo;
  String at, post;

  Address(int plotNo, String at, String post) {
    this.plotNo = plotNo;
    this.at = at;
    this.post = post;
  }

  @Override
  public String toString() {
    return String.format("plotNo: %s, At: %s, Post:%s%n", plotNo, at, post);
  }
}

public class Q2 {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    TreeMap<String, Address> treeMap = new TreeMap<>();
    int choice;
    do {
      showMenu();
      choice = Integer.parseInt(sc.nextLine());
      switch (choice) {
        case 1 -> addDetails(treeMap);
        case 2 -> System.out.println(treeMap);
      }
    } while (choice != 0);
  }

  private static void addDetails(TreeMap<String, Address> treeMap) {
    System.out.println("Enter your name: ");
    String name = sc.nextLine();
    System.out.println("Enter the plotNo, at, post separated by spaces: ");
    String[] details = sc.nextLine().split(" ");
    Address address = new Address(Integer.parseInt(details[0]), details[1], details[2]);
    treeMap.put(name, address);
  }

  private static void showMenu() {
    System.out.println("""
        Options:
        1. Add Details
        2. Display
        0. quit
        """);
  }

}
