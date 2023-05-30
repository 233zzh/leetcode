package leetcode.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/11 14:20
 */
public class MergeKList {
  class Status implements Comparable<Status> {
    int val;
    ListNode ptr;

    Status(int val, ListNode ptr) {
      this.val = val;
      this.ptr = ptr;
    }

    public int compareTo(Status status2) {
      return this.val - status2.val;
    }
  }

  PriorityQueue<Status> queue = new PriorityQueue<Status>(new Comparator<Status>() {
    @Override
    public int compare(Status o1, Status o2) {
      return 0;
    }
  });

  public ListNode mergeKLists(ListNode[] lists) {
    for (ListNode node: lists) {
      if (node != null) {
        queue.offer(new Status(node.val, node));
      }
    }
    ListNode head = new ListNode(0);
    ListNode tail = head;
    while (!queue.isEmpty()) {
      Status f = queue.poll();
      tail.next = f.ptr;
      tail = tail.next;
      if (f.ptr.next != null) {
        queue.offer(new Status(f.ptr.next.val, f.ptr.next));
      }
    }
    return head.next;
  }
}
