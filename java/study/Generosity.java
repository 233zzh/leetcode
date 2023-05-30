package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/4 11:45
 */
public class Generosity {

  public static void main(String[] args) {
    Object[] objects = new Object[2];
    objects[0] = 1;
    objects[1] = "wdwsd";
    System.out.println(Arrays.toString(objects));

    List<? extends Integer> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();
    System.out.println(list.getClass());
    System.out.println(list1.getClass());
    System.out.println((list.getClass() == list1.getClass()));
  }

}


class Node<T>{
  T data;

  public static void main(String[] args) {
    Node<Integer> node=new Node<>();
    System.out.println(node.data);
  }
}
