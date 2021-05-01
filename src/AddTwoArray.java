/**
 * Add two array
 * int[] arr1 = {1, 2, 3};
 * int[] arr2 = {4, 5, 6, 7};
 *  123 + 4567
 * <p>
 * res[] = {0, 4, 6, 9, 0}
 */
public class AddTwoArray {
    public static void main(String[] args) {
        new AddTwoArray().test();
    }

    public void test() {
        int[] arr1 = {9, 8, 6, 3};
        int[] arr2 = {4, 5, 6, 7};

        int sizeMax = Math.max(arr1.length, arr2.length);
        int sizeMin = Math.min(arr1.length, arr2.length);

        int[] arr3 = new int[sizeMax + 1];


        int n = 0;
        int carry = 0;
        while (n < sizeMax) {

            int r = 0;
            if (carry > 0) {
                r += carry;

                carry = 0;
            }

            if (n < sizeMin) {
                r += arr1[sizeMin - n - 1] + arr2[sizeMax - n - 1];

                if (r > 9) {
                    carry = r / 10;
                    arr3[sizeMax - n] = r % 10;
                } else {
                    arr3[sizeMax - n] = r;
                }
            } else {
                arr3[sizeMax - n] = r + arr2[sizeMax - n - 1];
            }
            n++;
        }

        if(carry>0){
            arr3[0] = carry;
        }

        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
