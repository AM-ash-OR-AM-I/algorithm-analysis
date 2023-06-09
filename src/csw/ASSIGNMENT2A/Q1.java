package ASSIGNMENT2A;

import java.util.ArrayList;
import java.util.Scanner;

import utils.Util;

public class Q1 {
  static ArrayList<Integer> arrayList = new ArrayList<>();
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    arrayList = Util.takeUserInputArrayList();
    int choice;
    do {
      showMenu();
      choice = Integer.parseInt(sc.nextLine());
      switch (choice) {
        case 1 -> searchElement();
        case 2 -> removeElement();
        case 3 -> System.out.println(arrayList);
      }
    } while (choice != 0);

  }

  private static void removeElement() {
    if (arrayList.isEmpty()) {
      return;
    }
    int position = Util.nextLineInteger();
    int removed = arrayList.remove(position);
    System.out.println("Removed: " + removed);
  }

  private static void searchElement() {
    int element = Util.nextLineInteger();
    if (arrayList.contains(element)) {
      System.out.println("Element is present.");
    } else {
      System.out.println("Not present.");
    }
  }

  private static void showMenu() {
    System.out.println("""
        MENU:
        1. Search for a number
        2. Remove an element
        3. Display
        0. Quit
        """);
  }
}

/*
O/P:
Enter the array elements seprated by spaces: 
423 34 2 53 24
MENU:
1. Search for a number
2. Remove an element
3. Display
0. Quit

1
34
Element is present.
MENU:
1. Search for a number
2. Remove an element
3. Display
0. Quit

1
54534
Not present.
 */