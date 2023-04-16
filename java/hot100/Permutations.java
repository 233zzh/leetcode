package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/14 17:24
 */
public class Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    for (int num : nums) {
      List<Integer> temp = new ArrayList<>();
      temp.add(num);
      dfs(temp, nums, ans);
    }
    return ans;
  }

  public void dfs(List<Integer> list, int[] nums, List<List<Integer>> ans) {
    if (list.size() == nums.length) {
      ans.add(list);
      return;
    }
    for (int num : nums) {
      if (!list.contains(num)) {
        List<Integer> newList = new ArrayList<>(list);
        newList.add(num);
        dfs(newList, nums, ans);
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    List<List<Integer>> ans = new Permutations().permute(nums);
    System.out.println(ans);
  }
}
