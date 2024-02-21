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
public class Leetcode700
{
    boolean isInBST(TreeNode<Integer> root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        // 当前节点没找到就递归地去左右子树寻找
        return root.val > target ? isInBST(root.left, target) : isInBST(root.right, target);
    }
    public TreeNode<Integer> searchBST(TreeNode<Integer> root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        else if(root.val > val) return searchBST(root.left,val);
        else return searchBST(root.right,val);
    }
}
