package top_interview_150;

import java.util.Objects;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/9 17:14
 */
public class RomanToInt {

  String name;
  int age;
  double aaa;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RomanToInt that = (RomanToInt) o;
    return age == that.age && Double.compare(that.aaa, aaa) == 0
        && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, aaa);
  }

  public int romanToInt(String s) {
    int result = 0;
    int i;
    for (i = s.length() - 1; i >= 1; i--) {
      char romanChar = s.charAt(i);
      if (romanChar == 'I') {
        result += 1;
      } else if (romanChar == 'V') {
        if (s.charAt(i - 1) == 'I') {
          result += 4;
          i--;
        } else {
          result += 5;
        }
      } else if (romanChar == 'X') {
        if (s.charAt(i - 1) == 'I') {
          result += 9;
          i--;
        } else {
          result += 10;
        }
      } else if (romanChar == 'L') {
        if (s.charAt(i - 1) == 'X') {
          result += 40;
          i--;
        } else {
          result += 50;
        }
      } else if (romanChar == 'C') {
        if (s.charAt(i - 1) == 'X') {
          result += 90;
          i--;
        } else {
          result += 100;
        }
      } else if (romanChar == 'D') {
        if (s.charAt(i - 1) == 'C') {
          result += 400;
          i--;
        } else {
          result += 500;
        }
      } else if (romanChar == 'M') {
        if (s.charAt(i - 1) == 'C') {
          result += 900;
          i--;
        } else {
          result += 10000;
        }
      }
    }
    if (i == 0) {
      result += romanCharToInt(s.charAt(i));
    }
    return result;

  }

  private int romanCharToInt(char romanChar) {
    switch (romanChar) {
      case 'I' -> {
        return 1;
      }
      case 'V' -> {
        return 5;
      }
      case 'X' -> {
        return 10;
      }
      case 'L' -> {
        return 50;
      }
      case 'C' -> {
        return 100;
      }
      case 'D' -> {
        return 500;
      }
      case 'M' -> {
        return 1000;
      }
    }
    return -1;

  }

  public static void main(String[] args) {
    String s = "III";
    System.out.println(new RomanToInt().romanToInt(s));

    s = "MCMXCIV";
    System.out.println(new RomanToInt().romanToInt(s));

    s = "MMCCCXCIX";
    System.out.println(new RomanToInt().romanToInt(s));


    System.out.println(10>>1);
    System.out.println(10<<1);
    System.out.println(10^2);


  }



}
