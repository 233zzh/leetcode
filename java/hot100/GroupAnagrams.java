package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/17 14:55
 */
public class GroupAnagrams {

  // 超时
  public List<List<String>> groupAnagrams(String[] strs) {

    List<List<String>> ans = new ArrayList<>();
    for (String str : strs) {
      boolean flag = false;
      for (List<String> list : ans) {
        char[] chars = list.get(0).toCharArray();
        Arrays.sort(chars);
        String string = new String(chars);

        char[] chars1 = str.toCharArray();
        Arrays.sort(chars1);
        String string1 = new String(chars1);
        if (string.equals(string1)) {
          list.add(str);
          flag = true;
          break;
        }
      }
      if (!flag) {
        List<String> list1 = new ArrayList<>();
        list1.add(str);
        ans.add(list1);
      }
    }
    return ans;
  }

  // 先排序，利用hashMap，哈希表的值为一组字母异位词列表的索引。
  public List<List<String>> groupAnagrams1(String[] strs) {
    List<List<String>> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sortStr = new String(chars);
      if (!map.containsKey(sortStr)) {
        List<String> list = new ArrayList<>();
        list.add(str);
        ans.add(list);
        map.put(sortStr, ans.size() - 1);
      } else {
        List<String> list = ans.get(map.get(sortStr));
        list.add(str);
      }
    }
    return ans;
  }


  public static void main(String[] args) {
    String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> ans = new GroupAnagrams().groupAnagrams1(strs);
    System.out.println(ans);
  }
}
