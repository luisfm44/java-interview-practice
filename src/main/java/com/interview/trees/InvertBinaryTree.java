package com.interview.trees;

import com.interview.common.TreeNode;

/**
 * LeetCode 226 - Invert Binary Tree.
 * Intercambia hijos izquierdo y derecho en cada nodo.
 *
 * PATRON: Recursion DFS — invertir subarboles y swap de hijos.
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invertTree(TreeNode.of(4, 2, 7, 1, 3, 6, 9));
    }

    public TreeNode invertTree(TreeNode root) {
        return invertTreeImperative(root);
    }

    public TreeNode invertTreeImperative(TreeNode root) {
        if (root == null) {
            return null; // arbol vacio
        }

        TreeNode left = root.left;
        root.left = invertTreeImperative(root.right); // hijo izquierdo = subarbol derecho invertido
        root.right = invertTreeImperative(left); // hijo derecho = subarbol izquierdo invertido
        return root;
    }

    public TreeNode invertTreeFunctional(TreeNode root) {
        if (root == null) {
            return null;
        }
        // crea un nodo nuevo con hijos invertidos recursivamente
        return new TreeNode(
            root.val,
            invertTreeFunctional(root.right),
            invertTreeFunctional(root.left));
    }
}
