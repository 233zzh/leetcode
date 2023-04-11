package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description 无重复字符的最长字串
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/10 18:03
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    int fastPointer = 0;
    int slowPointer = 0;
    int result = 0;
    Set<Character> set = new HashSet<Character>();
    Map<Character, Integer> map = new HashMap<>();
    while (fastPointer < s.length()) {
      char element = s.charAt(fastPointer);
      if (set.contains(element)) {
        result = Math.max(result, set.size());
        int temp = map.get(element);
        while (temp >= slowPointer) {
          set.remove(s.charAt(temp));
          temp--;
        }
        slowPointer = map.get(element) + 1;
      }
      set.add(element);
      map.put(element, fastPointer);
      fastPointer++;
    }

    System.out.println(set);
    //"abcde"这种情况
    return Math.max(result, set.size());
  }

  public static void main(String[] args) {
    String s = "abcabcbb";
    int number = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
    System.out.println(number);

    s = "bbbbb";
    number = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
    System.out.println(number);

    s = "pwwkew";
    number = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
    System.out.println(number);

    s = "acdvedf";
    number = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
    System.out.println(number);

    s = "aabaab!bb";
    number = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
    System.out.println(number);

    s = "bpfbhmipx";
    number = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
    System.out.println(number);
  }
}
