package hot100;

/**
 * @Description 55. 跳跃游戏
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/17 17:43
 */
public class JumpGame {

  public boolean canJump(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length && max >= i; i++) {
      max = Math.max(max, i + nums[i]);
      if (max >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 1, 0, 4};
    boolean result = new JumpGame().canJump(nums);
    System.out.println(result);
  }
}
