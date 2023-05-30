package xiecheng;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/24 15:34
 */
public class Sort {
  //[1,4,5,6,57]

  // 分组
//  public int partion(int[] array) {
//    int left = 0;
//    int right = array.length;
//    while (left < right) {
//      if (array[right] > array[left]) {
//        int temp = array[left];
//        array[left] = array[right]
//        array[right] = temp;
//      }
//      right--;
//      left++;
//    }
//  }

  //合并
  public static void merge(int[] array, int start, int mid, int end) {
    int[] temp = new int[end - start + 1];
    int i = start;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= end) {
      if (array[i] <= array[j]) {
        temp[k++] = array[i++];
      } else {
        temp[k++] = array[j++];
      }
    }

    while (i <= mid) {
      temp[k++] = array[i++];
    }

    while (j <= end) {
      temp[k++] = array[j++];
    }

    for (i = 0; i < k; i++) {
      array[start + 1] = temp[i];
    }
  }

  public static void sort(int[] array, int start, int end) {
    if (array == null || start >= end) {
      return;
    }

    int mid = (end + start) / 2;
    sort(array, start, mid);
    sort(array, mid + 1, end);
    merge(array, start, mid, end);
  }


  public static void group(int[] array) {

  }


  public static void main(String[] args) {
    int[] array = new int[]{1, 4, 5, 8, 9, 3, 2};
    sort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
  }
}
