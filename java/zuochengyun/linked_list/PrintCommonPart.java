package zuochengyun.linked_list;

/**
 * @Description 打印两个有序链表的公共部分
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/17 16:21
 */
public class PrintCommonPart {

  public void printCommonPart(Node head1, Node head2) {
    while (head1 != null && head2 != null) {
      if (head1.data < head2.data) {
        head1 = head1.next;
      } else if (head1.data > head2.data) {
        head2 = head2.next;
      } else {
        System.out.println(head1.data);
        head1 = head1.next;
        head2 = head2.next;
      }
    }
  }

  public static void main(String[] args) {
    Node head1 = new Node(-1);
    Node temp = head1;
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    for (int i : array) {
      temp.next = new Node(i);
      temp = temp.next;
    }
    head1 = head1.next;

    Node head2 = new Node(-1);
    Node temp2 = head2;
    int[] array2 = new int[]{2, 4, 6, 8};
    for (int i : array2) {
      temp2.next = new Node(i);
      temp2 = temp2.next;
    }
    head2 = head2.next;
    new PrintCommonPart().printCommonPart(head1, head2);
  }


}

