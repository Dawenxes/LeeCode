import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 */
public class RandomizedCollection {

    private Map<Integer, Set<Integer>> idx;
    private List<Integer> nums;


    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        idx = new HashMap<>();
        nums = new ArrayList<>();
        
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> valLocation = idx.getOrDefault(val, new HashSet<>());
        valLocation.add(nums.size() - 1);
        idx.put(val, valLocation);
        return valLocation.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Set<Integer> locations = idx.get(val);
        Iterator<Integer> iterator = locations.iterator();
        Integer removeNumLocation = iterator.next();
        Integer last = nums.get(nums.size() - 1);
        nums.set(removeNumLocation, last);
        locations.remove(removeNumLocation);
        idx.get(last).remove(nums.size() - 1);

        // 这个是为了处理最后一个元素
        if (removeNumLocation < nums.size() - 1) {
            idx.get(last).add(removeNumLocation);

        }

        if (locations.size() == 0) {
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
