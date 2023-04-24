package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 15.三数之和
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/12 16:15
 */
public class ThreeSum {

  // 官方题解
  // https://leetcode.cn/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
  // 排序 + 双指针
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 0; i < len - 2; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        int k = len - 1;
        for (int j = i + 1; j < len - 1; j++) {
          if (j == i + 1 || nums[j] != nums[j - 1]) {
            while (k > j && nums[i] + nums[j] + nums[k] > 0) {
              k--;
            }
            if (nums[i] + nums[j] + nums[k] == 0 && k != j) {
              ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
            }
            if (k == j) {
              break;
            }
          }
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> ans = new ThreeSum().threeSum(nums);
    System.out.println(ans);

    nums = new int[]{0, 0, 0};
    ans = new ThreeSum().threeSum(nums);
    System.out.println(ans);

    nums = new int[]{3, -2, 1,0};
    ans = new ThreeSum().threeSum(nums);
    System.out.println(ans);
  }
}
