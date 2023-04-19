package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/18 17:42
 */
public class SubSets {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    dfs(nums, ans, list, 0);
    return ans;
  }

  public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
    List<Integer> temp = new ArrayList<>(list);
    ans.add(temp);
    while (index < nums.length) {
      list.add(nums[index]);
      dfs(nums, ans, list, index + 1);
      list.remove(list.size() - 1);
      index++;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    List<List<Integer>> ans = new SubSets().subsets(nums);
    System.out.println(ans);
  }
}
