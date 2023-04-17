package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/13 10:22
 */
public class GenerateParenthesis {

  //  https://leetcode.cn/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/874009
  public List<String> generateParenthesis(int n) {
    if (n == 1) {
      return Arrays.asList("()");
    }
    Set<String> set = new HashSet<String>();
    for (String i : generateParenthesis(n - 1)) {
      for (int j = 1; j <= i.length(); j++) {
        String temp = i.substring(0, j) + "()" + i.substring(j, i.length());
        set.add(temp);
      }
    }
    return new ArrayList<>(set);
  }

  public static void main(String[] args) {
    System.out.println(new GenerateParenthesis().generateParenthesis(3));
  }
}
