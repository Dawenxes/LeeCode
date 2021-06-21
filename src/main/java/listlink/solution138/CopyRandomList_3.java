package listlink.solution138;

import common.random.Node;

import java.util.HashMap;

public class CopyRandomList_3 {
    HashMap<Node, Node> randomNodeRandomNodeHashMap = new HashMap<>();

    // 递归
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        if (randomNodeRandomNodeHashMap.containsKey(head)) {
            return randomNodeRandomNodeHashMap.get(head);
        }
        Node node = new Node(head.val);
        randomNodeRandomNodeHashMap.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(node.random);
        return node;
    }

    // 递归
    public Node copyRandomList_1(Node head) {
        if (head == null) {
            return head;
        }
        Node t = head;
        while (head != null) {
            Node cloneNode = getCloneNode(head);
            cloneNode.next = getCloneNode(head.next);
            cloneNode.random = getCloneNode(head.random);
            head = head.next;
        }
        return getCloneNode(t);
    }

    private Node getCloneNode(Node head) {
        if(head==null){
            return head;
        }
        if (randomNodeRandomNodeHashMap.containsKey(head)) {
            return randomNodeRandomNodeHashMap.get(head);
        } else {
            Node node = new Node(head.val);
            randomNodeRandomNodeHashMap.put(head, node);
            return node;
        }
    }


}
