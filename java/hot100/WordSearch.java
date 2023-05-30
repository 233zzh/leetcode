package hot100;

/**
 * @Description 79. 单词搜索
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/19 16:17
 */
public class WordSearch {

  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    boolean flag;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        boolean[][] visited = new boolean[m][n];
        flag = dfs(i, j, board, 0, word, visited);
        if (flag) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean dfs(int i, int j, char[][] board, int k, String word, boolean[][] visited) {
    System.out.println(i + " " + j + " " + k);
    if (k >= word.length()) {
      return true;
    }
    int m = board.length;
    int n = board[0].length;
    if (i >= m || j >= n || i < 0 || j < 0) {
      return false;
    }
    char target = word.charAt(k);
    System.out.println(i + " " + j + " " + k + " " + target);
    boolean flag;
    if (board[i][j] == target && !visited[i][j]) {
      visited[i][j] = true;
      flag = dfs(i, j, board, k + 1, word, visited);
      if (flag) {
        return true;
      }
      dfs(i, j, board, k, word, visited);

    }
    if (j + 1 >= 0 && j + 1 < n && !visited[i][j + 1]) {
      if (board[i][j + 1] == target) {
        visited[i][j + 1] = true;
        flag = dfs(i, j + 1, board, k + 1, word, visited);
        if (flag) {
          return true;
        }
        dfs(i, j, board, k, word, visited);
      }
    }
    if (i + 1 >= 0 && i + 1 < m && !visited[i + 1][j]) {
      if (board[i + 1][j] == target) {
        visited[i + 1][j] = true;
        flag = dfs(i + 1, j, board, k + 1, word, visited);
        if (flag) {
          return true;
        }
        dfs(i, j, board, k, word, visited);
      }
    }
    if (j - 1 >= 0 && j - 1 < n && !visited[i][j - 1]) {
      if (board[i][j - 1] == target) {
        visited[i][j - 1] = true;
        flag = dfs(i, j - 1, board, k + 1, word, visited);
        if (flag) {
          return true;
        }
        dfs(i, j, board, k, word, visited);
      }
    }
    if (i - 1 >= 0 && i - 1 < m && !visited[i - 1][j]) {
      if (board[i - 1][j] == target) {
        visited[i - 1][j] = true;
        flag = dfs(i - 1, j, board, k + 1, word, visited);
        if (flag) {
          return true;
        }
        dfs(i, j, board, k, word, visited);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    String word = "ABCCED";
    boolean result = new WordSearch().exist(board, word);
    System.out.println(result);

    board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    word = "SEE";
    result = new WordSearch().exist(board, word);
    System.out.println(result);

    board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    word = "ABAB";
    result = new WordSearch().exist(board, word);
    System.out.println(result);

    board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    word = "ABAB";
    result = new WordSearch().exist(board, word);
    System.out.println(result);

    System.out.println("-----------------------");
    board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    word = "ABCEFSADEESE";
    result = new WordSearch().exist(board, word);
    System.out.println(result);
  }
}
