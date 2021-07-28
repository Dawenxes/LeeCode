package bit.solution190;

/**
 * @Description: 颠倒二进制位
 * @ClassName: ReverseBits
 * @Author: zbn
 * @Date: 2021/7/28 22:40
 */

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int k = n & 1;
            n >>= 1;
            ans <<= 1;
            ans |= k;
        }
        return ans;
    }
}
