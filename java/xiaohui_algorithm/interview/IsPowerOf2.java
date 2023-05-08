package xiaohui_algorithm.interview;

/**
 * @Description 如何判断一个数是否为2的整数次幂
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/8 12:44
 */
public class IsPowerOf2 {

  public static boolean isPowerOf2(int num) {
    return (num & num - 1) == 0;
  }
}
