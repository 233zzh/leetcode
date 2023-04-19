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

  // 动态规划，每一次都用到之前的所有状态
  // 逐个枚举序列中的每个数字，空集的子集只有空集，每增加一个元素，让之前子集中的每个集合，复制一份，追加这个元素，就是新增的子集。
  public List<List<Integer>> subsets1(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    // 空集
    List<Integer> list = new ArrayList<>();
    ans.add(list);
    for (int num : nums) {
      int len = ans.size();
      for (int i = 0; i < len; i++) {
        List<Integer> oldSubSet = ans.get(i);
        List<Integer> newSubset = new ArrayList<>(oldSubSet);
        newSubset.add(num);
        ans.add(newSubset);
      }
    }
    return ans;
  }

  // 迭代法实现子集枚举
  // 官方题解
  // https://leetcode.cn/problems/subsets/solution/zi-ji-by-leetcode-solution/
  public List<List<Integer>> subsets2(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int n = nums.length;
    for (int mask = 0; mask < 1 << n; mask++) {
      for (int j = 0; j < n; j++) {
        if ((mask & 1 << j) != 0) {
          list.add(nums[j]);
        }
      }
      ans.add(new ArrayList<>(list));
      list.clear();
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    List<List<Integer>> ans = new SubSets().subsets2(nums);
    System.out.println(ans);

    System.out.println(16 >> 2);
    System.out.println(1 << 3);
    System.out.println(7 & 3);
    System.out.println(7 & 0);
  }
}
