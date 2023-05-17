package zuochengyun.linkedlist;

/**
 * @Description 在单链表和双链表中删除倒数第K个节点
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/17 16:40
 */
public class DeleteLastKthNode {

  // 单链表中删除倒数第K个节点
  public Node deleteLastKthNode(Node head, int k) {
    if (head == null || k < 1) {
      return head;
    }
    Node slow = head;
    Node fast = head;
    while (k-- > 0) {
      // 1、第一种情况，不存在倒数第k个节点，直接返回原链表 1->2->3, k=4
      if (fast == null) {
        return head;
      }
      fast = fast.next;
    }
    // 2、第二种情况 删除头节点
    if (fast == null) {
      return head.next;
    }
    // 3、第三种情况 删除中间节点或者尾节点
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    return head;
  }


  // 双链表中删除倒数第K个节点
  public DoubleNode deleteLastKthNode1(DoubleNode head, int k) {
    if (head == null || k < 1) {
      return head;
    }
    DoubleNode slow = head;
    DoubleNode fast = head;
    while (k-- > 0) {
      // 1、第一种情况，不存在倒数第k个节点，直接返回原链表 1->2->3, k=4
      if (fast == null) {
        return head;
      }
      fast = fast.next;
    }
    // 2、第二种情况 删除头节点
    if (fast == null) {
      head.next.last = null;
      return head.next;
    }
    // 3、第三种情况 删除中间节点或者尾节点
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    DoubleNode next = slow.next.next;
    slow.next = next;
    if (next != null) {
      next.last = slow;
    }
    return head;
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

    head = new DeleteLastKthNode().deleteLastKthNode(head, 9);
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }
}
