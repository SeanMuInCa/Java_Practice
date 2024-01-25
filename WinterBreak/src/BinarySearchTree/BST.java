package BinarySearchTree;

import BinaryTree.TreeNode;

import java.util.Comparator;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/1/24 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class BST<E> implements Tree<E>
{
    protected TreeNode<E> root;
    protected int size = 0;
    protected Comparator<E> c;

    public BST()
    {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }
    public BST(E[] objects)
    {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
        {
            add(objects[i]);
        }
    }
    public boolean search(E e)
    {
        TreeNode<E> cur = root;
        while (cur != null)
        {
            if(c.compare(e, cur.data) < 0)
            {
                cur = cur.left;
            } else if (c.compare(e, cur.data) > 0)
            {
                cur = cur.right;
            }else return true;
        }
        return false;
    }

    public static class TreeNode<E>
    {
        protected E data;
        protected TreeNode<E> left;
        protected TreeNode<E> right;
        public TreeNode(E e)
        {
            this.data = e;
        }
    }
}
