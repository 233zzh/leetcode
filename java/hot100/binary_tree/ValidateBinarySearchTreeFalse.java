package hot100.binary_tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description 98. 验证二叉搜索树，写了一堆屎
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/23 21:41
 */
public class ValidateBinarySearchTreeFalse {

  public boolean isValidBST(TreeNode root) {
    return isValid(root, root.val, true);
  }

  public boolean isValid(TreeNode root, int aaa, boolean left) {
    if (root.left != null) {
      if (root.left.val < root.val) {
        if ((left && root.left.val < aaa) || (!left && root.left.val > aaa)) {
          boolean flag = isValid(root.left, root.val, true);
          if (!flag) {
            return false;
          }
        } else {
          return false;
        }
      } else {
        return false;
      }
    }
    if (root.right != null) {
      if (root.right.val > root.val) {
        if ((!left && root.right.val > aaa) || (left && root.right.val < aaa)) {
          boolean flag = isValid(root.right, root.val, false);
          if (!flag) {
            return false;
          }
        } else {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }



  public static void main(String[] args) {
    LinkedList<Integer> inputList = new LinkedList<>(
        Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
    TreeNode treeNode = BinaryTreeBFS.createBinaryTree(inputList);
    System.out.println(new ValidateBinarySearchTreeFalse().isValidBST(treeNode));

    inputList = new LinkedList<>(
        Arrays.asList(2, 1, 3));
    treeNode = BinaryTreeBFS.createBinaryTree(inputList);
    System.out.println(new ValidateBinarySearchTreeFalse().isValidBST(treeNode));

    inputList = new LinkedList<>(
        Arrays.asList(5, 1, 4, null, null, 3, 6));
    treeNode = BinaryTreeBFS.createBinaryTree(inputList);
    System.out.println(new ValidateBinarySearchTreeFalse().isValidBST(treeNode));

    inputList = new LinkedList<>(
        Arrays.asList(5, 4, 6, null, null, 3, 7));
    treeNode = BinaryTreeBFS.createBinaryTree(inputList);
    System.out.println(new ValidateBinarySearchTreeFalse().isValidBST(treeNode));
  }
}
