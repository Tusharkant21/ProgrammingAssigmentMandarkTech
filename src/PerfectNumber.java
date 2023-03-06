import java.util.Scanner;

public class PerfectNumber {
    public static boolean isPerfect(int n) {
        // initialize the sum of divisors to 0
        int sumDivisors = 0;

        // loop through all possible divisors of n (excluding n itself)
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sumDivisors += i;
            }
        }

        // check if the sum of divisors equals n
        if (sumDivisors == n) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // test the isPerfect function with  input values
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPerfect(n));

    }
}
