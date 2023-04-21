package data_structure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description 二叉树
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/20 15:48
 */
public class BinaryTree {

  /**
   * 二叉树节点
   */
  private static class TreeNode {

    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode() {
    }

    TreeNode(int data) {
      this.data = data;
    }
  }

  /**
   * 构建二叉树
   *
   * @param inputList 输入的序列
   * @return
   */
  public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
    TreeNode node = null;
    if (inputList == null || inputList.isEmpty()) {
      return null;
    }
    Integer data = inputList.removeFirst();
    if (data != null) {
      node = new TreeNode(data);
      node.leftChild = createBinaryTree(inputList);
      node.rightChild = createBinaryTree(inputList);
    }
    return node;
  }

  /**
   * 二叉树的前序遍历
   *
   * @param node 二叉树节点
   */
  public static void preOrderTraversal(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.println(node.data);
    preOrderTraversal(node.leftChild);
    preOrderTraversal(node.rightChild);
  }

  /**
   * 二叉树的中序遍历
   *
   * @param node 二叉树节点
   */
  public static void inOrderTraversal(TreeNode node) {
    if (node == null) {
      return;
    }
    inOrderTraversal(node.leftChild);
    System.out.println(node.data);
    inOrderTraversal(node.rightChild);
  }


  /**
   * 二叉树的后序遍历
   *
   * @param node 二叉树节点
   */
  public static void postOrderTraversal(TreeNode node) {
    if (node == null) {
      return;
    }
    postOrderTraversal(node.leftChild);
    postOrderTraversal(node.rightChild);
    System.out.println(node.data);
  }


  /**
   * 二叉树的前序遍历-非递归实现，利用栈实现
   *
   * @param root 二叉树根节点
   */
  public static void preOrderTraversalWithStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode treeNode = root;
    while (treeNode != null || !stack.isEmpty()) {
      //迭代访问节点的左孩子，并入栈
      while (treeNode != null) {
        System.out.println(treeNode.data);
        stack.push(treeNode);
        treeNode = treeNode.leftChild;
      }
      //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
      if (!stack.isEmpty()) {
        treeNode = stack.pop();
        treeNode = treeNode.rightChild;
      }
    }
  }

  /**
   * 二叉树的中序遍历-非递归实现，利用栈实现
   *
   * @param root 二叉树根节点
   */
  public static void inOrderTraversalWithStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode treeNode = root;
    while (treeNode != null || !stack.isEmpty()) {
      //迭代访问节点的左孩子，并入栈
      while (treeNode != null) {
        stack.push(treeNode);
        treeNode = treeNode.leftChild;
      }
      //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
      if (!stack.isEmpty()) {
        treeNode = stack.pop();
        System.out.println(treeNode.data);
        treeNode = treeNode.rightChild;
      }
    }
  }


  /**
   * 二叉树的后序遍历-非递归实现，利用栈实现
   *
   * @param root 二叉树根节点
   */
  public static void postOrderTraversalWithStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode treeNode = root;
    TreeNode prev = null;
    while (treeNode != null || !stack.isEmpty()) {
      //迭代访问节点的左孩子，并入栈
      while (treeNode != null) {
        stack.push(treeNode);
        treeNode = treeNode.leftChild;
      }
      //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
      if (!stack.isEmpty()) {
        treeNode = stack.pop();
        if (treeNode.rightChild == null || treeNode.rightChild == prev) {
          System.out.println(treeNode.data);
          prev = treeNode;
          treeNode = null;
        } else {
          stack.push(treeNode);
          treeNode = treeNode.rightChild;
        }
      }
    }
  }

  public static void main(String[] args) {
    LinkedList<Integer> inputList = new LinkedList<Integer>(
        Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
    TreeNode treeNode = createBinaryTree(inputList);
    System.out.println(" 前序遍历：");
    preOrderTraversal(treeNode);
    System.out.println(" 中序遍历：");
    inOrderTraversal(treeNode);
    System.out.println(" 后序遍历：");
    postOrderTraversal(treeNode);
    System.out.println(" 前序遍历-非递归：");
    preOrderTraversalWithStack(treeNode);
    System.out.println(" 中序遍历-非递归：");
    inOrderTraversalWithStack(treeNode);
    System.out.println(" 后序遍历-非递归：");
    postOrderTraversalWithStack(treeNode);
  }

}
