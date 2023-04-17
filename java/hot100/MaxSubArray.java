package hot100;

/**
 * @Description 53. 最大子数组和
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/17 16:29
 */
public class MaxSubArray {

  // 动态规划
  // f(i) 以第i个数结尾的「连续子数组的最大和」
  // f(i)=max{f(i-1)+nums[i], nums[i]}
  // 考虑到f(i)只和f(i-1)相关，于是只用一个pre变量来维护f(i-1)
  public int maxSubArray(int[] nums) {
    int pre = 0;
    int max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      pre = Math.max(pre + nums[i], nums[i]);
      max = Math.max(pre, max);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int max = new MaxSubArray().maxSubArray(nums);
    System.out.println(max);
  }
}
