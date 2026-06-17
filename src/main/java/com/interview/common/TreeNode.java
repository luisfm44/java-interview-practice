package com.interview.common;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this(val, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(Integer... values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode current = queue.poll();

            if (index < values.length && values[index] != null) {
                current.left = new TreeNode(values[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                current.right = new TreeNode(values[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }
}
