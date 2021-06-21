package divide_conquer.solution50;

public class MyPow_2 {
    public double myPow(double x, int n) {
        long N = n;
        return n < 0 ? 1.0 / pow(x, -N) : pow(x, N);
    }

    public double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        double y = pow(x, n >> 1);
        return (n & 1) == 0 ? y * y : y * y * x;
    }

    public double pow2(double x, long n) {
        double x1 = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                x1 *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return x1;
    }

    public static void main(String[] args) {
        MyPow_2 myPow = new MyPow_2();
        myPow.myPow(2.00000, -2147483648);
    }
}
