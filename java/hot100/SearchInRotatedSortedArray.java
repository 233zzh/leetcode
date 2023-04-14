package hot100;

/**
 * @Description 33. 搜索旋转排序数组
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/13 20:05
 */
public class SearchInRotatedSortedArray {

  // 4 5 6 7 8 1 2 3 middle在左半区，nums[middle] > nums[right]
  // 7 8 1 2 3 4 5 6 middle在右半区，nums[middle] < nums[left]
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      if (nums[middle] == target) {
        return middle;
      } else if (nums[middle] < target) {
        // middle在右半区, target在左半区
        // nums[middle] < nums[right]没办法表明这是一个旋转的数组，因为正常有序数据就是这样的
        if (nums[middle] < nums[left] && target >= nums[left]) {
          right = middle - 1;
        } else {
          left = middle + 1;
        }
      } else if (nums[middle] > target) {
        // middle在左半区, target在右半区
        // nums[middle] > nums[left]没办法表明这是一个旋转的数组，因为正常有序数据就是这样的
        if (nums[middle] > nums[right] && target <= nums[right]) {
          left = middle + 1;
        } else {
          right = middle - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 3, 4, 5, 8, 9, 10};
    System.out.println(new SearchInRotatedSortedArray().search(nums, 4));

    nums = new int[]{4, 5, 6, 7, 0, 1, 2};
    System.out.println(new SearchInRotatedSortedArray().search(nums, 0));

    nums = new int[]{4, 5, 6, 7, 0, 1, 2};
    System.out.println(new SearchInRotatedSortedArray().search(nums, 3));

    nums = new int[]{1};
    System.out.println(new SearchInRotatedSortedArray().search(nums, 0));

    nums = new int[]{1, 3};
    System.out.println(new SearchInRotatedSortedArray().search(nums, 3));

    nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
    System.out.println(new SearchInRotatedSortedArray().search(nums, 8));
  }
}
