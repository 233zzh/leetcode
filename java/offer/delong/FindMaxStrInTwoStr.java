package offer.delong;

/**
 * @Description 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/5 19:41
 */
public class FindMaxStrInTwoStr {

  // 给定两个字符串str1和str2,输出两个字符串的最长公共子串
  // 输入"1AB2345CD","12345EF"
  // 返回值："2345"
  public static String max(String str1, String str2) {
    String maxStr = "";
    for (int i = 0; i < str1.length(); i++) {
      for (int j = 0; j < str2.length(); j++) {
        String tempStr = "";
        int ptr1 = i;
        int ptr2 = j;
        while (str1.charAt(ptr1) == str2.charAt(ptr2)) {
          tempStr += str1.charAt(ptr1);
          if (maxStr.length() < tempStr.length()) {
            maxStr = tempStr;
          }
          ptr1++;
          ptr2++;
        }
      }
    }
    return maxStr;
  }

  public static void main(String[] args) {
    System.out.println(max("1AB2345CD", "12345EF"));
  }
}
