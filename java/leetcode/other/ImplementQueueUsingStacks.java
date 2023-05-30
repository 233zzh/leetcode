package leetcode.other;

import java.util.Stack;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/6 14:41
 */
public class ImplementQueueUsingStacks {

  public static void main(String[] args) {

  }

}


class MyQueue {

  Stack<Integer> inStack;
  Stack<Integer> outStack;

  public MyQueue() {
    inStack = new Stack<Integer>();
    outStack = new Stack<Integer>();
  }

  public void push(int x) {
    inStack.push(x);
  }

  public int pop() {
    if (outStack.isEmpty()) {
      while (!inStack.isEmpty()) {
        outStack.push(inStack.pop());
      }
    }
    return outStack.pop();
  }

  public int peek() {
    if (outStack.isEmpty()) {
      while (!inStack.isEmpty()) {
        outStack.push(inStack.pop());
      }
    }
    return outStack.peek();
  }

  public boolean empty() {
    return inStack.isEmpty() && outStack.isEmpty();
  }

  public static void main(String[] args) {
    MyQueue obj = new MyQueue();
    obj.push(2);
    obj.push(3);
    int param_2 = obj.pop();
    int param_3 = obj.peek();
    boolean param_4 = obj.empty();
    System.out.println(param_2);
    System.out.println(param_3);
    System.out.println(param_4);
  }
}
