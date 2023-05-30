package xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/24 15:24
 */
public class MysStack<T> {

  List<T> list;

  public MysStack() {
    list = new ArrayList<>();
  }

  public MysStack(int size) {
    list = new ArrayList<>(size);
  }

  public void push(T data) {
    list.add(data);
  }

  public T pop() {
    return list.remove(list.size() - 1);
  }

  public static void main(String[] args) {
    MysStack<Integer> mysStack = new MysStack<>(10);
    mysStack.push(1);
    mysStack.push(2);
    mysStack.push(3);
    mysStack.push(4);
    System.out.println(mysStack.pop());
  }

}
