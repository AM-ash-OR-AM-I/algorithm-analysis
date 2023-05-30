package recursion;

public class CheckFunc {
    public static void function2() {
        System.out.println("fun2 line 1");
    }

    public static void function1() {
        System.out.println("fun1 line 1");
        function2();
        System.out.println("fun1 line 2");
    }

    public static void main(String[] args) {
        System.out.println("main line 1");
        function1();
        System.out.println("main line 2");
    }
}
