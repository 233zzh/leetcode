package top_interview_150;

import java.util.Arrays;

/**
 * @Description 26. 删除有序数组中的重复项
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/9 15:22
 */
public class RemoveDuplicates {

  // 双指针
  public int removeDuplicates(int[] nums) {
    if (nums.length==1){
      return 1;
    }
    int i = 0;
    int j = 0;
    while (i < nums.length-1 && j < nums.length) {
      if (nums[i] >= nums[i + 1]) {
        while (j < nums.length) {
          if (nums[j] > nums[i]) {
            nums[i + 1] = nums[j];
            i++;
          }
          j++;
        }
      } else {
        i++;
      }
    }
    return i+1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 3, 3, 4, 5, 6, 6, 7, 8, 8, 8};
    int result = new RemoveDuplicates().removeDuplicates(nums);
    System.out.println(result);
    System.out.println(Arrays.toString(nums));
  }

}
