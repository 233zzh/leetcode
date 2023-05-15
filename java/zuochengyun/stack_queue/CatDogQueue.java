package zuochengyun.stack_queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 猫狗队列
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/15 15:54
 */
public class CatDogQueue {

  Deque<Pet> dogQueue;
  Deque<Pet> catQueue;

  // Dog为0，Cat为1
  List<Integer> list;

  public CatDogQueue() {
    dogQueue = new LinkedList<>();
    catQueue = new LinkedList<>();
    list = new ArrayList<>();
  }

  public void add(Pet pet) {
    if (pet instanceof Dog) {
      dogQueue.add(pet);
      list.add(0);
    } else if (pet instanceof Cat) {
      catQueue.add(pet);
      list.add(1);
    }
  }

  public Pet pollAll() {
    if (list.isEmpty()) {
      throw new RuntimeException("err: queue is empty");
    }
    if (list.remove(0) == 0) {
      return dogQueue.poll();
    } else {
      return catQueue.poll();
    }
  }

  public Dog pollDog() {
    if (isDogEmpty()) {
      throw new RuntimeException("Dog queue is empty!");
    }
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 0) {
        list.remove(i);
        break;
      }
    }
    return (Dog) dogQueue.poll();
  }

  public Cat pollCat() {
    if (isDogEmpty()) {
      throw new RuntimeException("Cat queue is empty!");
    }
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 1) {
        list.remove(i);
        break;
      }
    }
    return (Cat) catQueue.poll();
  }


  public boolean isEmpty() {
    return list.isEmpty();
  }


  public boolean isDogEmpty() {
    return dogQueue.isEmpty();
  }

  public boolean isCatEmpty() {
    return catQueue.isEmpty();
  }


  public static void main(String[] args) {
    CatDogQueue catDogQueue = new CatDogQueue();
    catDogQueue.add(new Dog());
    catDogQueue.add(new Dog());
    catDogQueue.add(new Cat());
    catDogQueue.add(new Cat());
    catDogQueue.add(new Dog());
    catDogQueue.add(new Cat());
    catDogQueue.add(new Cat());
    catDogQueue.add(new Cat());
    catDogQueue.add(new Dog());
    System.out.println(catDogQueue.list);
    catDogQueue.pollAll();
    System.out.println(catDogQueue.list);
    Pet cat = catDogQueue.pollCat();
    System.out.println(cat.getType());
    System.out.println(catDogQueue.list);
    catDogQueue.pollCat();
    System.out.println(catDogQueue.list);
  }
}


class Pet {

  private String type;

  public Pet(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }
}

class Dog extends Pet {

  public Dog() {
    super("dog");
  }
}

class Cat extends Pet {

  public Cat() {
    super("cat");
  }
}