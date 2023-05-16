package zuochengyun.stack_queue;

import java.util.Stack;

/**
 * @Description 求最大子矩阵的大小
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/16 16:27
 */
public class MaxMatrix {

  // 矩阵大小NxM
  public int getMaxMatrix(int[][] matrix) {
    int N = matrix.length;
    int M = matrix[0].length;
    int[] height = new int[M];
    int max = -1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        height[j] = matrix[i][j] == 0 ? 0 : height[j] + 1;
      }
      max = Math.max(max, getMaxFromBottom(height));
    }
    return max;
  }


  // height={3,4,5,4,3,6}
  // 单调栈
  private int getMaxFromBottom(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int max = -1;
    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
        int x = stack.pop();
        int left = !stack.isEmpty() ? stack.peek() : -1;
        int right = i;
        int area = height[x] * (right - left - 1);
        max = Math.max(max, area);
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int x = stack.pop();
      int left = !stack.isEmpty() ? stack.peek() : -1;
      int right = height.length;
      int area = height[x] * (right - left - 1);
      max = Math.max(max, area);
    }
    return max;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {1, 0, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 0}};
    int max = new MaxMatrix().getMaxMatrix(matrix);
    System.out.println(max);
  }


}
