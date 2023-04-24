package data_structure;

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

  /**
   * 构建二叉树-层序遍历
   *
   * @param inputList 输入的序列
   * @return
   */
  public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = null;
    if (inputList.size() > 0) {
      root = new TreeNode(inputList.remove());
      queue.offer(root);
    }
    TreeNode node;
    while (!queue.isEmpty() && inputList.size() != 0) {
      node = queue.poll();
      Integer temp = inputList.remove();
      if (temp != null) {
        TreeNode left = new TreeNode(temp);
        queue.offer(left);
        node.leftChild = left;
      }
      temp = inputList.remove();
      if (temp != null) {
        TreeNode right = new TreeNode(temp);
        queue.offer(right);
        node.rightChild = right;
      }
    }
    return root;
  }

  public static void main(String[] args) {
    LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(5, 1, 4, null, null, 3, 6));
    TreeNode treeNode = createBinaryTree(inputList);
    levelOrderTravesal(treeNode);
  }
}
