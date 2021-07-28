package bit.solution191;

/**
 * @Description: 位1的个数
 * @ClassName: HammingWeight
 * @Author: zbn
 * @Date: 2021/7/28 22:11
 */

public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }
}
