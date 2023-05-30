package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/17 18:37
 */
public class TestClone {

  private String a;

  public TestClone(String a) {
    this.a = a;
  }

  public String getA() {
    return a;
  }

  public void setA(String a) {
    this.a = a;
  }

//  @Override
//  public String toString() {
//    return "TestClone{" +
//        "a='" + a + '\'' +
//        '}';
//  }

  public static void main(String[] args) {
    List<TestClone> listA = new ArrayList<>();
    TestClone testClone = new TestClone("a");
    listA.add(testClone);
    List<TestClone> listB = new ArrayList<>(listA);
    System.out.println(listB);
    listB.get(0).setA("dwdwdwdw");
    System.out.println(listA);
    System.out.println(listB);

    listA.get(0).setA("2333232");
    System.out.println(listA);
    System.out.println(listB);

    List<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);

    List<Integer> b = new ArrayList<>(a);
    System.out.println(b);

    List<List<Integer>> c = new ArrayList<>();
    c.add(a);
    System.out.println(c);

    a.add(34343);
    System.out.println(c);
    System.out.println(b);

  }
}
