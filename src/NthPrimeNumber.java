/**
 * Program to find nth prime number
 */

public class NthPrimeNumber {
    public static void main(String[] args) {
        System.out.println("1 => " + getNthPrimeNumber(1));
        System.out.println("10 => " + getNthPrimeNumber(10));
        System.out.println("3 => " + getNthPrimeNumber(3));
        System.out.println("7 => " + getNthPrimeNumber(7));
    }

    private static int getNthPrimeNumber(int n) {

        int num = 2;
        int x = 0;
        int count;

        while (x < n) {
            count = 0;
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                x++;
                if (x == n) {
                    return num;
                }
            }
            num++;
        }

        throw new IllegalArgumentException("Invalid input");
    }
}
