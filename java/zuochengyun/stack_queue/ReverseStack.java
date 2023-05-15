package zuochengyun.stack_queue;

import java.util.Stack;

/**
 * @Description 仅用递归函数和栈操作逆序一个栈
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/15 11:48
 */
public class ReverseStack {

  // 找到并删除栈底元素
  private int getAndRemoveLast(Stack<Integer> stack) {
    int result = stack.pop();
    if (stack.isEmpty()) {
      return result;
    } else {
      int last = getAndRemoveLast(stack);
      stack.push(result);
      return last;
    }
  }


  // 递归
  public void reverseStack(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }
    int i = getAndRemoveLast(stack);
    reverseStack(stack);
    stack.push(i);
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    System.out.println(stack);
    new ReverseStack().reverseStack(stack);
    System.out.println(stack);
  }
}
