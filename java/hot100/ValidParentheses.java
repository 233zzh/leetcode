package hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 20.有效的括号
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/12 17:48
 */
public class ValidParentheses {

  /**
   * 四种情况，左左，右右，左右，右左
   *
   * @param s
   * @return
   */
  public boolean isValid(String s) {
    List<Character> left = new ArrayList<Character>();
    left.add(')');
    left.add('}');
    left.add(']');
    List<Character> right = new ArrayList<>();
    right.add('(');
    right.add('{');
    right.add('[');
    Stack<Character> stack = new Stack<Character>();
    for (char c : s.toCharArray()) {
      if (stack.size() == 0) {
        // 1.剔除左，（左左，左右）
        if (left.contains(c)) {
          return false;
        } else {
          stack.add(c);
        }
      } else {
        char top = stack.peek();
        // 1.相同方向，插入（右右）
        if ((left.contains(c) && left.contains(top)) || (right.contains(c) && right.contains(
            top))) {
          stack.add(c);
        } else {
          // 相反方向（右左）
          // 栈顶是向右，要插入的向左，是同一种括号时，栈顶的括号弹出，不是同一种，报错
          if ((right.contains(top)) && (left.contains(c))) {
            int index = left.indexOf(c);
            char contrary = right.get(index);
            if (top == contrary) {
              stack.pop();
            } else {
              return false;
            }
          }
        }
      }
    }
    if (stack.size() == 0) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    String s = "()[]{}";
    boolean isValid = new ValidParentheses().isValid(s);
    System.out.println(isValid);

    s = "(]{}";
    isValid = new ValidParentheses().isValid(s);
    System.out.println(isValid);

    s = "(])";
    isValid = new ValidParentheses().isValid(s);
    System.out.println(isValid);
  }
}
