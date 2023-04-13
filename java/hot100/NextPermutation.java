package hot100;

import java.util.Arrays;

/**
 * @Description 31.下一个排列
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/13 17:27
 */
public class NextPermutation {

  public void nextPermutation(int[] nums) {
    int left = 0;//较小的，靠右的
    int right = 0;//较大的中最小的
    for (int i = 0; i < nums.length; i++) {
      boolean flag = false;
      int min = 999;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] > nums[i]) {
          if (min > nums[j]) {
            left = i;
            right = j;
            min = nums[j];
          }
        }
      }
    }
    if (right == 0) {
      bubbleSort(nums, -1);
    } else {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      bubbleSort(nums, left);
    }
  }


  private void bubbleSort(int[] nums, int left) {
    for (int i = left + 1; i < nums.length; i++) {
      for (int j = left + 1; j < nums.length - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{4, 5, 2, 6, 3, 1};
    new NextPermutation().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{1, 2, 3};
    new NextPermutation().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{3, 2, 1};
    new NextPermutation().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{1, 1, 5};
    new NextPermutation().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

  }
}
