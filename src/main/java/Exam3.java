/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2021. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

// 电商购物发货系统，ORDER=customerId:goods表示一个消费者customerId定   购了一些商品goods[]，
// 可以重复订购同一件商品，DELIVER=goods 表示商户已发货商品goods[]，
// 经过一些列操作，输出含有最多商品未发货的消费者custtomerId，如果有相同取值小的customerId，如果不存在未发货返回-1，
// 如果有相同商品发货优先发货先订购的
//    案例：
//    输入：
//    5
//    ORDER=90:1 3 6 8
//    ORDER=80:5 7
//    DELIVER=3 5
//    ORDER=70:10
//    DELIVER=6 7
//    输出
//    90

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Exam3 {
  static class OrderSystem {
    Map<Integer, LinkedList<OrderUnit>> mapGood = new HashMap<>();
    OrderUnit head = new OrderUnit(-1, -1);
    OrderUnit tail = new OrderUnit(-1, -1);
    // customerId/nums
    Map<Integer, Integer> map = new HashMap<>();

    // 待实现函数，请在此填入答题代码
    OrderSystem() {
      head.pre = null;
      head.next = tail;
      tail.pre = head;
      tail.next = null;
    }

    private void addLast(OrderUnit orderUnit) {
      orderUnit.pre = tail.pre;
      tail.pre.next = orderUnit;
      orderUnit.next = tail;
      tail.pre = orderUnit;
      LinkedList<OrderUnit> linkedList =
          mapGood.getOrDefault(orderUnit.getGoodsId(), new LinkedList<OrderUnit>());
      linkedList.addLast(orderUnit);
      mapGood.put(orderUnit.getGoodsId(), linkedList);
    }

    private OrderUnit remove(int goodId) {
      LinkedList<OrderUnit> orderUnits = mapGood.get(goodId);
      OrderUnit orderUnit = orderUnits.removeFirst();
      // 商品出队
      orderUnit.next.pre = orderUnit.pre;
      orderUnit.pre.next = orderUnit.next;
      orderUnit.next = null;
      orderUnit.pre = null;
      // 统计值减一
      map.compute(orderUnit.getCustomerId(), (k, v) -> v - 1);

      return orderUnit;
    }
    //
    void order(int customerId, int[] goods) {
      map.put(customerId, map.getOrDefault(customerId, 0) + goods.length);
      for (int good : goods) {
        addLast(new OrderUnit(customerId, good));
      }
    }

    // 待实现函数，请在此填入答题代码
    void deliver(int[] goods) {
      for (int good : goods) {
        remove(good);
      }
    }

    int query() {
      if (isEmpty()) {
        return -1;
      }
      // 用于简单计数
      return map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }

    private boolean isEmpty() {
      return head.next.getCustomerId() == -1;
    }
  }

  // 定义模型对象
  static class OrderUnit {
    int customerId;
    int goodsId;

    OrderUnit pre;
    OrderUnit next;

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

    /**
     * Gets the value of pre
     *
     * @return the value of pre
     */
    public OrderUnit getPre() {
      return pre;
    }

    /**
     * Sets the pre
     *
     * <p>You can use getPre() to get the value of pre
     *
     * @param pre pre
     */
    public void setPre(OrderUnit pre) {
      this.pre = pre;
    }

    /**
     * Gets the value of next
     *
     * @return the value of next
     */
    public OrderUnit getNext() {
      return next;
    }

    /**
     * Sets the next
     *
     * <p>You can use getNext() to get the value of next
     *
     * @param next next
     */
    public void setNext(OrderUnit next) {
      this.next = next;
    }
  }
  // 待实现函数，请在此填入答题代码

  /** main入口由OJ平台调用 */
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
        int[] goods =
            Arrays.stream(command[i][1].split("\\s+")).mapToInt(Integer::parseInt).toArray();
        orderSystem.deliver(goods);
      }
    }
    cin.close();
    int result = orderSystem.query();
    System.out.println(result);
  }
}
