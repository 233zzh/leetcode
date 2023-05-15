package zuochengyun.stack_queue;

import java.util.Stack;

/**
 * @Description 《程序代码面试指南》设计一个有getMin功能的栈
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/12 16:29
 */
public class MinStack {

  private final Stack<Integer> stack;
  private final Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

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

  @Override
  public String toString() {
    return "MinStack{" +
        "stack=" + stack +
        ", minStack=" + minStack +
        '}';
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    int[] nums = new int[]{10, 6, 7, 8, 4, 3, 9, 6};
    for (int i : nums) {
      minStack.push(i);
      System.out.print(minStack.getMin() + " ");
    }
    System.out.println();
    System.out.println(minStack);
  }
}
