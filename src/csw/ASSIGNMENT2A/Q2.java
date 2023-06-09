package ASSIGNMENT2A;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Student {
  String name;
  int age, marks;

  Student(String name, int age, int marks) {
    this.name = name;
    this.age = age;
    this.marks = marks;
  }

  @Override
  public String toString() {
    return String.format("Name = %s, Age = %s, Marks = %s%n", name, age, marks);
  }
}

public class Q2 {
  static LinkedList<Student> linkedList = new LinkedList<>();
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int choice;
    do {
      showMenu();
      choice = Integer.parseInt(sc.nextLine());
      switch (choice) {
        case 1 -> searchStudent();
        case 2 -> removeStudent();
        case 3 -> System.out.println(linkedList.size());
        case 4 -> System.out.println(linkedList);
      }
    } while (choice != 0);

  }

  private static void removeStudent() {
    if (linkedList.isEmpty()) {
      return;
    }
    System.out.println("Enter student to remove: ");
    String name = sc.nextLine();
    Iterator<Student> iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      Student student = iterator.next();
      if (student.name == name) {
        linkedList.remove(student);
        System.out.println("Removed: " + student);
      }
    }
  }

  private static void searchStudent() {
    System.out.println("Enter student to search: ");
    String name = sc.nextLine();
    Iterator<Student> iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      Student student = iterator.next();
      if (student.name == name) {
        System.out.println("Present");
        return;
      }
    }
    System.out.println("Not present.");
  }

  private static void showMenu() {
    System.out.println("""
        MENU:
        1. Search for a student
        2. Remove a student
        3. Count of students
        4. Display students
        """);
  }
}

/*
 * 
 */