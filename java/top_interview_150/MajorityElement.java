package top_interview_150;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 169. 多数元素
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/9 16:18
 */
public class MajorityElement {


  public int majorityElement(int[] nums) {

    Map<Integer, Integer> map = new HashMap<>();
    int max = -1;
    int maxElement = -1;
    for (int num : nums) {
      int count = map.getOrDefault(num, 0) + 1;
      if (count > max) {
        max = count;
        maxElement = num;
      }
      map.put(num, count);
    }
    return maxElement;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 3};
    int result = new MajorityElement().majorityElement(nums);
    System.out.println(result);

    nums = new int[]{2, 2, 1, 1, 1, 2, 2};
    result = new MajorityElement().majorityElement(nums);
    System.out.println(result);
  }
}
