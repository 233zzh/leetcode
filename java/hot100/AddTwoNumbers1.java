package hot100;

/**
 * @Description 两数相加
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/10 16:21
 */
public class AddTwoNumbers1 {

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
    ListNode l3 = new ListNode();
    ListNode temp = l3;
    // 进位
    int carry = 0;
    while (l1 != null || l2 != null) {
      int a;
      int b;
      if (l1 == null) {
        a = 0;
      } else {
        a = l1.val;
      }
      if (l2 == null) {
        b = 0;
      } else {
        b = l2.val;
      }

      int sum = a + b + carry;
      if (sum >= 10) {
        carry = 1;
        temp.next = new ListNode(sum - 10);
      } else {
        carry = 0;
        temp.next = new ListNode(sum);
      }
      temp = temp.next;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (carry!=0){
      temp.next = new ListNode(carry);
    }

    return l3.next;
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
    ListNode l1 = new AddTwoNumbers1().new ListNode(2);
    l1.next = new AddTwoNumbers1().new ListNode(4);
    l1.next.next = new AddTwoNumbers1().new ListNode(3);

    ListNode l2 = new AddTwoNumbers1().new ListNode(5);
    l2.next = new AddTwoNumbers1().new ListNode(6);
    l2.next.next = new AddTwoNumbers1().new ListNode(4);

    ListNode l3 = new AddTwoNumbers1().addTwoNumbers(l1, l2);
    while (l3 != null) {
      System.out.print(l3.val + " ");
      l3 = l3.next;
    }

    String str = "9999999";
    String str1 = "9999";

    int len = str.length();
    l1 = new AddTwoNumbers1().new ListNode();
    ListNode temp = l1;
    for (int i = len - 1; i >= 0; i--) {
      int value = Integer.parseInt(String.valueOf(str.charAt(i)));
      temp.next = new AddTwoNumbers1().new ListNode(value);
      temp = temp.next;
    }
    l1 = l1.next;

    len = str1.length();
    l2 = new AddTwoNumbers1().new ListNode();
    temp = l2;
    for (int i = len - 1; i >= 0; i--) {
      int value = Integer.parseInt(String.valueOf(str1.charAt(i)));
      temp.next = new AddTwoNumbers1().new ListNode(value);
      temp = temp.next;
    }
    l2 = l2.next;

    System.out.println();
    l3 = new AddTwoNumbers1().addTwoNumbers(l1, l2);
    while (l3 != null) {
      System.out.print(l3.val + " ");
      l3 = l3.next;
    }
  }
}

