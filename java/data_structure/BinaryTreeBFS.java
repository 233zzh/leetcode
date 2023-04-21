package data_structure;

import static data_structure.BinaryTreeDFS.createBinaryTree;

import data_structure.BinaryTreeDFS.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/21 17:00
 */
public class BinaryTreeBFS {

  /**
   * 二叉树的层序遍历
   *
   * @param root 二叉树根节点
   */
  public static void levelOrderTravesal(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      root = queue.poll();
      System.out.println(root.data);
      if (root.leftChild != null) {
        queue.offer(root.leftChild);
      }
      if (root.rightChild != null) {
        queue.offer(root.rightChild);
      }
    }
  }

  public static void main(String[] args) {
    LinkedList<Integer> inputList = new LinkedList<>(
        Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
    TreeNode treeNode = createBinaryTree(inputList);
    levelOrderTravesal(treeNode);
  }
}
