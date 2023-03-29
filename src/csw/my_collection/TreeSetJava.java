package my_collection;

import java.util.TreeSet;

public class TreeSetJava {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("abce");
        treeSet.add("abcde");
        treeSet.add("ABCE");
        treeSet.add("bjkbdf");
        System.out.println(treeSet);
    }
}
