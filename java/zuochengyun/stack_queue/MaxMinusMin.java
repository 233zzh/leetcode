package zuochengyun.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 最大值减去最小值小于或等于num的子数组数量
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/17 15:13
 */
public class MaxMinusMin {

  public int maxMinusMin(int[] array, int num) {
    int result = 0;
    // 从头到尾从大到小
    Deque<Integer> qmax = new LinkedList<>();
    // 从头到尾从小到大
    Deque<Integer> qmin = new LinkedList<>();

    int i = 0;
    int j = 0;
    qmax.offer(array[0]);
    qmin.offer(array[0]);
    while (i < array.length) {
      while (!qmax.isEmpty() && !qmin.isEmpty() && array[qmax.peekFirst()] - array[qmin.peekFirst()] <= num
          && j < array.length) {
        if (!qmax.isEmpty() && array[qmax.peekLast()] <= array[j]) {
          qmax.removeLast();
        }
        if (j != i) {
          qmax.offer(j);
        }

        if (!qmin.isEmpty() && qmax.peekLast() > array[j]) {
          qmax.removeLast();
        }
        if (j != i) {
          qmin.offer(array[j]);
        }
        j++;
      }
      result += j - i;
      if (qmax.peekFirst() == array[i]) {
        qmax.removeFirst();
      }
      if (qmin.peekFirst() == array[i]) {
        qmin.removeFirst();
      }
      i++;
    }
    return result;
  }


  public static void main(String[] args) {
    int[] array = new int[]{5, 4, 3, 6, 7, 8};
    int result = new MaxMinusMin().maxMinusMin(array, 2);
    System.out.println(result);
  }
}
