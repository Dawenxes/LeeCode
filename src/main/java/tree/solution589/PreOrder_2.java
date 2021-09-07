package tree.solution589;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.ntree.Node;

public class PreOrder_2 {

	List<Integer> list = new ArrayList<>();
	Deque<Node> stack = new LinkedList<>();

	public List<Integer> preorder(Node root) {
		if (root == null) {
			return list;
		}
		stack.push(root);
		while (!stack.isEmpty()) {
			Node pop = stack.pop();
			visit(pop);
			for (int i = pop.children.size() - 1; i >= 0; i--) {
				//
				stack.push(pop.children.get(i));
			}
		}
		return list;
	}

	private void visit(Node root) {
		list.add(root.val);
	}
}
