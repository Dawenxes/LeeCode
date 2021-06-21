package greedy.solution455;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; j < s.length && i < g.length; i++, j++) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            if (j < s.length) {
                count++;
            }
        }
        return count;
    }
}
