package BinarySearchTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

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

    public int getDepth(TreeNode<E> root)
    {
        if(root == null) return 0;
        //后序遍历
        /*int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        int depth = 1 + Math.max(leftDepth, rightDepth);
        return depth;*/
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
    public int getMinDepth(TreeNode<E> root)
    {
        if(root == null) return 0;
        int leftMinDepth = getMinDepth(root.left);
        int rightMinDepth = getMinDepth(root.right);
        if(root.left == null && root.right != null)
            return rightMinDepth + 1;
        else if(root.right == null && root.left != null)
            return leftMinDepth + 1;
        else return Math.min(leftMinDepth,rightMinDepth) + 1;
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
    @Override
    public void inorder()
    {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root)
    {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    @Override
    public void postorder()
    {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root)
    {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    @Override
    public void preorder()
    {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root)
    {
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    @Override
    public int getSize()
    {
        return size;
    }

    public TreeNode<E> getRoot()
    {
        return root;
    }

    public ArrayList<TreeNode<E>> path(E e)
    {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> cur = root;

        while (cur != null)
        {
            list.add(cur);
            if(c.compare(e, cur.data) < 0)
            {
                cur = cur.left;
            } else if (c.compare(e, cur.data) > 0)
            {
                cur = cur.right;
            }else break;
        }
        return list;
    }
    @Override
    public boolean delete(E e)
    {
        TreeNode<E> parent = null;
        TreeNode<E> cur = root;
        while (cur != null)
        {
            if (c.compare(e, cur.data) < 0)
            {
                parent = cur;
                cur = cur.left;
            } else if (c.compare(e, cur.data) > 0)
            {
                parent = cur;
                cur = cur.right;
            }else break;
        }

        if (cur == null) return false;

        if (cur.left == null)
        {
            if (parent == null)
            {
                root = cur.right;
            }else
            {
                if(c.compare(e, parent.data) < 0)
                    parent.left = cur.right;
                else parent.right = cur.right;
            }
        }else
        {
            TreeNode<E> parentOfRightMost = cur;
            TreeNode<E> rightMost = cur.left;

            while (rightMost.right != null)
            {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            cur.data = rightMost.data;

            if(parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true;
    }
    public TreeNode<E> deleteNode(TreeNode<E> root, E key)
    {
        if(root == null) return root;
        if(root.data.equals(key))
        {
            size--;
            if(root.left == null)
            {
                return root.right;
            } else if (root.right == null)
            {
                return root.left;
            }else
            {
                TreeNode<E> temp = root.right;
                while (temp.left != null)
                {
                    temp = temp.left;
                }
                temp.left = root.left;
                root = root.right;
                return root;
            }
        }
        if(c.compare(root.data, key) > 0) root.left = deleteNode(root.left, key);
        if(c.compare(root.data, key) < 0) root.right = deleteNode(root.right, key);

        return root;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new InorderIterator();
    }
    @Override
    public void clear()
    {
        root = null;
        size = 0;
    }
    private class InorderIterator implements Iterator<E>
    {
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0;
        public InorderIterator(){
            inorder();
        }
        private void inorder(){
            inorder(root);
        }
        private void inorder(TreeNode<E> root){
            if (root == null) return;
            inorder(root.left);
            list.add(root.data);
            inorder(root.right);
        }
        @Override
        public boolean hasNext()
        {
            return current < list.size();
        }
        @Override
        public E next()
        {
            return list.get(current++);
        }
        @Override
        public void remove()
        {
            if(current == 0) throw new IllegalStateException();

            delete(list.get(--current));
            list.clear();
            inorder();
        }
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
