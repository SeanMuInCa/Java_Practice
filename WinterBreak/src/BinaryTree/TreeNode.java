package BinaryTree;

/**
 * Purpose:             BinaryTree<br />
 * Data Submitted:      2024/1/23 <br />
 * Assignment Number:    BinaryTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinaryTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
