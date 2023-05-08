package xiaohui_algorithm.interview;

/**
 * @Description 求取最大公约数
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/8 11:44
 */
public class GreatestCommonDivisor {

  //欧几里得算法,辗转想除法,两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数。
  public static int getGreatestCommonDivisor(int a, int b) {
    int big = Math.max(a, b);
    int small = Math.min(a, b);
    int c = big % small;
    if (c == 0) {
      return small;
    }
    return getGreatestCommonDivisor(c, small);
  }

  // 更相减损术，出自中国古代的《九章算术》，两个正整数a和b（a>b），它们的最大公约数等于a-b的差值c和较小数b的最大公约数。
  public static int getGreatestCommonDivisor1(int a, int b) {
    if (a - b == 0) {
      return a;
    }
    int big = Math.max(a, b);
    int small = Math.min(a, b);
    int c = big - small;
    return getGreatestCommonDivisor(c, small);
  }

  public static void main(String[] args) {
    System.out.println(getGreatestCommonDivisor(25, 10));
    System.out.println(getGreatestCommonDivisor(100, 80));
    System.out.println(getGreatestCommonDivisor(27, 14));

    System.out.println(getGreatestCommonDivisor1(25, 10));
    System.out.println(getGreatestCommonDivisor1(100, 80));
    System.out.println(getGreatestCommonDivisor1(27, 14));
  }
}
