package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/12 16:20
 */
public class LetterCombinations {

  public List<String> letterCombinations(String digits) {
    String letter = "abcdefghijklmnopqrstuvwxyz";
    List<String> list = new ArrayList<>();
    for (int i = 0; i < digits.length(); i++) {
      char digit = digits.charAt(i);
      int num = Integer.parseInt(String.valueOf(digit));
      String temp = letter.substring((num - 2) * 3, (num - 1) * 3);
      if (digit == '7') {
        temp = "pqrs";
      } else if (digit == '8') {
        temp = "tuv";
      } else if (digit == '9') {
        temp = "wxyz";
      }
      List<String> list1 = new ArrayList<>();
      for (char c : temp.toCharArray()) {
        if (i != 0) {
          for (String str : list) {
            list1.add(str + c);
          }
        } else {
          list1.add(String.valueOf(c));
        }
      }
      list = list1;
    }
    return list;
  }

  public static void main(String[] args) {

    String digits = "23";
    List list = new LetterCombinations().letterCombinations(digits);
    System.out.println(list.size());
    System.out.println(list);

    digits = "2";
    list = new LetterCombinations().letterCombinations(digits);
    System.out.println(list.size());
    System.out.println(list);

    digits = "";
    list = new LetterCombinations().letterCombinations(digits);
    System.out.println(list.size());
    System.out.println(list);
  }
}
