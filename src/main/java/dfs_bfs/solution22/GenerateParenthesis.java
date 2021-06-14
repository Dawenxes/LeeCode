package dfs_bfs.solution22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis {
    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    List<String> list = new ArrayList<String>();
    Queue<Node> queue = new LinkedList<Node>();

    public List<String> generateParenthesis(int n) {
        queue.add(new Node("", n, n));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left == 0 && node.right == 0) {
                list.add(node.res);
            }
            if (node.left > 0) {
                queue.add(new Node(node.res + "(", node.left - 1, node.right));
            }
            if (node.right > node.left) {
                queue.add(new Node(node.res + ")", node.left, node.right - 1));
            }
        }
        return list;
    }
}
