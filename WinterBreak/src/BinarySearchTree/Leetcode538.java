package BinarySearchTree;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/2/21 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Leetcode538
{
    TreeNode<Integer> convertBST(TreeNode<Integer> root)
    {
        traversal(root);
        return root;
    }
    int sum = 0;
    void traversal(TreeNode<Integer> root)
    {
        if(root == null) return;
        //倒叙一下
        traversal(root.right);
        sum += root.val;
        root.val = sum;
        traversal(root.left);
    }
}
