package common;

public class GoodCode {
    // 求最大公约数
    public static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

}
