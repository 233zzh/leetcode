package offer.lingxing;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/24 21:41
 */
public class Third {
  // 冒泡排序
  public static void sort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; j < nums.length - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    };
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 1, 4, 5, 3};
    sort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
