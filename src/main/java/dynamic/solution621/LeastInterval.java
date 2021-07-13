package dynamic.solution621;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。
 * 其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
 * 在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，
 * 或者在待命状态。  你需要计算完成所有任务所需要的 最短时间 。
 * @ClassName: LeastInterval
 * @Author: zbn
 * @Date: 2021/7/12 18:03
 */
public class LeastInterval {
    public static void main(String[] args) {
        LeastInterval leastInterval = new LeastInterval();
        System.out.println(leastInterval.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}
                , 2));
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            Pair p = map.getOrDefault(tasks[i], new Pair(1, 0));
            p.rest += 1;
            map.put(tasks[i], p);
        }
        int timer = 1;

        while (true) {
            int maxRest = 0;
            Character maxRestChar = null;
            for (Map.Entry<Character, Pair> characterPairEntry : map.entrySet()) {
                Pair pair = characterPairEntry.getValue();
                if (pair.nextTime <= timer && pair.rest > maxRest) {
                    maxRestChar = characterPairEntry.getKey();
                    maxRest = pair.rest;
                }
            }
            if (maxRestChar == null) {
                break;
            }

            Pair pair = map.get(maxRestChar);
            pair.nextTime = timer + n + 1;
            pair.rest -= 1;
            if (pair.rest == 0) {
                map.remove(maxRestChar);
            }

            // 重新设置timer
            boolean isDone = true;
            int tmpTimer = Integer.MAX_VALUE;
            for (Map.Entry<Character, Pair> characterPairEntry : map.entrySet()) {
                Pair pairTmp = characterPairEntry.getValue();
                tmpTimer = Math.min(tmpTimer, pairTmp.nextTime);
                if (pairTmp.rest > 0) {
                    isDone = false;
                }
            }
            if (isDone) {
                break;
            }
            timer = Math.max(tmpTimer, timer + 1);

        }
        return timer;
    }

    class Pair {
        Integer nextTime;
        Integer rest;

        public Pair(Integer nextTime, Integer rest) {
            this.nextTime = nextTime;
            this.rest = rest;
        }
    }
}
