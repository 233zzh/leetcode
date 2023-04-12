package hot100;

/**
 * @Description 19. 删除链表的倒数第 N 个结点
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/12 17:01
 */
public class RemoveNthFromEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    int size = 0;
    ListNode temp = head;
    while (temp != null) {
      temp = temp.next;
      size++;
    }
    // 只有一个节点
    if (size == 1) {
      return null;
    }
    int index = size - n;
    // 删除头节点
    // 节点至少有一个，所以不会NullPointerException
    if (index==0){
      head=head.next;
    }
    temp = head;
    while (index-- > 0) {
      if (index == 0) {
        temp.next = temp.next.next;
      } else {
        temp = temp.next;
      }
    }
    return head;
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
    int[] head = new int[]{1, 2, 3, 4, 5};
    ListNode node = new RemoveNthFromEnd().new ListNode();
    ListNode temp = node;
    for (int i : head) {
      temp.next = new RemoveNthFromEnd().new ListNode(i);
      temp = temp.next;
    }
    node = node.next;
    ListNode result = new RemoveNthFromEnd().removeNthFromEnd(node, 2);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
    System.out.println();

    head = new int[]{1};
    node = new RemoveNthFromEnd().new ListNode();
    temp = node;
    for (int i : head) {
      temp.next = new RemoveNthFromEnd().new ListNode(i);
      temp = temp.next;
    }
    node = node.next;
    result = new RemoveNthFromEnd().removeNthFromEnd(node, 1);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
    System.out.println();

    head = new int[]{1, 2};
    node = new RemoveNthFromEnd().new ListNode();
    temp = node;
    for (int i : head) {
      temp.next = new RemoveNthFromEnd().new ListNode(i);
      temp = temp.next;
    }
    node = node.next;
    result = new RemoveNthFromEnd().removeNthFromEnd(node, 1);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
    System.out.println();

    head = new int[]{1, 2};
    node = new RemoveNthFromEnd().new ListNode();
    temp = node;
    for (int i : head) {
      temp.next = new RemoveNthFromEnd().new ListNode(i);
      temp = temp.next;
    }
    node = node.next;
    result = new RemoveNthFromEnd().removeNthFromEnd(node, 2);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }
}
