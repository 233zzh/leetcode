package sword_finge_roffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2022/9/24 15:43
 */
public class FindRepeatNumber {

  public static void main(String[] args) {
    int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
    int result = new FindRepeatNumber().findRepeatNumber(nums);
    System.out.println(result);

    ArrayList repeatList = new FindRepeatNumber().findRepeatNumber2(nums);
    System.out.println(repeatList);

    result = new FindRepeatNumber().findRepeatNumber3(nums);
    System.out.println(result);

    result = new FindRepeatNumber().findRepeatNumber4(nums);
    System.out.println(result);

    result = new FindRepeatNumber().findRepeatNumber5(nums);
    System.out.println(result);

    int[] array = new FindRepeatNumber().findRepeatNumber6(nums);
    System.out.println(Arrays.toString(array));
  }

  //时间复杂度：O(n)
  //空间复杂度：O(n)
  public int findRepeatNumber(int[] nums) {
    HashSet set = new HashSet();
    for (int i = 0; i < nums.length; i++) {
      boolean isSuccess = set.add(nums[i]);
      if (!isSuccess) {
        return nums[i];
      }
    }
    return -1;
  }


  public ArrayList findRepeatNumber2(int[] nums) {
    HashSet set = new HashSet();
    //长度可变
    ArrayList list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      boolean isSuccess = set.add(nums[i]);
      if (!isSuccess) {
        list.add(nums[i]);
      }
    }
    return list;
  }

  //时间复杂度O(n2)
  //空间复杂度O(1)
  public int findRepeatNumber3(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        if (num == nums[j]) {
          return num;
        }
      }
    }
    return -1;
  }

  //时间复杂度O(n)
  //空间复杂度O(1)
//  [2, 3, 1, 0, 2, 5, 3]
//    [1,3,2,0,2,5,3]
//        [3,1,2,0,2,5,3]
//        [0,1,2,3,2,5,3]

  //1、nums[index]=2  index != nums[index]则交换
  //2、index等于nums[index]   index=index+1
  //3、直到nums[index] == nums[nums[index]]，则找到重复的
  public int findRepeatNumber4(int[] nums) {
    int index = 0;
    while (index < nums.length) {
      if (index != nums[index]) {
        int tmp = nums[index]; //2
        nums[index] = nums[nums[index]];
        nums[tmp] = tmp;
      }
      if (index == nums[index]) {
        index++;
      } else if (nums[index] == nums[nums[index]]) {
        return nums[nums[index]];
      }
    }
    return -1;
  }

  //  [2, 3, 1, 0, 2, 5, 3]
//  [1, 1, 1, 1, 0, 0]
//  [1, 1, 2, 2, 0, 1, 0]
  public int findRepeatNumber5(int[] nums) {
    int[] array = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (array[num] == 0) {
        array[num] = 1;
      } else {
        return num;
      }
    }
    return -1;
  }


  public int[] findRepeatNumber6(int[] nums) {
    int[] array = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
//      array[nums[i]]++;
      int num = nums[i];
      array[num] = array[num] + 1;
//      array[num]+=1;
//      array[num]++;
//      ++array[num];
    }
    return array;
  }
}
