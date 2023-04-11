package hot100;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/11 17:23
 */
public class LongestPalindromicSubstring {

  // dp[i][j]= dp[i+1][j-1] && s[i]==s[j]      s.length>2,i<j
  // dp[i][j]= true                            s.length==1,i==j
  // dp[i][j]= s[i]==s[j]                      s.length==2,i<j
  public String longestPalindrome(String s) {
    int len = s.length();
    boolean[][] dp = new boolean[len][len];

    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }

    int maxLen = 1;
    int begin = 0;
    // 字符串长度L=j-i+1
    for (int L = 2; L <= len; L++) {
      // 左边
      for (int i = 0; i < len - 1; i++) {
        // 右边
        int j = L + i - 1;
        if (j >= len) {
          break;
        }

        boolean isEqual = s.charAt(i) == s.charAt(j);
        if (L == 2) {
          dp[i][j] = isEqual;
        } else {
          dp[i][j] = dp[i + 1][j - 1] && isEqual;
        }
        if (dp[i][j] && L > maxLen) {
          maxLen = L;
          begin = i;
        }
      }
    }

    return s.substring(begin, begin + maxLen);

  }


  public static void main(String[] args) {
    String s = "babad";
    String result = new LongestPalindromicSubstring().longestPalindrome(s);
    System.out.println(result);

    s = "cbbd";
    result = new LongestPalindromicSubstring().longestPalindrome(s);
    System.out.println(result);

    s = "a";
    result = new LongestPalindromicSubstring().longestPalindrome(s);
    System.out.println(result);
  }
}
