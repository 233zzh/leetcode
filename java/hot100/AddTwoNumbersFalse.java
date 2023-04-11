package hot100;

/**
 * @Description 两数相加，有问题
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/10 16:21
 */
public class AddTwoNumbersFalse {

  /*
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    StringBuilder str = new StringBuilder();
    while (l1 != null) {
      str.append(l1.val);
      l1 = l1.next;
    }

    StringBuilder str1 = new StringBuilder();
    while (l2 != null) {
      str1.append(l2.val);
      l2 = l2.next;
    }

    String newStr = reverseString(String.valueOf(str));
    String newStr1 = reverseString(String.valueOf(str1));
    int sum = Integer.parseInt(newStr) + Integer.parseInt(newStr1);
    String sumStr = reverseString(String.valueOf(sum));
//    System.out.println(sumStr);

    ListNode sumListNone = new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(0))));
    ListNode a = sumListNone;
    if (sumStr.length() > 1) {
      for (int i = 1; i < sumStr.length(); i++) {
        a.next = new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(i))));
        a = a.next;
      }
    }

    return sumListNone;
  }

  private String reverseString(String str) {
    String newStr = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      newStr += str.charAt(i);
    }
    return newStr;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new AddTwoNumbersFalse().new ListNode(2);
    l1.next = new AddTwoNumbersFalse().new ListNode(4);
    l1.next.next = new AddTwoNumbersFalse().new ListNode(3);

    ListNode l2 = new AddTwoNumbersFalse().new ListNode(5);
    l2.next = new AddTwoNumbersFalse().new ListNode(6);
    l2.next.next = new AddTwoNumbersFalse().new ListNode(4);

    ListNode l3 = new AddTwoNumbersFalse().addTwoNumbers(l1, l2);
    while (l3 != null) {
      System.out.println(l3.val);
      l3 = l3.next;
    }


    String str="999999999";
    int sum = Integer.parseInt(str) + Integer.parseInt(str);
    System.out.println(sum);
  }


}

