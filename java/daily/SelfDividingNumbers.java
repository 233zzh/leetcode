package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 728. 自除数
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2022/3/31 21:20
 */
public class SelfDividingNumbers {

  public static void main(String[] args) {
    System.out.println(new SelfDividingNumbers().selfDividingNumbers(1, 22));
    System.out.println(new SelfDividingNumbers().selfDividingNumbers(47, 85));
  }

  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> results = new ArrayList<Integer>();
    for (int i = left; i <= right; i++) {
      int tmp = i;
      boolean flag = true;
      while (tmp != 0) {
        int digit = tmp % 10;
        if (digit == 0) {
          flag = false;
          break;
        }
        if (i % digit != 0) {
          flag = false;
          break;
        }
        tmp = tmp / 10;
      }
      if (flag) {
        results.add(i);
      }
    }
    return results;
  }

}
