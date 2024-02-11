package BinarySearchTree;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/2/11 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class LeetCode114
{
    /**
     * Given the root of a binary tree, flatten the tree into a "linked list":
     * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
     */
    public static void flatten(TreeNode root)
    {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }



    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left= new TreeNode(3);
        root.left.right= new TreeNode(4);
        root.right.right= new TreeNode(6);
        flatten(root);
        while (root != null)
        {
            System.out.println(root.val);
            root = root.right;
        }
    }
}
