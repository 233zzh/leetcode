package leetcode.linked_list;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/27 15:10
 */
public class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
