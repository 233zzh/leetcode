package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 1606. 找到处理最多请求的服务器 暴力法，使用了递归
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2022/3/30 21:31
 */
public class BusiestServers {

  public static void main(String[] args) {
    int k = 3;
    int[] arrival = new int[]{1, 2, 3, 4, 5};
    int[] load = new int[]{5, 2, 3, 3, 3};
    List<Integer> test = new BusiestServers().busiestServers(k, arrival, load);
    System.out.println(test);

//    int k = 3;
//    int[] arrival = new int[]{1, 2, 3, 4, 8, 9, 10};
//    int[] load = new int[]{5, 2, 10, 3, 1, 2, 2};
//    List<Integer> test = new BusiestServers().busiestServers(k, arrival, load);
//    System.out.println(test);
  }

  public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
    int[] serverTimes = new int[k];//空间复杂度：O(k)
    int[] serverNums = new int[k];
    for (int i = 0; i < arrival.length; i++) {//时间复杂度，O(nk)
      recurse(i, i, arrival, load, serverTimes, serverNums);
    }

    int[] newServerNums = new int[k];
    System.arraycopy(serverNums, 0, newServerNums, 0, k);
    Arrays.sort(newServerNums);//快排，时间复杂度 O(klogk)
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      if (serverNums[i] == newServerNums[k - 1]) {
        results.add(i);
      }
    }
    //System.out.println(Arrays.toString(serverNums));
    return results;
  }

  private void recurse(int index, int newIndex, int[] arrival, int[] load, int[] serverTimes,
      int[] serverNums) {
    int server = newIndex % serverNums.length;
    if (index < arrival.length && newIndex - index < serverTimes.length) {
      if (serverTimes[server] > arrival[index]) {
        recurse(index, ++newIndex, arrival, load, serverTimes, serverNums);
      } else {
        serverTimes[server] = arrival[index] + load[index];
        serverNums[server]++;
      }
    }
  }
}
