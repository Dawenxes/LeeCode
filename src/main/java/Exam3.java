/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2021. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */


// 电商购物发货系统，ORDER=customerId:goods表示一个消费者customerId定   购了一些商品goods[]，
// 可以重复订购同一件商品，DELIVER=goods 表示商户已发货商品goods[]，
// 经过一些列操作，输出含有最多商品未发货的消费者custtomerId，如果有相同取值小的customerId，如果不存在未发货返回-1，
// 如果有相同商品发货优先发货先订购的
//    案例：
//    5
//    ORDER=90:1 3 6 8
//    ORDER=80:5 7
//    DELIVER=3 5
//    ORDER=70:10
//    DELIVER=6 7
//    输出
//    90

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Exam3 {
    static class OrderSystem {
        LinkedList<OrderUnit> orderUnitDeque;
        //customerId/nums
        Map<Integer, Integer> map = new HashMap<>();

        // 待实现函数，请在此填入答题代码
        OrderSystem() {
            orderUnitDeque = new LinkedList<>();
        }

        //
        void order(int customerId, int[] goods) {
            map.put(customerId, map.getOrDefault(customerId, 0) + goods.length);
            for (int good : goods) {
                orderUnitDeque.addLast(new OrderUnit(customerId, good));
            }
        }

        //
        private void taskBack(Stack<OrderUnit> stack, Deque<OrderUnit> orderUnitDeque) {
            while (!stack.isEmpty()) {
                orderUnitDeque.addFirst(stack.pop());
            }
        }

        // 待实现函数，请在此填入答题代码
        void deliver(int[] goods) {
            Stack<OrderUnit> stack = new Stack<>();
            for (int good : goods) {
                Iterator<OrderUnit> iterator = orderUnitDeque.iterator();
                while (iterator.hasNext()) {
                    OrderUnit next = iterator.next();
                    if (next.getGoodsId() == good) {
                        map.compute(next.getCustomerId(), (k, v) -> v - 1);
                        iterator.remove();
                        break;
                    }
                }
            }
        }

        int query() {
            if (orderUnitDeque.isEmpty()) {
                return -1;
            }
            // 用于简单计数
            return map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
        }

    }


    //定义模型对象
    static class OrderUnit {
        int customerId;
        int goodsId;

        OrderUnit(int customerId, int goodsId) {
            this.customerId = customerId;
            this.goodsId = goodsId;
        }

        public int getCustomerId() {
            return customerId;
        }

        public int getGoodsId() {
            return goodsId;
        }
    }
    // 待实现函数，请在此填入答题代码

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        OrderSystem orderSystem = new OrderSystem();
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int num = Integer.parseInt(cin.nextLine());
        String[][] command = new String[num][2];
        for (int i = 0; i < num; i++) {
            command[i] = cin.nextLine().split("=");
            if (command[i][0].startsWith("ORDER")) {
                String[] info = command[i][1].split(":");
                int customerId = Integer.parseInt(info[0]);
                int[] goods = Arrays.stream(info[1].split("\\s+")).mapToInt(Integer::parseInt).toArray();
                orderSystem.order(customerId, goods);
            } else if (command[i][0].startsWith("DELIVER")) {
                int[] goods = Arrays.stream(command[i][1].split("\\s+")).mapToInt(Integer::parseInt).toArray();
                orderSystem.deliver(goods);
            }
        }
        cin.close();
        int result = orderSystem.query();
        System.out.println(result);
    }
}
