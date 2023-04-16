package hot100;

import java.util.Arrays;

/**
 * @Description 48. 旋转图像
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/16 18:17
 */
public class RotateImage {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    boolean rowToCol = true;
    for (int i = 0; i < n / 2; i++) {
      int[] array = new int[n];
      int aaa = 4;
      int rowOrCol = i;
      while (aaa-- > 0) {
        if (rowToCol) {
          rowOrCol = rowToCol(matrix, rowOrCol, array, aaa == 3);
          rowToCol = false;
        } else {
          rowOrCol = colToRow(matrix, rowOrCol, array);
          rowToCol = true;
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.toString(array));

      }
    }
  }


  private int rowToCol(int[][] matrix, int row, int[] array, boolean first) {
    int n = matrix.length;
    int[] temp = new int[n];
    if (first) {
      for (int j = 0; j < n; j++) {
        temp[j] = matrix[j][n - 1 - row];
        matrix[j][n - 1 - row] = matrix[row][j];
      }
    } else {
      for (int j = 0; j < n - 1; j++) {
        temp[j] = matrix[j][n - 1 - row];
        matrix[j][n - 1 - row] = array[j];
      }
    }
    System.arraycopy(temp, 0, array, 0, temp.length);
    return n - 1 - row;
  }

  private int colToRow(int[][] matrix, int col, int[] array) {
    int n = matrix.length;
    int[] temp = new int[n];
    for (int j = 0; j < n - 1; j++) {
      temp[j] = matrix[col][j];
      matrix[col][j] = array[n - j - 1];
    }
    System.arraycopy(temp, 0, array, 0, temp.length);
    return col;
  }


  // 先主对角线翻转，然后通过垂直轴翻转
  public void rotate1(int[][] matrix) {
    int n = matrix.length;
    // 先主对角线翻转
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    // 通过垂直轴翻转
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{new int[]{5, 1, 9, 11}, new int[]{2, 4, 8, 10},
        new int[]{13, 3, 6, 7}, new int[]{15, 14, 12, 16}};
    new RotateImage().rotate(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }
}
