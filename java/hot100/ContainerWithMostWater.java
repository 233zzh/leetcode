package hot100;

/**
 * @Description 11. 盛最多水的容器
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/12 11:30
 */
public class ContainerWithMostWater {

  // 超时
  public int maxArea(int[] height) {
    int maxArea = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = i + 1; j < height.length; j++) {
        int min = Math.min(height[i], height[j]);
        int area = (j - i) * min;
        maxArea = Math.max(maxArea, area);
      }
    }
    return maxArea;
  }


  // 双指针
  public int maxArea1(int[] height) {
    int maxArea = 0;
    int length = height.length;

    int left = 0;
    int right = length - 1;
    while (left < right) {
      int min = Math.min(height[left], height[right]);
      int area = (right - left) * min;
      maxArea = Math.max(maxArea, area);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }

    }
    return maxArea;
  }

  public static void main(String[] args) {
    int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    int maxArea = new ContainerWithMostWater().maxArea(height);
    System.out.println(maxArea);

    height = new int[]{1, 1};
    maxArea = new ContainerWithMostWater().maxArea(height);
    System.out.println(maxArea);

    height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    maxArea = new ContainerWithMostWater().maxArea1(height);
    System.out.println(maxArea);

    height = new int[]{1, 1};
    maxArea = new ContainerWithMostWater().maxArea1(height);
    System.out.println(maxArea);

  }
}
