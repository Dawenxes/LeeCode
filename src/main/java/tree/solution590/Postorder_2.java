package tree.solution590;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.ntree.Node;

public class Postorder_2 {
	List<Integer> list = new ArrayList<>();
	LinkedList<Integer> list2 = new LinkedList<>();
	Deque<Node> stack = new LinkedList<>();

	public List<Integer> postorder_1(Node root) {
		if (root == null) {
			return list;
		}
		stack.push(root);
		Node pre = root;
		while (!stack.isEmpty()) {
			Node pop = stack.pop();
			list2.addFirst(pop.val);
			for (int i = 0; i < pop.children.size(); i++) {
				stack.push(pop.children.get(i));
			}
		}
		return list2;
	}

	private void visit(Node root) {
		list.add(root.val);
	}
}
