package BinarySearchTree;

import java.util.*;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/2/22 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class OrdersIterator
{
    public static void main(String[] args)
    {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(11);
        root.left.left = new TreeNode<>(7);
        root.left.right = new TreeNode<>(8);
        List<TreeNode<Integer>> list1 = preorder(root);
        for (TreeNode node : list1)
        {
            System.out.println(node.data);
        }
        System.out.println();
        List<TreeNode<Integer>> list2 = postorder(root);
        for (TreeNode node : list2)
        {
            System.out.println(node.data);
        }
        System.out.println();
        List<TreeNode<Integer>> list3 = inorder(root);
        for (TreeNode node : list3)
        {
            System.out.println(node.data);
        }
        System.out.println();
        List<TreeNode<Integer>> list4 = breathorder(root);
        for (TreeNode node : list4)
        {
            System.out.println(node.data);
        }
    }

    public static <E> ArrayList<TreeNode<E>> preorder(TreeNode<E> cur)
    {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        Stack<TreeNode<E>> stack = new Stack<>();

        if (cur == null) return list;
        stack.push(cur);
        while (!stack.isEmpty())
        {
            TreeNode<E> node = stack.peek();
            if (node != null)
            {
                node = stack.pop();
                list.add(node);
            } else continue;

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }
        return list;
    }

    public static <E> ArrayList<TreeNode<E>> postorder(TreeNode<E> cur)
    {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        Stack<TreeNode<E>> stack = new Stack<>();

        if (cur == null) return list;
        stack.push(cur);
        while (!stack.isEmpty())
        {
            TreeNode<E> node = stack.peek();
            if (node != null)
            {
                node = stack.pop();
                list.add(node);
            } else continue;

            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        Collections.reverse(list);
        return list;
    }

    public static <E> ArrayList<TreeNode<E>> inorder(TreeNode<E> root)
    {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        Stack<TreeNode<E>> stack = new Stack<>();
        if (root == null) return null;
        TreeNode<E> cur = root;
        while (cur != null || !stack.isEmpty())
        {
            if (cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            } else
            {
                cur = stack.pop();
                list.add(cur);
                cur = cur.right;
            }
        }
        return list;
    }

    public static <E> ArrayList<TreeNode<E>> breathorder(TreeNode<E> root)
    {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        Queue<TreeNode<E>> queue = new LinkedList<>();
        if (root == null) return null;
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode<E> node = queue.poll();
            if (node != null)
            {
                list.add(node);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return list;
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
