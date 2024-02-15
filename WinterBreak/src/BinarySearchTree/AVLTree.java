package BinarySearchTree;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/2/12 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class AVLTree<E extends Comparable<E>>
{

    static class node<E>
    {
        E value;
        node<E> left;
        node<E> right;
        int height;

        public node()
        {

        }

        public node(E value)
        {
            this.value = value;
            this.height = 0;
        }

        public node(E value, node<E> left, node<E> right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    node<E> root;// 根

    public AVLTree()
    {
        this.root = null;
    }

    public boolean contains(E x)// 是否存在
    {
        node<E> current = root;
        if (root == null)
        {
            return false;
        }
        while (!current.value.equals(x) && current != null)
        {
            if (x.compareTo(current.value) < 0)
            {
                current = current.left;
            }
            if (x.compareTo(current.value) > 0)
            {
                current = current.right;
            }
            if (current == null)
            {
                return false;
            } // 在里面判断如果超直接返回
        }
        // 如果在这个位置判断是否为空会导致current.value不存在报错
        if (current.value == x)
        {
            return true;
        }
        return false;
    }

    public int getHeight(node<E> node)
    {
        if (node == null)
        {
            return -1;
        }//
        return node.height;
        //return 1+Math.max(getHeight(t.left), getHeight(t.right));这种效率太低
    }

    public void cengxu(node<E> node)
    {//层序遍历
        Queue<node<E>> q1 = new ArrayDeque<node<E>>();
        if (node == null)
            return;
        if (node != null)
        {
            q1.add(node);
        }
        while (!q1.isEmpty())
        {
            node<E> node1 = q1.poll();
            if (node1.left != null)
                q1.add(node1.left);
            if (node1.right != null)
                q1.add(node1.right);
            System.out.print(node1.value + " ");
        }
        System.out.println();
    }

    public void inorder(node<E> node)//中序遍历 中序遍历：左子树---> 根结点 ---> 右子树
    {//为了测试改成中后都行
        if (node != null)
        {
            inorder(node.left);
            System.out.print(node.value + " ");//访问完左节点访问当前节点
            inorder(node.right);
            //System.out.print(t.value+" ");//访问完左节点访问当前节点
        }
    }

    public void preorder(node<E> node)//前序递归 前序遍历：根结点 ---> 左子树 ---> 右子树
    {
        if (node != null)
        {
            System.out.print(node.value + " ");//当前节点
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(node<E> node)//后序递归 后序遍历： 左子树 ---> 右子树 --->根结点
    {
        if (node != null)
        {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");//当前节点
        }
    }

    public void insert(E value)
    {
        root = insert(value, root);
    }

    public node<E> insert(E x, node<E> node)//插入   t是root的引用
    {
        node<E> a1 = new node<>(x);
        //if(root==null) {root=a1;return root;}
        if (node == null)
        {
            return a1;
        }
        //插入操作。递归实现
        else if (node != null)
        {
            if (x.compareTo(node.value) < 0)
            {
                node.left = insert(x, node.left);
            } else
            {
                node.right = insert(x, node.right);
            }
        }
        /*
         * 更新当前节点的高度，因为整个插入只有被插入的一方有影响，
         * 所以递归会更新好最底层的，上层可直接调用
         */
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;//不要写成递归， 递归效率低
        return balance(node);//因为java对象传参机制，需要克隆，不可直接t=xx 否则变换
    }

    private node<E> balance(node<E> node)
    {
        // TODO Auto-generated method stub
        //if(t==null)return null;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (Math.abs(leftHeight - rightHeight) <= 1)//不需要平衡滴
        {
            return node;
        } else if (leftHeight < rightHeight)//右侧大
        {
            if (getHeight(node.right.left) < getHeight(node.right.right))//RR需要左旋
            {
                return getRRbalance(node);
            } else
            {
                return getRLbanlance(node);
            }
        } else
        {
            if (getHeight(node.left.left) > getHeight(node.left.right))//ll 左左
            {
                return getLLbalance(node);
            } else
            {
                return getLRbanlance(node);
            }
        }
    }
    /*
     *        oldroot(平衡因子为2,不平衡)    ==>   newroot
     *       /    \                              /    \
     *      B     newroot(平衡因子为1)        oldroot   D
     *             /    \                      / \      \
     *            C      D                    B   C      E
     *                    \
     *                     E
     */

    private node<E> getRRbalance(node<E> oldroot)
    {//右右深，需要左旋
        // TODO Auto-generated method stub
        node<E> newroot = oldroot.right;
        oldroot.right = newroot.left;
        newroot.left = oldroot;
        oldroot.height = Math.max(getHeight(oldroot.left), getHeight(oldroot.right)) + 1;
        newroot.height = Math.max(getHeight(newroot.left), getHeight(newroot.right)) + 1;//原来的root的高度需要从新计算
        return newroot;
    }

    /*
     * 右旋同理
     */
    private node<E> getLLbalance(node<E> oldroot)
    {//LL小，需要右旋转
        // TODO Auto-generated method stub
        node<E> newroot = oldroot.left;
        oldroot.left = newroot.right;
        newroot.right = oldroot;
        oldroot.height = Math.max(getHeight(oldroot.left), getHeight(oldroot.right)) + 1;
        newroot.height = Math.max(getHeight(newroot.left), getHeight(newroot.right)) + 1;//原来的root的高度需要从新金酸
        return newroot;
    }

    private node<E> getLRbanlance(node<E> oldroot)
    {
        oldroot.left = getRRbalance(oldroot.left);
        oldroot.height = Math.max(getHeight(oldroot.left), getHeight(oldroot.right)) + 1;
        return getLLbalance(oldroot);
    }

    /*          (不平衡出现在右左节点)
     *         oldroot       ==>          newroot
     *        /        \                 /       \
     *       A          B             oldroot     B
     *                /   \           /    \     /  \
     *           newroot   D         A      E    F   D
     *            /   \
     *           E     F
     */

    private node<E> getRLbanlance(node<E> oldroot)
    {//右左深
        oldroot.right = getLLbalance(oldroot.right);
        oldroot.height = Math.max(getHeight(oldroot.left), getHeight(oldroot.right)) + 1;
        return getRRbalance(oldroot);
    }
}
