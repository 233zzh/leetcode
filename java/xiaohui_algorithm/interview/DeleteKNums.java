package xiaohui_algorithm.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/8 19:21
 */
public class DeleteKNums {

  public static String deleteKNums(String num, int k) {
    int temp = k;
    while (temp-- > 0) {
      boolean flag = false;
      for (int i = 0; i < num.length() - 1; i++) {
        if (num.charAt(i) > num.charAt(i + 1)) {
          num = num.substring(0, i) + num.substring(i + 1);
          flag = true;
          break;
        }
      }
      if (!flag) {
        num = num.substring(0, num.length() - 1);
      }
    }

    int zeroCount = 0;
    for (int i = 0; i < num.length(); i++) {
      if (num.charAt(i) == '0') {
        zeroCount++;
      } else {
        break;
      }
    }
    num = num.substring(zeroCount);

    if (num.equals("")) {
      return "0";
    }
    return num;
  }

  public static int[] deleteKNums1(int[] nums, int k) {
    int temp = k;
    while (temp-- > 0) {
      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i + 1]) {
          for (int j = i; j < nums.length - 1; j++) {
            nums[j] = nums[j + 1];
          }
          break;
        }
      }
    }

    int[] result = Arrays.copyOf(nums, nums.length - k);
    int zeroCount = 0;
    for (int j : result) {
      if (j == 0) {
        zeroCount++;
      } else {
        break;
      }
    }

    int[] result1 = new int[result.length - zeroCount];
    System.arraycopy(result, zeroCount, result1, 0, result.length - zeroCount);
    return result1;
  }

  //  最好的方法-使用栈
  public static String deleteKNums2(String num, int k) {
    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < num.length(); i++) {
      if (k > 0) {
        if (!stack.isEmpty() && stack.peek() > num.charAt(i)) {
          stack.pop();
          stack.push(num.charAt(i));
          k--;
        } else {
          stack.push(num.charAt(i));
        }
      } else {
        stack.push(num.charAt(i));
      }
    }

    while (k-- > 0) {
      stack.pop();
    }
    while (!stack.isEmpty() && stack.getLast() == '0') {
      stack.removeLast();
    }
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
      result = new StringBuilder(String.valueOf(stack.pop())).append(result);
    }
    if (result.toString().equals("")) {
      return "0";
    }
    return result.toString();
  }


  public static void main(String[] args) {
    int[] nums = new int[]{5, 4, 1, 2, 7, 0, 9, 3, 6};
    int[] result = deleteKNums1(nums, 3);
    System.out.println(Arrays.toString(result));

    nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    result = deleteKNums1(nums, 3);
    System.out.println(Arrays.toString(result));

    nums = new int[]{3, 0, 2, 0, 0};
    result = deleteKNums1(nums, 1);
    System.out.println(Arrays.toString(result));

    String num = "541270936";
    String result1 = deleteKNums(num, 3);
    System.out.println(result1);

    num = "12345678";
    result1 = deleteKNums(num, 3);
    System.out.println(result1);

    num = "3000000000200";
    result1 = deleteKNums(num, 1);
    System.out.println(result1);

    num = "1593212";
    result1 = deleteKNums(num, 3);
    System.out.println(result1);

    num = "541270936";
    result1 = deleteKNums2(num, 3);
    System.out.println(result1);

    num = "12345678";
    result1 = deleteKNums2(num, 3);
    System.out.println(result1);

    num = "3000000000200";
    result1 = deleteKNums2(num, 1);
    System.out.println(result1);

    num = "1593212";
    result1 = deleteKNums2(num, 3);
    System.out.println(result1);

    num = "10";
    result1 = deleteKNums2(num, 2);
    System.out.println(result1);

    HashMap map = new HashMap();
  }

}
