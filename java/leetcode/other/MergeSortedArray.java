package leetcode.other;

import java.util.Arrays;

/**
 * @Description 88. 合并两个有序数组
 * 完成的不踏实，需要看一遍官方答案
 * https://leetcode.cn/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/4 19:37
 */
public class MergeSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int idx = 0;
    int ptr1 = 0;
    int ptr2 = 0;
    while (m > 0 && n > 0) {
      while (m > 0 && n > 0 && nums1[ptr1] <= nums2[ptr2]) {
        idx++;
        ptr1++;
        m--;
      }
      while (m > 0 && n > 0 && nums2[ptr2] < nums1[ptr1]) {
        System.arraycopy(nums1, idx, nums1, idx + 1, m);
        nums1[idx++] = nums2[ptr2++];
        ptr1++;
        n--;
      }
    }
    if (m == 0) {
      System.arraycopy(nums2, ptr2, nums1, idx, n);
    }
  }


  public void merge2(int[] nums1, int m, int[] nums2, int n) {
    int ptr1 = 0;
    int ptr2 = 0;
    for (int i = 0; i < nums1.length; i++) {
      if (m == 0) {
        nums1[i] = nums2[ptr2];
        ptr2++;
      } else if (n == 0) {
        nums1[i] = nums1[ptr1];
        ptr1++;
      } else {
        if (nums2[ptr2] < nums1[ptr1]) {
          for (int j = nums1.length - 1; j > i; j--) {
            nums1[j] = nums1[j - 1];
          }
          nums1[i] = nums2[ptr2];
          ptr2++;
          ptr1++;
          n--;
        } else {
          ptr1++;
          m--;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int m = 3;
    int[] nums2 = new int[]{2, 5, 6};
    int n = 3;
    new MergeSortedArray().merge(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));
  }
}
