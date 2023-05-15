package zuochengyun.stack_queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/15 19:58
 */
public class WindowMaxArray {

  // 搞一个双端队列，存储子数组从大到小的索引
  // 如果qmax是空的，就直接放入当前的位置。
  // 如果qmax不是空的，qmax队尾的位置所代表的值如果不比当前的值大，将一直弹出队尾的位置，
  // 直到qmax 队尾的位置所代表的值比当前的值大，当前的位置才放入qmax的队尾。
  public int[] getWindowMaxArray(int[] array, int w) {
    int n = array.length;
    int[] result = new int[n - w + 1];
    Deque<Integer> qmax = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      while (!qmax.isEmpty() && array[qmax.peekLast()] <= array[i]) {
        qmax.pollLast();
      }
      qmax.offer(i);
      if (qmax.peekFirst() == i - w) {
        qmax.pollFirst();
      }
      if (i >= w - 1) {
        result[i - w + 1] = array[qmax.peekFirst()];
      }
      System.out.println(qmax);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] array = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
    int[] result = new WindowMaxArray().getWindowMaxArray(array, 3);
    System.out.println(Arrays.toString(result));
  }
}
