package misc;

public class ConvertXToY {
    static int stepsToY(int x, int y) {
        int steps = 0;
        double temp = y;
        if (y > x) {
            int power = (int) Math.ceil(Math.log(temp / x) / Math.log(2));
            x = (int) (x * Math.pow(2, power));
            steps += power;
        }
        return steps + (x - y);
    }

    static int stepsToY2(int x, int y) {
        int steps = 0;
        while (x < y) {
            x = x * 2;
            steps++;
        }
        return steps + (x - y);
    }

    public static void main(String[] args) {
        for (int x = 2; x <= 100; x++) {
            for (int y = 2; y < 100; y++) {
                int steps1 = stepsToY(x, y);
                int steps2 = stepsToY2(x, y);
                System.out.println(steps1 == steps2);
            }
        }
    }
}
