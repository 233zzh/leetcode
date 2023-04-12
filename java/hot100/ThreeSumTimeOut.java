package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description 15. 三数之和，超时了，写了一坨狗屎
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/12 14:49
 */
public class ThreeSumTimeOut {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Set<String> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      List<List<Integer>> two = twoSum(nums, -nums[i], i);
      if (two.size() != 0) {
        for (List<Integer> list : two) {
          int[] aaa = new int[]{nums[i], list.get(0), list.get(1)};
          Arrays.sort(aaa);
          StringBuilder index = new StringBuilder();
          for (int j : aaa) {
            index.append(j);
          }
          if (!set.contains(index.toString())) {
            List<Integer> twmp = new ArrayList<>();
            twmp.add(nums[i]);
            twmp.add(list.get(0));
            twmp.add(list.get(1));
            result.add(twmp);
            set.add(index.toString());
          }
        }
      }

    }
    return result;
  }


  private List<List<Integer>> twoSum(int[] nums, int target, int index) {
    Map<Integer, Integer> map = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (i != index) {
        if (!map.containsKey(target - nums[i])) {
          map.put(nums[i], i);
        } else {
          List<Integer> list = new ArrayList<>();
          list.add(target - nums[i]);
          list.add(nums[i]);
          result.add(list);
        }
      }
    }
//    System.out.println(map);
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> result = new ThreeSumTimeOut().threeSum(nums);
    System.out.println(result);

    nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
    result = new ThreeSumTimeOut().threeSum(nums);
    System.out.println(result);
  }
}
