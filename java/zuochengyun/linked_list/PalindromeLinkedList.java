package zuochengyun.linked_list;

import java.util.Stack;

/**
 * @Description 判断一个链表是否为回文结构
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/19 17:55
 */
public class PalindromeLinkedList {

  // 快慢指针找到中间位置
  // 把前一半压入栈
  // 然后遍历后一半，和栈中元素进行对比
  public boolean judgePalindromeLinkedList(Node head) {
    Stack<Integer> stack = new Stack<>();
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      stack.push(slow.data);
      slow = slow.next;
      fast = fast.next.next;
    }
    // 总共奇数个节点 ，需要跳过中间节点
    if (fast != null && fast.next == null) {
      slow = slow.next;
    }
    while (slow != null) {
      if (slow.data != stack.pop()) {
        return false;
      }
      slow = slow.next;
    }
    return true;
  }

  public static void main(String[] args) {
    Node head = new Node(-1);
    Node temp = head;
    int[] array = new int[]{1, 2, 2, 1};
    for (int i : array) {
      temp.next = new Node(i);
      temp = temp.next;
    }
    head = head.next;
    boolean result = new PalindromeLinkedList().judgePalindromeLinkedList(head);
    System.out.println(result);

    head = new Node(-1);
    temp = head;
    array = new int[]{1, 2, 3, 2, 1};
    for (int i : array) {
      temp.next = new Node(i);
      temp = temp.next;
    }
    head = head.next;
    result = new PalindromeLinkedList().judgePalindromeLinkedList(head);
    System.out.println(result);
  }
}
