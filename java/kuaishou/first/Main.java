package kuaishou.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/10 17:58
 */
public class Main {

  // 前序遍历-dfs
  public static TreeNode createTree(LinkedList<Integer> list) {
    if (list == null || list.isEmpty()) {
      return null;
    }
    TreeNode root = null;
    Integer val = list.removeFirst();
    if (val != null) {
      root = new TreeNode(val);
      root.left = createTree(list);
      root.right = createTree(list);
    }
    return root;
  }

  // 层序遍历
  public static List<Integer> bfs(TreeNode root) {
    if (root == null) {
      return null;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      result.add(node.val);
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>(
        Arrays.asList(1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null));
    TreeNode root = createTree(list);
    System.out.println(bfs(root));

    int n = 15;
    System.out.println((n >>> 1));
    System.out.println((n >>> 2));
    System.out.println((n >>> 4));
    System.out.println((n >>> 8));
  }
}

class TreeNode {

  Integer val;
  TreeNode left;
  TreeNode right;

  public TreeNode(Integer val) {
    this.val = val;
  }
}