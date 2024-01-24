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
public class TextBook
{
    public static void main(String[] args)
    {
        TreeNode<Integer> root = new TreeNode<>(60);
        root.left = new TreeNode<>(55);
        root.right = new TreeNode<>(100);
        System.out.println(search(56, root));
        insert(78,root);
        System.out.println(root.right.data);
    }
    public static boolean search(Integer e, TreeNode<Integer> root)
    {
        TreeNode<Integer> cur = root;
        while (cur != null)
        {
            if(cur.data > e)
            {
                cur = cur.left;
            } else if (cur.data < e)
            {
                cur = cur.right;
            }else return true;
        }
        return false;
    }
    public boolean searchRec(Integer e, TreeNode<Integer> root)
    {
        if (root == null) {
            return false;
        }
        if(root.data > e)
        {
            return searchRec(e, root.left);
        } else if (root.data < e)
        {
            return searchRec(e, root.right);
        }else return true;
    }
    public static void insert(Integer e, TreeNode<Integer> root)
    {
        if(e > root.data && root.right != null)
        {
            insert(e,root.right);
        }else if(e > root.data && root.right == null)
        {
            root.right = new TreeNode<>(e);
        }
        if(e < root.data && root.left != null)
        {
            insert(e,root.left);
        }else if(e < root.data && root.left == null)
        {
            root.left = new TreeNode<>(e);
        }
    }

    static class TreeNode<E> {
        E data;
        TreeNode<E> left;
        TreeNode<E> right;
        TreeNode(E data) { this.data = data; }
    }
}
