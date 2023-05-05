package offer.futu;

/**
 * @Description 富途面试，M进制到N进制
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/4 14:59
 */
public class MBaseToNbase {

  public static String executeMBaseToNbase(String str, int M, int N) {
    // M进制转10进制
    int sum = 0;
    int dight = 0;
    for (int i = str.length() - 1; i >= 0; i--) {
      sum += charToInt(str.charAt(i)) * Math.pow(M, dight);
      dight++;
    }

    // 10进制转N进制
    StringBuilder result = new StringBuilder();
    while (sum != 0) {
      int i = sum % N;
      result = new StringBuilder(String.valueOf(intToChar(i))).append(result);
      sum = sum / N;
    }
    return result.toString();
  }

  private static int charToInt(char c) {
    if (c > '0' && c < '9') {
      return Integer.parseInt(String.valueOf(c));
    }
    return c - 55;
  }

  private static char intToChar(int i) {
    if (i >= 0 && i <= 9) {
      return (char) (i + 48);
    }
    return (char) (i + 55);
  }

  public static void main(String[] args) {
    String result = executeMBaseToNbase("3333", 5, 16);
    System.out.println(result);
    System.out.println((int) 'A');
    System.out.println((int) 'Z');
    System.out.println((int) '0');
    System.out.println((int) '9');
    System.out.println((char) (13+55));
  }

}
