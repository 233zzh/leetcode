package offer.lingxing;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/24 21:31
 */
public class First {

  public String reverse(String str) {
    StringBuilder newStr = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      newStr.append(str.charAt(i));
    }
    return newStr.toString();
  }

  public static void main(String[] args) {
    String str = "lingxing";
    System.out.println(new First().reverse(str));
  }
}
