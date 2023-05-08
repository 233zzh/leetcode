package xiaohui_algorithm.interview;

/**
 * @Description 小灰漫画算法-无序数组排序后的最大相邻差
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/8 14:51
 */
public class TheMaxIntervalUnorderedArray {

  // 参考计数排序
  // 这个思路在数组元素差值不很悬殊的时候，确实效率很高。
  // 可是设想一下，如果原数组只有3个元素：1、2、1000000，那就要创建长度是1000000的数组！
  public static int getTheMaxInterval(int[] array) {
    int min = array[0];
    int max = array[0];
    for (int i : array) {
      min = Math.min(i, min);
      max = Math.max(i, max);
    }
    int[] temp = new int[max - min + 1];
    for (int j : array) {
      temp[j - min]++;
    }
    int maxInterval = 0;
    int interval = 0;
    for (int j : temp) {
      if (j == 0) {
        interval++;
        maxInterval = Math.max(interval, maxInterval);
      } else {
        interval = 0;
      }
    }
    return maxInterval + 1;
  }

  public static void main(String[] args) {
    System.out.println(getTheMaxInterval(new int[]{2, 6, 3, 4, 5, 10, 9}));
    System.out.println(getTheMaxInterval(new int[]{2, 3, 4, 5, 6, 9, 10}));
  }
}
