package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 1. 两数之和
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/10 15:57
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(target - nums[i])) {
        map.put(nums[i], i);
      } else {
        return new int[]{i, map.get(target - nums[i])};
      }
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 7, 11, 15};
    int target = 9;
    int[] result = new TwoSum().twoSum(nums, target);
    System.out.println(Arrays.toString(result));

    nums = new int[]{3, 2, 4};
    target = 6;
    result = new TwoSum().twoSum(nums, target);
    System.out.println(Arrays.toString(result));

    nums = new int[]{3, 3};
    target = 6;
    result = new TwoSum().twoSum(nums, target);
    System.out.println(Arrays.toString(result));
  }

}



