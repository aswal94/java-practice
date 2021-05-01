import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        new Fibonacci().test();
    }

    Map<Long, Long> memo = new HashMap<>();
    // 1 1 2 3 5
    public void test() {
        System.out.println("5  => " + fibo(5));
        System.out.println("6  => " + fibo(6));
        System.out.println("8  => " + fibo(8));
        System.out.println("10 => " + fibo(10));
        System.out.println("50 => " + fibo(50));
        System.out.println("100 => " + fibo(100));
    }

    public long fibo(long n){
        // 1 1 2 3 5 8 13 21
        // base case

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        if(n == 1 || n== 2){
            return 1;
        }

        long r =  fibo(n-1) + fibo(n-2);
        memo.put(n, r);
        return memo.get(n);
    }

    /**
     *                                 fibo(6)
     *                              /      \
     *                          fibo(5)    fibo(4)
     *                        /         \
     *                   fibo(4)        fibo(3)
     *                  /   \           /   \
     *           fibo(3)  fibo(2)   fibo(2) fibo(
     *         /       \
     *      fibo(2)   fibo(1)
     */
}
