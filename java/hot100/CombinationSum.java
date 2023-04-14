package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 39. 组合总和
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/14 15:31
 */
public class CombinationSum {

  // 深度优先搜索+回溯
  // 官方题解
  // https://leetcode.cn/problems/combination-sum/solution/zu-he-zong-he-by-leetcode-solution/
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> combine = new ArrayList<Integer>();
    dfs(candidates, target, ans, combine, 0);
    return ans;
  }


  public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine,
      int idx) {
    if (idx == candidates.length) {
      return;
    }
    if (target == 0) {
      ans.add(new ArrayList<>(combine));
      return;
    }
    // 跳过
    dfs(candidates, target, ans, combine, idx + 1);
    // 使用当前数
    if (target - candidates[idx] >= 0) {
      combine.add(candidates[idx]);
      dfs(candidates, target - candidates[idx], ans, combine, idx);
      combine.remove(combine.size() - 1);
    }
  }

  // dfs+回溯
  // https://leetcode.cn/problems/combination-sum/solution/shou-hua-tu-jie-zu-he-zong-he-combination-sum-by-x/
  public List<List<Integer>> combinationSum1(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> combine = new ArrayList<Integer>();
    dfs1(0, combine, 0, target, candidates, ans);
    return ans;
  }


  //当前组合和之前生成的组合重复了。
  //△：当前求和 > target，不能选下去了，返回。
  //○：求和正好 == target，加入解集，并返回。
  public void dfs1(int start, List<Integer> combine, int sum, int target, int[] candidates,
      List<List<Integer>> ans) {
    if (sum > target) {
      return;
    }
    if (sum == target) {
      ans.add(new ArrayList<>(combine));
      return;
    }

    for (; start < candidates.length; start++) {
      combine.add(candidates[start]);
      dfs1(start, combine, sum + candidates[start], target, candidates, ans);
      combine.remove(combine.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] candidates = new int[]{2, 3, 6, 7};
    List<List<Integer>> ans = new CombinationSum().combinationSum1(candidates, 7);
    System.out.println(ans);
  }
}
