package top_interview_150;

import java.util.Arrays;

/**
 * @Description 27. 移除元素
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/5 12:22
 */
public class RemoveElement {

  // 左右两端双指针
  public int removeElement(int[] nums, int val) {
    if (nums.length == 0) {
      return 0;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      while (left < right && nums[left] != val) {
        left++;
      }
      while (left < right && nums[right] == val) {
        right--;
      }
      if (left < right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
      }
    }
    if (nums[left] == val) {
      return left;
    } else {
      return left + 1;
    }
  }


  // 快慢指针
  // 官方题解
  // https://leetcode.cn/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode-solution-svxi/
  public int removeElement1(int[] nums, int val) {
    int slow = 0;
    for (int fast = 0; fast < nums.length; fast++) {
      if (nums[fast] != val) {
        if (slow != fast) {
          nums[slow] = nums[fast];
        }
        slow++;
      }
    }
    return slow;
  }

  // 左右两端双指针
  // 官方题解
  // https://leetcode.cn/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode-solution-svxi/
  public int removeElement2(int[] nums, int val) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      if (nums[left] == val) {
        nums[left] = nums[right];
        right--;
      } else {
        left++;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 2, 3};
    int result = new RemoveElement().removeElement2(nums, 3);
    System.out.println(result);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{3, 3};
    result = new RemoveElement().removeElement2(nums, 3);
    System.out.println(result);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{3, 3};
    result = new RemoveElement().removeElement2(nums, 5);
    System.out.println(result);
    System.out.println(Arrays.toString(nums));
  }
}
