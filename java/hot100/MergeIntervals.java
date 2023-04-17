package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description 56. 合并区间
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/17 18:03
 */
public class MergeIntervals {

  // 官方题解
  // https://leetcode.cn/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
  // 先将列表中的区间按照左端点升序排序
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] interval1, int[] interval2) {
        return interval1[0] - interval2[0];
      }
    });
    List<int[]> result = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      if (i == 0) {
        result.add(intervals[0]);
      } else {
        int[] interval = intervals[i];
        if (interval[0] > result.get(result.size() - 1)[1]) {
          result.add(interval);
        } else {
          if (interval[1] > result.get(result.size() - 1)[1]) {
            result.get(result.size() - 1)[1] = interval[1];
          }
        }
      }
    }

    return result.toArray(new int[result.size()][]);
  }


  public static void main(String[] args) {
    int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] result = new MergeIntervals().merge(intervals);
    System.out.println(Arrays.deepToString(result));

    intervals = new int[][]{{1, 4}, {4, 5}, {8, 10}, {15, 18}};
    result = new MergeIntervals().merge(intervals);
    System.out.println(Arrays.deepToString(result));

    intervals = new int[][]{{1, 4}, {0, 5}};
    result = new MergeIntervals().merge(intervals);
    System.out.println(Arrays.deepToString(result));

    intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
    result = new MergeIntervals().merge(intervals);
    System.out.println(Arrays.deepToString(result));

    intervals = new int[][]{{2, 3}, {4, 6}, {5, 7}, {3, 4}};
    result = new MergeIntervals().merge(intervals);
    System.out.println(Arrays.deepToString(result));
  }
}
