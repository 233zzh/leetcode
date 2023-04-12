package hot100;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/12 21:20
 */
public class MergeTwoLists {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode newList = new ListNode();
    ListNode temp = newList;
    while (list1 != null || list2 != null) {
      if (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
          temp.next = list1;
          temp = temp.next;
          list1 = list1.next;
        } else {
          temp.next = list2;
          temp = temp.next;
          list2 = list2.next;
        }
      } else {
        if (list2 == null) {
          temp.next = list1;
          temp = temp.next;
          list1 = list1.next;
        } else if (list1 == null) {
          temp.next = list2;
          temp = temp.next;
          list2 = list2.next;
        }
      }
    }

    return newList.next;
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
    int[] l1 = new int[]{1, 2, 4};
    ListNode l1Node = new MergeTwoLists().new ListNode();
    ListNode temp = l1Node;
    for (int i : l1) {
      temp.next = new MergeTwoLists().new ListNode(i);
      temp = temp.next;
    }
    l1Node = l1Node.next;

    int[] l2 = new int[]{1, 3, 4};
    ListNode l2Node = new MergeTwoLists().new ListNode();
    temp = l2Node;
    for (int i : l2) {
      temp.next = new MergeTwoLists().new ListNode(i);
      temp = temp.next;
    }
    l2Node = l2Node.next;

    ListNode result = new MergeTwoLists().mergeTwoLists(l1Node, l2Node);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
    System.out.println();
  }
}
