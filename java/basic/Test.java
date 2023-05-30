package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/18 17:55
 */
public class Test {

  public static void main(String[] args) {
    char a = 65535;
    System.out.println(a);
    String b = String.valueOf(a);
    System.out.println(b.getBytes().length);
    System.out.println(b.length());
    System.out.println(b);
    System.out.println(Math.pow(2, 16) - 1);

    String c = "abc";
    String d = new String("abc");
    String d1 = "abc";
    String bb = "b";
    String d2 = "a" + bb + "c";
    String d3 = "a" + "b" + "c";
    String d4 = d2.intern();
    String d5 = d1 + d2 + d3;
    String d6 = bb + c + "a" + "c";
    String d7 = bb + c;
    System.out.println(c == d);
    System.out.println(c == d1);
    System.out.println(c == d2);
    System.out.println(c == d3);
    System.out.println(c == d4);
    System.out.println(d2 == d4);
    System.out.println(d == d2);

    List<Object> list = new ArrayList<>();
    list.add(1);
    System.out.println(list.get(0).getClass());

    Integer i = 2323;
    Integer j = i;
    System.out.println(i == j);
    System.out.println(i + " " + j);
    j = 22222;
    System.out.println(i + " " + j);

    Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    hashtable.put(1, 2);
    System.out.println(hashtable.get(1));
    HashMap map = new HashMap(10);
    int cc = 111;
    int aaaa = cc == 111 ? 2 : 3;
    System.out.println(Integer.toBinaryString(-1));
    int ddd = Integer.numberOfLeadingZeros(10 - 1);
    System.out.println(ddd);
    int n = -1 >>> Integer.numberOfLeadingZeros(10 - 1);
    System.out.println(n);

    String[] s = new String[]{
        "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
    };
    List<String> list1 = Arrays.asList(s);
    Collections.reverse(list1);
    System.out.println(list1);
    System.out.println(Arrays.toString(s));
    //没有指定类型的话会报错
    s = list1.toArray(new String[0]);

    String[] myArray = {"Apple", "Banana", "Orange"};
    List<String> myList = Arrays.asList(myArray);
    //上面两个语句等价于下面一条语句
    List<String> myList1 = Arrays.asList("Apple", "Banana", "Orange");
    System.out.println(myList.size());
    System.out.println(myList1.size());
    System.out.println(myList.getClass());

  }


  public static <E> void printArray(E[] inputArray) {
    for (E element : inputArray) {
      System.out.printf("%s ", element);
    }
    System.out.println();
  }


}
