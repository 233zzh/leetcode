package hot100.binary_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 二叉树的广度优先遍历（层序遍历）
 * <p>深度优先和广度优先这两个概念不止局限于二叉树，它们更是一种 抽象的算法思想，决定了访问某些复杂数据结构的顺序。
 * 在访问树、 图，或其他一些复杂数据结构时，这两个概念常常被使用到。<br/>
 * <p>深度优先遍历是在一个方向上“一头扎到底”，那么广度优先 遍历则恰恰相反：先在各个方向上各走出1步，再在各个方向上走出第2 步、第3步……一直到各个方向全部走完。<br/>
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
      System.out.println(root.val);
      if (root.left != null) {
        queue.offer(root.left);
      }
      if (root.right != null) {
        queue.offer(root.right);
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
        node.left = left;
      }
      temp = inputList.remove();
      if (temp != null) {
        TreeNode right = new TreeNode(temp);
        queue.offer(right);
        node.right = right;
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
