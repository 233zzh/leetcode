package hot100.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 94. 二叉树的中序遍历
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/19 20:07
 */
public class BinaryTreeInorderTraversal {

  /**
   * 迭代
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      if (!stack.isEmpty()) {
        root = stack.pop();
        res.add(root.val);
        root = root.right;
      }
    }
    return res;
  }


  /**
   * 递归
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inorderTraverse(root, res);
    return res;
  }


  public void inorderTraverse(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    inorderTraverse(root.left, res);
    res.add(root.val);
    inorderTraverse(root.right, res);
  }


  public static void main(String[] args) {

  }
}
