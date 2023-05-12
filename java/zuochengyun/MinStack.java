package zuochengyun;

import java.util.Stack;

/**
 * @Description 《程序代码面试指南》设计一个有getMin功能的栈
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/12 16:29
 */
public class MinStack {

  Stack<Integer> stack = new Stack<>();
  Stack<Integer> minStack = new Stack<>();

  public void push(int data) {
    if (minStack.isEmpty() || minStack.peek() >= data) {
      minStack.push(data);
    }
    stack.push(data);
  }

  public int pop() {
    if (stack.peek().equals(minStack.peek())) {
      minStack.pop();
    }
    return stack.pop();
  }

  public int getMin() {
    return minStack.peek();
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    int[] nums = new int[]{10, 6, 7, 8, 4, 3, 9, 6};
    for (int i : nums) {
      minStack.push(i);
      System.out.println(minStack.getMin());
    }
  }
}
