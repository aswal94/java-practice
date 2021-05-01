public class ReverseNo {
    public static void main(String[] args) {
        new ReverseNo().test();
    }

    public void test(){
        // 1534236469
        // 646324351
        // 2147483647
        System.out.println(Integer.MAX_VALUE);
        System.out.println("123: " + revNo(123));
        System.out.println("-123: " + revNo(-123));
    }

    public int revNo(int n){

        int rev = 0;

        while(n != 0){
            rev = rev * 10 + n%10;
            n = n/10;
        }

        return rev;

    }
}
