package zuochengyun.recursion_dp;

/**
 * @Description 矩阵的最小路径和 https://leetcode.cn/problems/0i0mDW/
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/17 16:21
 */
public class minPathSumOfMatrix {

  public int getMinPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = matrix[0][0];
    for (int i = 1; i < m; i++) {
      dp[i][0] = dp[i - 1][0] + matrix[i][0];
    }
    for (int j = 1; j < n; j++) {
      dp[0][j] = dp[0][j - 1] + matrix[0][j];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
      }
    }
    return dp[m - 1][n - 1];
  }

  //给定一个矩阵 m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
  // 贪心算法
  public int getMinPathSum1(int[][] matrix) {
    return dfs(matrix, 0, 0, matrix[0][0]);
  }

  public int dfs(int[][] matrix, int i, int j, int result) {
    System.out.println(i + " " + j);
    int m = matrix.length;
    int n = matrix[0].length;
    if (i == m - 1 && j == n - 1) {
      return result;
    }
    if (i == m - 1) {
      return dfs(matrix, i, j + 1, result + matrix[i][j + 1]);
    }
    if (j == n - 1) {
      return dfs(matrix, i + 1, j, result + matrix[i + 1][j]);
    }
    if (matrix[i + 1][j] < matrix[i][j + 1]) {
      return dfs(matrix, i + 1, j, result + matrix[i + 1][j]);
    } else {
      return dfs(matrix, i, j + 1, result + matrix[i][j + 1]);
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
    int result = new minPathSumOfMatrix().getMinPathSum(matrix);
    System.out.println(result);
  }

}
