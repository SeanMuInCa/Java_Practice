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
public class InvertTree
{
    public <E> TreeNode<E> invertTree(TreeNode<E> root){
        if(root == null) return null;
        TreeNode<E> temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public <E> int count(TreeNode<E> root)
    {
        if(root == null)
            return 0;
        return 1 + count(root.left) + count(root.right);
    }
    public <E> void travels(TreeNode<E> root)
    {
        if(root == null) return;
        travels(root.left);
        System.out.println(root.data);
        travels(root.right);
    }
}
