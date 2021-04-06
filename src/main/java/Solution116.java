import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *填充每个节点的下一个右侧节点指针
 */
public class Solution116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        root.next = null;
        Node leftMax = root;
        while (leftMax.left != null) {
            Node rightMax = leftMax;
            while (rightMax.next != null) {
                rightMax.left.next = rightMax.right;
                if (rightMax.next != null) {
                    rightMax.right.next = rightMax.next.left;
                }
                rightMax = rightMax.next;
            }
            leftMax = leftMax.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution116 solution75 = new Solution116();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6= new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        Node connect = solution75.connect(node1);

        System.out.println(connect);

    }
}
