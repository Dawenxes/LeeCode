package dfs_bfs.solution22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis_1 {
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
        queue.add(new Node("", 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left < n) {
                queue.add(new Node(node.res + "(", node.left + 1, node.right));
            }
            if (node.right < node.left) {
                queue.add(new Node(node.res + ")", node.left, node.right + 1));
            }
            if (node.left == n && node.right == n) {
                list.add(node.res);
            }
        }
        return list;
    }
}
