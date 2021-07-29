package bit.solution338;

/**
 * @Description: 比特位计数
 * @ClassName: CountBits
 * @Author: zbn
 * @Date: 2021/7/29 11:29
 */
public class CountBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}
