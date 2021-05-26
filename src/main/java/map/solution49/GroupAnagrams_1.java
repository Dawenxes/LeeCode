package map.solution49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_1 {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      int[] counts = new int[26];
      for (int i = 0; i < chars.length; i++) {
        counts[chars[i] - 'a']++;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        if (counts[i] != 0) {
          sb.append((char) ('a' + i));
          sb.append(counts[i]);
        }
      }
      String key = sb.toString();
      List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
      orDefault.add(str);
      map.put(key, orDefault);
    }
    return new ArrayList<List<String>>(map.values());
  }

  public static void main(String[] args) {
    String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
    new GroupAnagrams_1().groupAnagrams(str);
  }
}
