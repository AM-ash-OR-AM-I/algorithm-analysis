package recursion;

/*
 * N people seating in a round table. From kth person will be executed
 * Excution continues until last person.
 */
public class Joseph {
    static int personToSurvive(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (personToSurvive(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        int person = personToSurvive(23, 3);
        System.out.println(person);
    }
}
