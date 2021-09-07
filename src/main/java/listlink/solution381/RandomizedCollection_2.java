package listlink.solution381;

import java.util.*;

/**
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 */
public class RandomizedCollection_2 {

	private Map<Integer, Set<Integer>> idx;
	private List<Integer> nums;


	/**
	 * Initialize your data structure here.
	 */
	public RandomizedCollection_2() {
		idx = new HashMap<>();
		nums = new ArrayList<>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
	 */
	public boolean insert(int val) {
		nums.add(val);
		Set<Integer> set = idx.getOrDefault(val, new HashSet<>());
		set.add(nums.size() - 1);
		idx.put(val, set);
		return set.size() == 1;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection contained the specified element.
	 */
	public boolean remove(int val) {
		Set<Integer> set = idx.get(val);
		if (set == null || set.isEmpty()) {
			return false;
		}
		Iterator<Integer> iterator = set.iterator();
		Integer i = iterator.next();
		Integer last = nums.get(nums.size() - 1);
		// 顺序要注意
		nums.set(i, last);
		Set<Integer> setLast = idx.get(last);
		setLast.remove(nums.size() - 1);
		nums.remove(nums.size() - 1);
		// 这里要注意
		if (i < nums.size() - 1) {
			setLast.add(i);
		}
		set.remove(i);
		if (set.size() == 0) {
			idx.remove(val);
		}
		return true;
	}

	/**
	 * Get a random element from the collection.
	 */
	public int getRandom() {
		Random random = new Random();
		if (0 == nums.size() - 1) {
			return nums.get(0);
		} else {
			int i = random.nextInt(nums.size() - 1);
			return nums.get(i);
		}
	}
}
