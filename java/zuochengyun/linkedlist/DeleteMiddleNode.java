package zuochengyun.linkedlist;

/**
 * @Description 删除链表的中间节点和a/b处的节点
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/17 19:49
 */
public class DeleteMiddleNode {

  // 删除链表的中间节点
  public Node deleteMiddleNode(Node head) {
    // 链表为null或者长度为1
    if (head == null || head.next == null) {
      return head;
    }
    // 长度为2，删除第一个节点
    if (head.next.next == null) {
      return head.next;
    }
    Node slow = head;
    Node fast = head.next.next;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }


  // 删除链表的a/b处
  public Node deleteABNode(Node head, int a, int b) {
    // 链表为null
    if (head == null) {
      return head;
    }
    // 链表长度
    int n = 0;
    Node temp = head;
    while (temp != null) {
      n++;
      temp = temp.next;
    }
    double c = (double) a * n / b;
    // 要删除第r个节点（从1开始）
    int r = (int) Math.ceil(c);
    if (r < 1 || r > n) {
      return head;
    }
    // 删除第一个节点
    if (r == 1) {
      return head.next;
    }
    temp = head;
    // 删除第r个，要找到第r-1个，要移动r-2次
    while (r-- > 2) {
      temp = temp.next;
    }
    temp.next = temp.next.next;
    return head;
  }

  public static void main(String[] args) {
    Node head = new Node(-1);
    Node temp = head;
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    for (int i : array) {
      temp.next = new Node(i);
      temp = temp.next;
    }
    head = head.next;
    head = new DeleteMiddleNode().deleteMiddleNode(head);
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }

    System.out.println();
    head = new Node(-1);
    temp = head;
    array = new int[]{1, 2, 3, 4};
    for (int i : array) {
      temp.next = new Node(i);
      temp = temp.next;
    }
    head = head.next;
    head = new DeleteMiddleNode().deleteMiddleNode(head);
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }

    System.out.println();
    head = new Node(-1);
    temp = head;
    array = new int[]{1, 2, 3, 4, 5};
    for (int i : array) {
      temp.next = new Node(i);
      temp = temp.next;
    }
    head = head.next;
    head = new DeleteMiddleNode().deleteMiddleNode(head);
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

}
