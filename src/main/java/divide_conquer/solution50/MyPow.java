package divide_conquer.solution50;

public class MyPow {
  public double myPow(double x, int n) {
    long N = n;
    return n < 0 ? 1.0 / pow2(x, -N) : pow2(x, N);
  }

  public double pow(double x, int n) {
    if (n == 0) {
      return 1.0;
    }
    if (n == 1) {
      return x;
    }

    double y = pow(x, n / 2);
    return n % 2 == 0 ? y * y : y * y * x;
  }

  public double pow2(double x, long n) {
    double tmpX = 1.0;
    while (n > 0) {
      if (n % 2 == 1) {
        tmpX *= x;
      }
      x *= x;
      n = n / 2;
    }
    return tmpX;
  }

  public static void main(String[] args) {
    MyPow myPow = new MyPow();
    myPow.myPow(2.00000, -2147483648);
  }
}
