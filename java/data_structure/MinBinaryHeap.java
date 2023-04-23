package data_structure;

import java.util.Arrays;

/**
 * @Description 最小二叉堆
 * <p>二叉堆是实现堆排序及优先队列的基础<br/>
 * <p>最大堆的任何一个父节点的值，都大于或等于它 左、右孩子节点的值。<br/>
 * <p>最小堆的任何一个父节点的值，都小于或等于它 左、右孩子节点的值。<br/>
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/23 16:44
 */
public class MinBinaryHeap {


  /**
   * <p>二叉堆，插入节点-递归实现</br>
   * <p>当二叉堆插入节点时，插入位置是完全二叉树的最后一个位置，之后进行自我调整</br>
   * <p>堆的插入操作是单一节点的“上浮”，堆的删除操作是单一节点的“下沉”，这两个操作的平均交换次数都是堆高度的一半，所以时间复杂度是O(logn)</br>
   *
   * @param heap
   * @param num
   * @return
   */
  public static int[] insertNode(int[] heap, int num) {
    int[] newHeap = new int[heap.length + 1];
    System.arraycopy(heap, 0, newHeap, 0, heap.length);
    newHeap[newHeap.length - 1] = num;
    upAdjust(newHeap, newHeap.length - 1);
    return newHeap;
  }

  /**
   * 上浮调整-递归实现
   *
   * @param heap
   * @param idx
   */
  private static void upAdjust(int[] heap, int idx) {
    // 堆顶，无父节点
    if (idx <= 0) {
      return;
    }
    int parent = (idx - 1) / 2;
    if (heap[parent] > heap[idx]) {
      int temp = heap[idx];
      heap[idx] = heap[parent];
      heap[parent] = temp;
      upAdjust(heap, parent);
    }
  }

  /**
   * <p>二叉堆，插入节点-非递归实现</br>
   * <p>当二叉堆插入节点时，插入位置是完全二叉树的最后一个位置，之后进行自我调整</br>
   * <p>堆的插入操作是单一节点的“上浮”，堆的删除操作是单一节点的“下沉”，这两个操作的平均交换次数都是堆高度的一半，所以时间复杂度是O(logn)</br>
   *
   * @param heap
   * @param num
   * @return
   */
  public static int[] insertNodeNonRecursive(int[] heap, int num) {
    int[] newHeap = new int[heap.length + 1];
    System.arraycopy(heap, 0, newHeap, 0, heap.length);
    newHeap[newHeap.length - 1] = num;
    upAdjust(newHeap);
    return newHeap;
  }

  /**
   * 上浮调整-非递归实现
   */
  private static void upAdjust(int[] array) {
    int childIndex = array.length - 1;
    int parentIndex = (childIndex - 1) / 2;
    // temp 保存插入的叶子节点值，用于最后的赋值
    int temp = array[childIndex];
    // 堆顶(child==0)，无父节点
    while (childIndex > 0 && temp < array[parentIndex]) {
      //无须真正交换，单向赋值即可
      array[childIndex] = array[parentIndex];
      childIndex = parentIndex;
      parentIndex = (childIndex - 1) / 2;
    }
    array[childIndex] = temp;
  }

  /**
   * <p>二叉堆，删除节点<br/>
   * <p>和插入节点正好相反，删除的是处于堆顶的节点，把堆的最后一个节点临时补到原本堆顶的位置，之后进行自我调整，让堆定节点"下沉"<br/>
   *
   * @param heap
   * @return
   */
  public static int[] deleteNode(int[] heap) {
    int[] newHeap = new int[heap.length - 1];
    System.arraycopy(heap, 1, newHeap, 1, heap.length - 2);
    newHeap[0] = heap[heap.length - 1];
    downAdjust(newHeap, 0);
    return newHeap;
  }

  /**
   * 下沉调整
   *
   * @param heap
   * @param idx
   */
  private static void downAdjust(int[] heap, int idx) {
    int left = 2 * idx + 1;
    int right = 2 * idx + 2;
    // 没有左孩子，肯定也没右孩子
    if (left >= heap.length) {
      return;
    }
    // right >= heap.length 只有左孩子，没有右孩子
    if (right >= heap.length || heap[left] < heap[right]) {
      if (heap[left] < heap[idx]) {
        int temp = heap[left];
        heap[left] = heap[idx];
        heap[idx] = temp;
        downAdjust(heap, left);
      }
    } else {
      if (heap[right] < heap[idx]) {
        int temp = heap[right];
        heap[right] = heap[idx];
        heap[idx] = temp;
        downAdjust(heap, right);
      }
    }

  }

  /**
   * 构建二叉堆 让所有非叶子节点依次“下沉” 构建堆的时间复杂度是O(n)
   *
   * @param array
   */
  public static void createHeap(int[] array) {
    int temp = array.length - 1;
    int parent = (temp - 1) / 2;
    while (parent >= 0) {
      downAdjust(array, parent);
      parent--;
    }
  }


  public static void main(String[] args) {
    System.out.println("插入节点-递归实现");
    int[] heap = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10};
    int[] insertHeap = insertNode(heap, 0);
    System.out.println(Arrays.toString(insertHeap));

    System.out.println("插入节点-非递归实现");
    heap = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10};
    insertHeap = insertNodeNonRecursive(heap, 0);
    System.out.println(Arrays.toString(insertHeap));

    int[] deleteHeap = deleteNode(heap);
    System.out.println(Arrays.toString(deleteHeap));

    int[] array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
    createHeap(array);
    System.out.println(Arrays.toString(array));
  }
}
