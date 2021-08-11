package string.solution8;

/**
 * @Description: 字符串转换整数 (atoi)
 * @ClassName: MyAtoi
 * @Author: zbn
 * @Date: 2021/8/10 11:49
 */
public class MyAtoi {
    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("words and 987"));
    }

    public int myAtoi1(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int base = 0, i = 0, n = s.length();
        int sign = 1;
        char c = s.charAt(i);
        // 剔除多余的
        while ((c < '0' || c > '9') && c != '-' && c != '+') {
            i++;
            c = s.charAt(i);
        }
        while ((c = s.charAt(i)) == '-' || c == '+') {
            if (c == '-') {
                sign = sign == 1 ? -1 : 1;
            } else {
                sign = sign == 1 ? 1 : -1;
            }
            i++;
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (s.charAt(i++) - '0');
        }
        return base * sign;
    }

    public int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int sign = 1, base = 0, i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return 0;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }
}
