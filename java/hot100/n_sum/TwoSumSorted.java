package hot100.n_sum;

import java.util.Arrays;

/**
 * @Description 167. 两数之和 II - 输入有序数组
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/24 21:05
 */
public class TwoSumSorted {

  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      if (numbers[left] + numbers[right] == target) {
        return new int[]{left + 1, right + 1};
      } else if (numbers[left] + numbers[right] > target) {
        right--;
      } else {
        left++;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] numbers = new int[]{2, 7, 11, 15};
    int[] result = new TwoSumSorted().twoSum(numbers, 9);
    System.out.println(Arrays.toString(result));
  }
}
