package contest.week250.solution5814;

/**
 * @Description: 新增的最少台阶数
 * @ClassName: AddRungs
 * @Author: zbn
 * @Date: 2021/7/18 11:47
 */

public class AddRungs {
    public int addRungs(int[] rungs, int dist) {
        int ans = 0;
        for (int i = -1; i < rungs.length - 1; i++) {
            if (i == -1 && 0 + dist < rungs[i + 1]) {
                ans += Math.ceil(((double)(rungs[i + 1] - dist)) / dist);
            } else if (i != -1 && rungs[i] + dist < rungs[i + 1]) {
                ans += Math.ceil(((double)(rungs[i + 1] - rungs[i] - dist)) / dist);
            }
        }
        return ans;
    }
}
