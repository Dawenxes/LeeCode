package recursion.solution78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_2 {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		_subsets(nums, new LinkedList<>(), 0);
		return result;
	}

	private void _subsets(int[] nums, LinkedList<Integer> list, int k) {
		if (k == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		// δΈι
		_subsets(nums, new LinkedList<>(list), k + 1);
		// ι
		list.add(nums[k]);
		_subsets(nums, new LinkedList<>(list), k + 1);
		list.pollLast();
	}
}
