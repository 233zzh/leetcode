package xiaohui_algorithm.interview;

import java.util.Stack;

/**
 * @Description 最小栈
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/8 11:26
 */
public class MinStack {

  private Stack<Integer> mainStack = new Stack<Integer>();

  private Stack<Integer> minStack = new Stack<Integer>();

  public void push(int element) {
    if (minStack.isEmpty() || element <= minStack.peek()) {
      minStack.push(element);
    }
    mainStack.push(element);
  }

  public int pop() {
    if (mainStack.peek().equals(minStack.peek())) {
      minStack.pop();
    }
    return mainStack.pop();
  }

  public int getMin() {
    return minStack.peek();
  }

  public static void main(String[] args) throws Exception {
    MinStack stack = new MinStack();
//    stack.push(4);
//    stack.push(9);
//    stack.push(7);
//    stack.push(3);
//    stack.push(8);
//    stack.push(5);
//    System.out.println(stack.getMin());
//    stack.pop();
//    stack.pop();
//    stack.pop();
    System.out.println(stack.getMin());
  }
}
