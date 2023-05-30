package basic;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/18 17:05
 */
public class Hero {

  public String name() {
    return "超级英雄";
  }
}

class SuperMan extends Hero {

  @Override
  public String name() {
    return "超人";
  }

  public Hero hero() {
    return new Hero();
  }
}

class SuperSuperMan extends SuperMan {

  public String name() {
    return "超级超级英雄";
  }

  @Override
  public SuperMan hero() {
    return new SuperMan();
  }
}
