package zuochengyun.linked_list;

/**
 * @Description 反转部分单向链表
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/18 19:56
 */
public class ReversePartialSingleLinkedList {

  public Node reversePartialSingleLinkedList(Node head, int from, int to) {
    Node temp = head;
    int len = 0;
    Node fromPrev = null;
    Node toLater = null;
    while (temp != null) {
      len++;
      fromPrev = len == from - 1 ? temp : fromPrev;
      toLater = len == to + 1 ? temp : toLater;
      temp = temp.next;
    }
    if (from < 1 || to > len || from >= to) {
      return head;
    }

    Node prev = toLater;
    Node curr = fromPrev == null ? head : fromPrev.next;
    Node next;
    while (curr != toLater) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    if (fromPrev == null) {
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
    head = new ReversePartialSingleLinkedList().reversePartialSingleLinkedList(head, 2, 4);
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
    head = new ReversePartialSingleLinkedList().reversePartialSingleLinkedList(head, 1, 3);
    while (head != null) {
      System.out.print(head.data);
      head = head.next;
    }
  }
}
