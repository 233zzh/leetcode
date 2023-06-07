package zuochengyun.recursion_dp;

/**
 * @Description 斐波那契数列 https://leetcode.cn/problems/fibonacci-number/
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/17 16:21
 */
public class Fibonacci {

  //  斐波那契
  // 递归
  // O(2^n)
  public int fibonacci(int n) {
    if (n < 1) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  // 斐波那契
  // 循环
  // O(n)
  public int fibonacci1(int n) {
    if (n < 1) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    int a = 1;
    int b = 1;
    int result = 0;
    for (int i = 3; i <= n; i++) {
      result = a + b;
      a = b;
      b = result;
    }
    return result;
  }

  // 跳台阶有几种方法
  // 递归
  public int s(int n) {
    if (n < 1) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return n;
    }
    return s(n - 1) + s(n - 2);
  }

  // 跳台阶有几种方法
  // 循环
  public int s1(int n) {
    if (n < 1) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return n;
    }
    int a = 1;
    int b = 2;
    int result = 0;
    for (int i = 3; i <= n; i++) {
      result = a + b;
      a = b;
      b = result;
    }
    return result;
  }

  // 假设农场中成熟的母牛每年只会生 1 头小母牛，并且永远不会死。
  // 第一年农场有1只成熟的母牛，从第二年开始，母牛开始生小母牛。
  // 每只小母牛3年之后成熟又可以生小母牛。给定整数N，求出N年后牛的数量。
  // c(1)=1,c(2)=2,c(3)=3
  public int c(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 1 || n == 2 || n == 3) {
      return n;
    }
    return c(n - 1) + c(n - 3);
  }

  // 假设农场中成熟的母牛每年只会生 1 头小母牛，并且永远不会死。
  // 第一年农场有1只成熟的母牛，从第二年开始，母牛开始生小母牛。
  // 每只小母牛3年之后成熟又可以生小母牛。给定整数N，求出N年后牛的数量。
  // c(1)=1,c(2)=2,c(3)=3
  public int c1(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 1 || n == 2 || n == 3) {
      return n;
    }
    int a = 1;
    int b = 2;
    int c = 3;
    int result = 0;
    for (int i = 4; i <= n; i++) {
      result = a + c;
      a = b;
      b = c;
      c = result;
    }
    return result;
  }


  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.print(new Fibonacci().fibonacci1(i) + " ");
    }
    System.out.println();
    for (int i = 1; i <= 10; i++) {
      System.out.print(new Fibonacci().s1(i) + " ");
    }
    System.out.println();
    for (int i = 1; i <= 10; i++) {
      System.out.print(new Fibonacci().c1(i) + " ");
    }
  }
}
