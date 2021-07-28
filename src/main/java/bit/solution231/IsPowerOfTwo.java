package bit.solution231;

/**
 * @Description: 2 的幂
 * @ClassName: IsPowerOfTwo
 * @Author: zbn
 * @Date: 2021/7/28 22:38
 */

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
