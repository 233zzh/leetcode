package zuochengyun.stack_queue;

import java.util.Stack;

/**
 * @Description 两个栈组成的队列
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/15 11:24
 */
public class TwoStackQueue {

  private final Stack<Integer> inStack;
  private final Stack<Integer> outStack;

  public TwoStackQueue() {
    inStack = new Stack<>();
    outStack = new Stack<>();
  }

  public void add(int data) {
    inStack.push(data);
  }

  public int poll() {
    if (outStack.isEmpty()) {
      inToOut();
    }
    return outStack.pop();
  }

  public int peek() {
    if (outStack.isEmpty()) {
      inToOut();
    }
    return outStack.peek();
  }


  private void inToOut() {
    while (!inStack.isEmpty()) {
      outStack.push(inStack.pop());
    }
  }
}
