package com.interview.trees;

import com.interview.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvertBinaryTreeTest {

  private final InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

  @Test
  void invertsSampleTree() {
    TreeNode root = TreeNode.of(4, 2, 7, 1, 3, 6, 9);
    TreeNode inverted = invertBinaryTree.invertTree(root);
    assertEquals(List.of(4, 7, 2, 9, 6, 3, 1), levelOrder(inverted));
  }

  @Test
  void invertsSingleNode() {
    TreeNode root = TreeNode.of(1);
    TreeNode inverted = invertBinaryTree.invertTree(root);
    assertEquals(List.of(1), levelOrder(inverted));
  }

  private static List<Integer> levelOrder(TreeNode root) {
    if (root == null) {
      return List.of();
    }

    List<Integer> values = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      values.add(current.val);
      if (current.left != null) {
        queue.offer(current.left);
      }
      if (current.right != null) {
        queue.offer(current.right);
      }
    }

    return values;
  }
}
