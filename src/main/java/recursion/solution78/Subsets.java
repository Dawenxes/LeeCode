package recursion.solution78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    // 递归

    _subsets(nums, new LinkedList<Integer>(), 0);

    return result;
  }

  private void _subsets(int[] nums, LinkedList<Integer> list, int k) {
    if (k == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }

    // 没选
    _subsets(nums, list,  k+1);
    // 选了
      list.add(nums[k]);
    _subsets(nums, list, k + 1);
    list.removeLast();
  }
}
