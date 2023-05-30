package offer.bigo;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/11 14:51
 */
public class LRU {

  private HashMap<Integer, ListNode> map = new HashMap<>();
  private ListNode head;
  private ListNode tail;

  private Integer size = 0;
  private Integer maxSize = 10;


  public LRU(Integer maxSize) {
    this.maxSize = maxSize;
  }

  public void putNode(Integer key, Integer value) {
    if (size.equals(maxSize) && !map.containsKey(key)) {
      remove();
    }
    ListNode node = new ListNode(key, value);
    if (head == null) {
      head = node;
      tail = node;
      size++;
      map.put(key, node);
    } else if (map.containsKey(key)) {
      node = getNode(key);
      node.value = value;
    } else {
      tail.next = node;
      node.prev = tail;
      tail = node;
      size++;
      map.put(key, node);
    }
  }

  private void remove() {
    map.remove(head.key);
    head.next.prev = null;
    head = head.next;
    size--;
  }

  public ListNode getNode(Integer key) {
    ListNode node = map.get(key);
    if (node != tail) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      node.prev = tail;
      node.next = null;
      tail = node;
    }
    return node;
  }


}

class ListNode {

  Integer key;
  Integer value;
  ListNode prev;
  ListNode next;

  ListNode(Integer key, Integer value) {
    this.key = key;
    this.value = value;
  }
}
