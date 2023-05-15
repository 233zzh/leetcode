package zuochengyun.stack_queue;

import java.util.Stack;

/**
 * @Description 用一个栈实现另一个栈的排序
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/15 17:16
 */
public class SortStackByStack {

  // 栈顶到栈底部从大到小
  public void sortStackByStack(Stack<Integer> stack) {
    Stack<Integer> help = new Stack<>();
    while (!stack.isEmpty()) {
      int current = stack.pop();
      while (!help.isEmpty() && current > help.peek()) {
        stack.push(help.pop());
      }
      help.push(current);
    }
    while (!help.isEmpty()) {
      stack.push(help.pop());
    }
  }

  // 栈顶到栈底部从小到大
  public void sortStackByStack1(Stack<Integer> stack) {
    Stack<Integer> help = new Stack<>();
    while (!stack.isEmpty()) {
      int current = stack.pop();
      while (!help.isEmpty() && current < help.peek()) {
        stack.push(help.pop());
      }
      help.push(current);
    }
    while (!help.isEmpty()) {
      stack.push(help.pop());
    }
  }


  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.add(10);
    stack.add(6);
    stack.add(6);
    stack.add(7);
    stack.add(8);
    stack.add(4);
    stack.add(3);
    Stack<Integer> stack1 = (Stack<Integer>) stack.clone();

    System.out.println(stack);
    new SortStackByStack().sortStackByStack(stack);
    System.out.println(stack);

    System.out.println(stack1);
    new SortStackByStack().sortStackByStack1(stack1);
    System.out.println(stack1);
  }
}
