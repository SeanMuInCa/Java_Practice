package BinaryTree;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

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
    //todo 这里有点不清楚，我得捋一下
    public static void main(String[] args)
    {
        TreeNode<Integer> root = new TreeNode<>(60);
        root.left = new TreeNode<>(55);
        root.right = new TreeNode<>(100);
        System.out.println(search(56, root));
        insert(78,root);
        System.out.println(preorder(root));
        System.out.println(inorder(root));
    }
    public static List<Integer> preorder(TreeNode<Integer> root){
        List<Integer> list = new Vector<>();
        return preorder(root, list);
    }

    private static List<Integer> preorder(TreeNode<Integer> root, List<Integer> list)
    {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty())
        {
            TreeNode<Integer> temp = st.pop();
            if(temp != null)
            {
                list.add(temp.data);
            }else continue;
            if(temp.right != null) st.push(temp.right);
            if(temp.left != null) st.push(temp.left);
        }
        return list;
    }

    public static List<Integer> inorder(TreeNode<Integer> root){
        List<Integer> list = new Vector<>();
        return inorder(root, list);
    }

    private static List<Integer> inorder(TreeNode<Integer> root, List<Integer> list)
    {
        Stack<TreeNode> st = new Stack<>();
        TreeNode<Integer> cur = root;
        while (cur != null || !st.empty())
        {
           if(cur != null)
           {
               st.push(cur);
               cur = cur.left;
           }else
           {
               cur = st.pop();
               list.add(cur.data);
               cur = cur.right;
           }
        }
        return list;
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
