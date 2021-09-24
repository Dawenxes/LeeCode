package recursion.solution78;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Subsets_1 {
	List<List<Integer>> result = new ArrayList<>();
	Deque<Integer> stack = new LinkedList<>();

	public List<List<Integer>> subsets(int[] nums) {
		// 递归
		_subsets(nums, 0);
		return result;
	}

	private void _subsets(int[] nums, int k) {
		if (k == nums.length) {
			result.add(new ArrayList<>(stack));
			return;
		}
		_subsets(nums, k + 1);
		stack.push(nums[k]);
		_subsets(nums, k + 1);
		stack.pop();
	}
}
