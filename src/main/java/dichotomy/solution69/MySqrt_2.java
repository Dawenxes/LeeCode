package dichotomy.solution69;

public class MySqrt_2 {
    public int mySqrt(int x) {
        long ans = 0, left = 0, right = x;
        long mid = 0;
        while (left <=right) {
            mid = (int) (left + right) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid +1;
            } else {
                right = mid-1;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt_2().mySqrt(8));
    }
}
