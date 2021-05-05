package solution70;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs_1 {
    public int climbStairs(int n) {
        Integer pre_pre = 1, pre = 2;
        int climb = 0;
        if (n == 1) {
            climb = pre_pre;
        } else if (n == 2) {
            climb = pre;
        }
        for (int i = 3; i <= n; i++) {
            climb = pre + pre_pre;
            pre_pre = pre;
            pre = climb;
        }
        return climb;
    }
}
