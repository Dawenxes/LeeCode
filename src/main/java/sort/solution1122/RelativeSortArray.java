package sort.solution1122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            int count = map.get(arr2[i]);
            for (int j = 0; j < count; j++) {
                arr1[k++] = arr2[i];
            }
            map.remove(arr2[i]);
        }
        Set<Integer> rest = map.keySet();
        int[] restInt = new int[rest.size()];
        int m = 0;
        for (Integer integer : rest) {
            restInt[m++] = integer;
        }
        Arrays.sort(restInt);
        for (int i : restInt) {
            int count = map.get(i);
            for (int j = 0; j < count; j++) {
                arr1[k++] = i;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        System.out.println(Arrays.toString(relativeSortArray.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
