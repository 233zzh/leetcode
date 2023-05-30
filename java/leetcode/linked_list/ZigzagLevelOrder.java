package leetcode.linked_list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/5/25 16:21
 */
public class ZigzagLevelOrder {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    if (root == null) {
      return ans;
    }

    Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
    nodeQueue.offer(root);
    boolean isOrderLeft = true;

    while (!nodeQueue.isEmpty()) {
      Deque<Integer> levelList = new LinkedList<Integer>();
      int size = nodeQueue.size();
      for (int i = 0; i < size; ++i) {
        TreeNode curNode = nodeQueue.poll();
        if (isOrderLeft) {
          levelList.offerLast(curNode.val);
        } else {
          levelList.offerFirst(curNode.val);
        }
        if (curNode.left != null) {
          nodeQueue.offer(curNode.left);
        }
        if (curNode.right != null) {
          nodeQueue.offer(curNode.right);
        }
      }
      ans.add(new LinkedList<Integer>(levelList));
      isOrderLeft = !isOrderLeft;
    }

    return ans;
  }
}


 class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
