package divide_conquer.solution50;

public class MyPow_3 {
	public static void main(String[] args) {
		MyPow_3 myPow = new MyPow_3();
		myPow.myPow(2.00000, -2147483648);
	}

	public double myPow(double x, int n) {
		double result = 1.0;
		if (x == 0f) {
			return 0;
		}
		if (x == 1.0f) {
			return result;
		}
		long b = n;
		if (n < 0) {
			x = 1 / x;
			b = -b;
		}

		while (b > 0) {
			if ((b & 1) > 0) {
				result *= x;
			}
			x *= x;
			b = b >> 1;
		}
		return result;
	}
}
