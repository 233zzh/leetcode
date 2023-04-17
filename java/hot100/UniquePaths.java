package hot100;

/**
 * @Description 62. 不同路径
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/17 21:37
 */
public class UniquePaths {

  // 动态规划
  // f(i,j) 从起点到(i,j)有多少条不同的路径
  // f(i,j)=f(i-1,j)+f(i,j-1) f(i-1,j)和f(i,j-1)分别是向下和向右到达(i,j)
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int num = new UniquePaths().uniquePaths(3, 7);
    System.out.println(num);
  }
}
