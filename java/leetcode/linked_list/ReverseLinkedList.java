package leetcode.linked_list;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/27 15:09
 */
public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode next = head.next;
    head.next = null;
    while (next != null) {
      ListNode temp = next.next;
      next.next = head;
      head = next;
      next = temp;
    }
    return head;
  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 2, 3, 4, 5};
    ListNode head = new ListNode();
    ListNode temp = head;
    for (int i : array) {
      temp.next = new ListNode(i);
      temp = temp.next;
    }
    head = head.next;

    temp = head;
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }

    head = new ReverseLinkedList().reverseList(head);
    temp = head;
    System.out.println();
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
  }
}
