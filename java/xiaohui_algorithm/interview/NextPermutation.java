package xiaohui_algorithm.interview;

import java.util.Arrays;

/**
 * @Description 小灰漫画算法-寻找全排列的下一个数
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/8 16:31
 */
public class NextPermutation {

  // 字典序算法
  // 1.从右往左找到逆序区域，即找到第一个大于前面元素的位置，idx位置，idx位置的元素大于idx-1位置的元素
  // 2.位置idx-1位置的元素和>=idx中的较小的元素交换
  // 3.对逆序区域（>=idx）进行排序
  // 12345->12354   12354->12453->12435
  public static void getNextPermutation(int[] nums) {
    //1. 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
    int idx = findTransferPoint(nums);
    // 54321，没有比他还大的排列了
    if (idx == -1) {
      return;
    }

    //2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
    exchange(nums, idx);

    //3.把原来的逆序区域转为顺序
    reverse(nums, idx);
  }


  private static int findTransferPoint(int[] nums) {
    int idx = -1;
    for (int i = nums.length - 1; i > 0; i--) {
      if (nums[i] > nums[i - 1]) {
        idx = i;
        break;
      }
    }
    return idx;
  }

  private static void exchange(int[] nums, int idx) {
    for (int i = nums.length - 1; i >= idx; i--) {
      if (nums[idx - 1] < nums[i]) {
        int temp = nums[idx - 1];
        nums[idx - 1] = nums[i];
        nums[i] = temp;
        break;
      }
    }
  }

  private static void reverse(int[] nums, int idx) {
    for (int i = idx, j = nums.length - 1; i < j; i++, j--) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 5, 4};
    getNextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{1, 2, 3, 4, 5};
    getNextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }
}
