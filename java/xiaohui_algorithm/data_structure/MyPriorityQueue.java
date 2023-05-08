package xiaohui_algorithm.data_structure;

import java.util.Arrays;

/**
 * @Description 最小优先队列
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/23 20:05
 */
public class MyPriorityQueue {

  private int[] array;
  private int size;

  public MyPriorityQueue() {
    // 队列初始长度未32
    array = new int[32];
  }

  /**
   * 入队
   *
   * @param key 入队元素
   */
  public void enQueue(int key) {
    // 队列长度超出范围，扩容
    if (size >= array.length) {
      resize();
    }
    array[size++] = key;
    upAdjust();
  }

  /**
   * 上浮调整
   */
  private void upAdjust() {
    int childIndex = size - 1;
    int parentIndex = (childIndex - 1) / 2;
    // temp 保存插入的叶子节点值，用于最后的赋值
    int temp = array[childIndex];
    // 堆顶(child==0)，无父节点
    while (childIndex > 0 && temp < array[parentIndex]) {
      //无须真正交换，单向赋值即可
      array[childIndex] = array[parentIndex];
      childIndex = parentIndex;
      parentIndex = (parentIndex - 1) / 2;
    }
    array[childIndex] = temp;
  }

  /**
   * 队列扩容
   */
  private void resize() {
    // 容量翻备
    int newSize = this.size * 2;
    array = Arrays.copyOf(array, newSize);
  }

  /**
   * 出队
   *
   * @return
   * @throws Exception
   */
  public int deQueue() throws Exception {
    if (size <= 0) {
      throw new Exception("the queue is empty !");
    }
    // 获取堆顶元素
    int head = array[0];
    // 让最后一个元素移动到堆顶
    array[0] = array[size - 1];
    size--;
    downAdjust(0);
    return head;
  }


  /**
   * 下沉调整
   *
   * @param idx
   */
  private void downAdjust(int idx) {
    int left = 2 * idx + 1;
    int right = 2 * idx + 2;
    // 没有左孩子，肯定也没右孩子
    if (left >= size) {
      return;
    }
    // right >= heap.length 只有左孩子，没有右孩子
    if (right >= size || array[left] < array[right]) {
      if (array[left] < array[idx]) {
        int temp = array[left];
        array[left] = array[idx];
        array[idx] = temp;
        downAdjust(left);
      }
    } else {
      if (array[right] < array[idx]) {
        int temp = array[right];
        array[right] = array[idx];
        array[idx] = temp;
        downAdjust(right);
      }
    }
  }


  public static void main(String[] args) throws Exception {
    MyPriorityQueue priorityQueue = new MyPriorityQueue();
    priorityQueue.enQueue(3);
    priorityQueue.enQueue(5);
    priorityQueue.enQueue(10);
    priorityQueue.enQueue(2);
    priorityQueue.enQueue(7);
    System.out.println(" 出队元素：" + priorityQueue.deQueue());
    System.out.println(" 出队元素：" + priorityQueue.deQueue());

  }
}

