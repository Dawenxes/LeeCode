package dichotomy.solution367;

public class IsPerfectSquare_2 {
    public static void main(String[] args) {
        new IsPerfectSquare_2().isPerfectSquare_(16);
    }

    public boolean isPerfectSquare_(int num) {
        long x = num / 2 + 1;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        long left = 2, right = num / 2;
        long mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            long tmp = mid * mid;
            if (tmp == num) {
                return true;
            } else if (tmp < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
