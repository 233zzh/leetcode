package hot100;

import java.util.Arrays;

/**
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/14 11:43
 */
public class FindFirstAndLastInSortedArray {

  // 时间复杂度 O(n), 空间复杂度 O(1)
  public int[] searchRange(int[] nums, int target) {
    int first = -1;
    int last = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        if (first == -1) {
          first = i;
        } else {
          last = i;
        }
      }
    }
    return new int[]{first, last};
  }


  // 时间复杂度 O(log n), 空间复杂度 O(1)
  public int[] searchRange1(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int first = 99999999;
    int last = -1;
    while (left <= right) {
      if (nums[left] == target) {
        first = Math.min(first, left);
        last = Math.max(last, left);
      }
      if (nums[right] == target) {
        first = Math.min(first, right);
        last = Math.max(last, right);
      }
      int middle = (left + right) / 2;
      if (nums[middle] == target) {
        first = Math.min(first, middle);
        last = Math.max(last, middle);
        left++; // or right-- [1,2,3,3,3,3,4,5,9]
      } else if (nums[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    if (first == 99999999) {
      first = -1;
    }
    return new int[]{first, last};
  }

  // 两次二分查找，分开查找第一个和最后一个
  // 时间复杂度 O(log n), 空间复杂度 O(1)
  // [1,2,3,3,3,3,4,5,9]
  public int[] searchRange2(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int first = -1;
    int last = -1;
    // 找第一个等于target的位置
    while (left <= right) {
      int middle = (left + right) / 2;
      if (nums[middle] == target) {
        first = middle;
        right = middle - 1; //重点
      } else if (nums[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    // 最后一个等于target的位置
    left = 0;
    right = nums.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      if (nums[middle] == target) {
        last = middle;
        left = middle + 1; //重点
      } else if (nums[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return new int[]{first, last};
  }

  public static void main(String[] args) {
    int[] nums = new int[]{5, 7, 7, 8, 8, 10};
    int[] result = new FindFirstAndLastInSortedArray().searchRange2(nums, 8);
    System.out.println(Arrays.toString(result));

    nums = new int[]{5, 7, 7, 8, 8, 10};
    result = new FindFirstAndLastInSortedArray().searchRange2(nums, 6);
    System.out.println(Arrays.toString(result));

    nums = new int[0];
    result = new FindFirstAndLastInSortedArray().searchRange2(nums, 0);
    System.out.println(Arrays.toString(result));

    nums = new int[]{1};
    result = new FindFirstAndLastInSortedArray().searchRange2(nums, 1);
    System.out.println(Arrays.toString(result));

    nums = new int[]{5, 7, 7, 8, 8, 10};
    result = new FindFirstAndLastInSortedArray().searchRange2(nums, 8);
    System.out.println(Arrays.toString(result));
  }
}
