package leetcode.other;

import java.util.Arrays;

/**
 * @Description 88. 合并两个有序数组 完成的不踏实，需要看一遍官方答案
 * https://leetcode.cn/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/4 19:37
 */
public class MergeSortedArray {

  // 直接插入到nums1中idx位置，idx后面的元素往后移，往后移的时间复杂度比较高
  // nums2的元素比较小时，插入到nums1中的idx位置，idx位置后的元素全要移动,距离nums1=[4,5,6,0,0,0,0,0],nums2=[2,2,2,2,2]
  // 时间复杂度O(m+n*m)
  // 空间复杂度O(1)
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


  // 和上面思路一样，只不过while循环变for循环
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
          // i之后的元素右移一位
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


  // 双指针。
  // 搞一个临时数组，最后再把临时数组的值更新到nums1
  // 时间复杂度 O(m+n)
  // 空间复杂度 O(m+n)
  public void merge3(int[] nums1, int m, int[] nums2, int n) {
    int[] temp = new int[m + n];
    int ptr1 = 0;
    int ptr2 = 0;
    int idx = 0;
    while (ptr1 < m || ptr2 < n) {
      if (ptr1 == m) {
        temp[idx++] = nums2[ptr2++];
      } else if (ptr2 == n) {
        temp[idx++] = nums1[ptr1++];
      } else if (nums1[ptr1] < nums2[ptr2]) {
        temp[idx++] = nums1[ptr1++];
      } else {
        temp[idx++] = nums2[ptr2++];
      }
    }
    System.arraycopy(temp, 0, nums1, 0, temp.length);
  }


  // 逆向双指针
  // 所有玩家都全力向前冲刺, 却不知道向后才是胜利之门。-《头号玩家》
  public void merge4(int[] nums1, int m, int[] nums2, int n) {
    int ptr1 = m - 1;
    int ptr2 = n - 1;
    int idx = m + n - 1;
    while (ptr1 >= 0 || ptr2 >= 0) {
      if (ptr1 < 0) {
        nums1[idx--] = nums2[ptr2--];
      } else if (ptr2 < 0) {
        nums1[idx--] = nums1[ptr1--];
      } else if (nums1[ptr1] > nums2[ptr2]) {
        nums1[idx--] = nums1[ptr1--];
      } else {
        nums1[idx--] = nums2[ptr2--];
      }
    }
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int m = 3;
    int[] nums2 = new int[]{2, 5, 6};
    int n = 3;
    new MergeSortedArray().merge4(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));
  }
}
