package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 75. 颜色分类
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/18 10:25
 */
public class SortColors {

  // 冒泡排序
  // O(n2)  O(1)
  public void sortColors(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; j < nums.length - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }

  }

  // 利用哈希表统计0、1、2的个数，然后根据他们的个数，重写整个数组
  // O(n) O(1)
  public void sortColors1(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int i = 0;
    int count = map.getOrDefault(0, 0);
    while (count-- > 0) {
      nums[i++] = 0;
    }
    count = map.getOrDefault(1, 0);
    while (count-- > 0) {
      nums[i++] = 1;
    }
    count = map.getOrDefault(2, 0);
    while (count-- > 0) {
      nums[i++] = 2;
    }
  }

  // 官方题解 https://leetcode.cn/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
  // 单指针
  // O(n) O(1)
  public void sortColors2(int[] nums) {
    int pointer = 0; // 从0到pointer-1，都是0
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        int temp = nums[i];
        nums[i] = nums[pointer];
        nums[pointer] = temp;
        pointer++;
      }
    }

    for (int i = pointer; i < nums.length; i++) {
      if (nums[i] == 1) {
        int temp = nums[i];
        nums[i] = nums[pointer];
        nums[pointer] = temp;
        pointer++;
      }
    }
  }

  // 官方题解 https://leetcode.cn/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
  // 双指针
  // O(n) O(1)
  // p0从0到p0-1，都是0, p1表示从p0到p1-1，都是1
  // 表示推导[2, 0, 2, 1, 1, 0],得知
  // 1、p0移动时p1也要移动，因为连续的1肯定在连续的0后面    目标值是0时，
  // 2、p1移动，p0不动                                目标值是1时，
  // 3、p0<p1时，先交换0，p0++,然后交换1，p1++           目标值是0时，
  public void sortColors3(int[] nums) {
    int ptr0 = 0; // 从0到ptr0-1，都是0
    int ptr1 = 0; // 从ptr0到ptr1-1，都是1
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        if (ptr0 < ptr1) {
          int temp = nums[i];
          nums[i] = nums[ptr0];
          nums[ptr0] = temp;
          ptr0++;

          temp = nums[i];
          nums[i] = nums[ptr1];
          nums[ptr1] = temp;
          ptr1++;
        } else {
          int temp = nums[i];
          nums[i] = nums[ptr0];
          nums[ptr0] = temp;
          ptr0++;
          ptr1++;
        }
      } else if (nums[i] == 1) {
        int temp = nums[i];
        nums[i] = nums[ptr1];
        nums[ptr1] = temp;
        ptr1++;
      }
    }
  }


  // 官方题解 https://leetcode.cn/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
  // 双指针
  // O(n) O(1)
  public void sortColors4(int[] nums) {
    int ptr0 = 0; // 从0到ptr0-1，都是0
    int ptr2 = nums.length - 1; // 从ptr2+1到length-1，都是2
    for (int i = 0; i < nums.length && i <= ptr2; i++) {
      while (nums[i] == 2 && i <= ptr2) {
        int temp = nums[ptr2];
        nums[ptr2] = nums[i];
        nums[i] = temp;
        ptr2--;
      }
      if (nums[i] == 0) {
        int temp = nums[i];
        nums[i] = nums[ptr0];
        nums[ptr0] = temp;
        ptr0++;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 0, 2, 1, 1, 0};
    new SortColors().sortColors4(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{2, 1, 2};
    new SortColors().sortColors4(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{2, 1, 2, 2, 2, 0, 0, 0, 2};
    new SortColors().sortColors4(nums);
    System.out.println(Arrays.toString(nums));

  }
}
