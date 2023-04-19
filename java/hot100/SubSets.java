package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 78. 子集
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/18 17:42
 */
public class SubSets {

  // dfs+回溯
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

  // 枚举
  // 逐个枚举，空集的子集只有空集，每增加一个元素，让之前子集中的每个集合，复制一份，追加这个元素，就是新增的子集。
  public List<List<Integer>> subsets1(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    // 空集
    List<Integer> list = new ArrayList<>();
    ans.add(list);
    for (int num : nums) {
      List<List<Integer>> newAns = new ArrayList<>();
      for (List<Integer> oldSubSet : ans) {
        List<Integer> newSubset = new ArrayList<>(oldSubSet);
        newSubset.add(num);
        newAns.add(newSubset);
      }
      ans.addAll(newAns);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    List<List<Integer>> ans = new SubSets().subsets1(nums);
    System.out.println(ans);
  }
}
