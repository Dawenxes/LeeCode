package dichotomy.solution69;

public class MySqrt {
    public int mySqrt(int x) {
        long ans=-1,left = 0, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(8));
    }
}
