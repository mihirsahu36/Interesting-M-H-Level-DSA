/*Implement pow(x, n), which calculates x raised to the power n (i.e., xn).*/

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double pow = 1.0;
        double currentProduct = x;

        while (N > 0) {
            if (N % 2 == 1) {
                pow *= currentProduct;
            }
            currentProduct *= currentProduct;
            N /= 2;
        }
        
        return pow;
    }
}
