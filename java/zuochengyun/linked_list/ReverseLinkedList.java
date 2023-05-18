package zuochengyun.linked_list;

/**
 * @Description 反转单向和双向链表
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/17 20:51
 */
public class ReverseLinkedList {

  // 反转单链表
  public Node reverseSingleLinkedList(Node head) {
    // 空链表或者长度为1
    if (head == null || head.next == null) {
      return head;
    }
    Node prev = null;
    Node curr = head;
    Node later;
    while (curr != null) {
      later = curr.next;
      curr.next = prev;
      prev = curr;
      curr = later;
    }
    return prev;
  }


  // 反转双链表
  public DoubleNode reverseDoubleLinkedList(DoubleNode head) {
    // 空链表或者长度为1
    if (head == null || head.next == null) {
      return head;
    }
    DoubleNode prev = null;
    DoubleNode curr = head;
    DoubleNode later;
    while (curr != null) {
      later = curr.next;
      curr.next = prev;
      curr.last = later;
      prev = curr;
      curr = later;
    }
    return prev;
  }

  public static void main(String[] args) {
    Node head = new Node(-1);
    Node temp = head;
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    for (int i : array) {
      temp.next = new Node(i);
      temp = temp.next;
    }
    head = head.next;
    head = new ReverseLinkedList().reverseSingleLinkedList(head);
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}
