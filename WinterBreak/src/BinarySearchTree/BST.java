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
    @Override
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

    @Override
    public boolean insert(E e)
    {
        if(root == null)
        {
            root = createNewNode(e);
        }else
        {
            TreeNode<E> parent = null;
            TreeNode<E> cur = root;
            while (cur != null)
            {
                if(c.compare(e, cur.data) < 0)
                {
                    parent = cur;
                    cur = cur.left;
                } else if (c.compare(e, cur.data) > 0)
                {
                    parent = cur;
                    cur = cur.right;
                }else return false;
            }
            if(c.compare(e, parent.data) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }
    protected TreeNode<E> createNewNode(E e)
    {
        return new TreeNode<>(e);
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
