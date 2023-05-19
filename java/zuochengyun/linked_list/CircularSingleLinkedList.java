package zuochengyun.linked_list;

/**
 * @Description 环形单链表的约瑟夫问题
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/19 16:17
 */
public class CircularSingleLinkedList {

  // 很明显的是，每删除一个节点，都需要遍历m次，一共需要删除的节点数为n-1，所以普通解法的时间复杂度为O（n×m）
  public Node circularSingleLinkedList(Node head, int m) {
    //如果链表为空或者链表节点数为1，或者m的值小于1，则不用调整就直接返回。
    if (m <= 0 || head == null || head.next == head) {
      return head;
    }
    // 找到尾节点
    Node tail = head.next;
    while (tail.next != head) {
      tail = tail.next;
    }
    while (tail.next != tail) {
      int count = m - 1;
      while (count-- > 0) {
        tail = tail.next;
      }
      tail.next = tail.next.next;
    }
    return tail;
  }

  public static void main(String[] args) {
    Node head = new Node(-1);
    Node temp = head;
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
    for (int i : array) {
      temp.next = new Node(i);
      temp = temp.next;
    }
    head = head.next;
    temp.next = head;

    head = new CircularSingleLinkedList().circularSingleLinkedList(head, 2);
    while (head != null) {
      System.out.print(head.data);
      head = head.next;
    }

  }
}
