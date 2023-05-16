package zuochengyun.stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description 单调栈结构
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/16 11:37
 */
public class MonotonicStack {

  // 不含有重复值的数组arr
  public int[][] getMinPosition(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int[][] result = new int[arr.length][2];
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
        int x = stack.pop();
        int left = !stack.isEmpty() ? stack.peek() : -1;
        result[x] = new int[]{left, i};
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int x = stack.pop();
      int left = !stack.isEmpty() ? stack.peek() : -1;
      result[x] = new int[]{left, -1};
    }
    return result;
  }


  // 含有重复值的数组arr
  public int[][] getMinPosition1(int[] arr) {
    Stack<List<Integer>> stack = new Stack<>();
    int[][] result = new int[arr.length][2];
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
        List<Integer> top = stack.pop();
        int left;
        if (!stack.isEmpty()) {
          // 取位于下面位置的列表中，最晚加入的那个
          List<Integer> next = stack.peek();
          left = next.get(next.size() - 1);
        } else {
          left = -1;
        }
        for (int x : top) {
          result[x] = new int[]{left, i};
        }
      }
      if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
        stack.peek().add(i);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        stack.push(list);
      }
    }
    while (!stack.isEmpty()) {
      List<Integer> top = stack.pop();
      int left;
      if (!stack.isEmpty()) {
        List<Integer> next = stack.peek();
        left = next.get(next.size() - 1);
      } else {
        left = -1;
      }
      for (int x : top) {
        result[x] = new int[]{left, -1};
      }
    }
    return result;
  }


  public static void main(String[] args) {
    int[] arr = new int[]{3, 4, 1, 5, 6, 2, 7};
    int[][] result = new MonotonicStack().getMinPosition(arr);
    System.out.println(Arrays.deepToString(result));

    arr = new int[]{3, 1, 3, 4, 3, 5, 3, 2, 2};
    result = new MonotonicStack().getMinPosition1(arr);
    System.out.println(Arrays.deepToString(result));
  }

}
