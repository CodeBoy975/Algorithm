package com.yao.leetcode;


/**
 * 题目：给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 *
 * @author pengjie_yao
 * @date 2020/8/17 10:34
 */
public class IsBalanced {


    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 方法1： 自底而上的解法
     * 判断是否是平衡二叉树
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {

        // 自底而上的解法，类似于后序遍历
        return height(root) >= 0;
    }
    /**
     * 树的高度: 自底而上的解法
     * 时间复杂度： O(N)
     *
     * @param root
     * @return
     */
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 获取左子树的高度
        int leftHeight = height(root.left);
        // 获取右子树的高度
        int rightHeight = height(root.right);
        // -1则表示该树非平衡树
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;

        }
    }


    /**
     * 法二： 自顶而下的解法
     *
     * @param root
     * @return
     */
    public static boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * 获取树的高度
     *
     * @return
     */
    public static int height2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }





    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);

        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        node3.right = node6;
        System.out.println(isBalanced2(head));
    }

}
