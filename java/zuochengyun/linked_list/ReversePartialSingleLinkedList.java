package zuochengyun.linked_list;

/**
 * @Description 反转部分单向链表
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/18 19:56
 */
public class ReversePartialSingleLinkedList {

  public Node reversePartialSingleLinkedList(Node head, int from, int to) {
    int count = to - from + 1;
    // to之后的节点（第to+1个节点）
    Node tail = head;
    while (to-- > 0) {
      tail = tail.next;
    }
    // from之前的节点（第from-1个节点）
    Node start = head;
    while (from-- > 1) {
      start = start.next;
    }
    Node prev = tail;
    Node curr = start;
    Node next;
    while (count-- > 0) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    if (tail == null) {
      // 换头节点
      return prev;
    } else {
      head.next = prev;
      return head;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(-1);
    Node temp = head;
    int[] array = new int[]{1, 2, 3, 4, 5};
    for (int i : array) {
      temp.next = new Node(i);
      temp = temp.next;
    }
    head = head.next;
    head=new ReversePartialSingleLinkedList().reversePartialSingleLinkedList(head, 2, 4);
    while (head != null) {
      System.out.print(head.data);
      head = head.next;
    }

    System.out.println();
    head = new Node(-1);
    temp = head;
    array = new int[]{1, 2, 3};
    for (int i : array) {
      temp.next = new Node(i);
      temp = temp.next;
    }
    head = head.next;
    head=new ReversePartialSingleLinkedList().reversePartialSingleLinkedList(head, 1, 3);
    while (head != null) {
      System.out.print(head.data);
      head = head.next;
    }
  }
}
