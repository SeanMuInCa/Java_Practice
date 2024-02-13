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

public class AVLTree
{

    class node
    {
        int value;
        node left;
        node right;
        int height;

        public node()
        {

        }

        public node(int value)
        {
            this.value = value;
            this.height = 0;
        }

        public node(int value, node left, node right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    node root;// 根

    public AVLTree()
    {
        this.root = null;
    }

    public boolean isContains(int x)// 是否存在
    {
        node current = root;
        if (root == null)
        {
            return false;
        }
        while (current.value != x && current != null)
        {
            if (x < current.value)
            {
                current = current.left;
            }
            if (x > current.value)
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

    public int getHeight(node t)
    {
        if (t == null)
        {
            return -1;
        }//
        return t.height;
        //return 1+Math.max(getHeight(t.left), getHeight(t.right));这种效率太低
    }

    public void cengxu(node t)
    {//层序遍历
        Queue<node> q1 = new ArrayDeque<node>();
        if (t == null)
            return;
        if (t != null)
        {
            q1.add(t);
        }
        while (!q1.isEmpty())
        {
            node t1 = q1.poll();
            if (t1.left != null)
                q1.add(t1.left);
            if (t1.right != null)
                q1.add(t1.right);
            System.out.print(t1.value + " ");
        }
        System.out.println();
    }

    public void inorder(node t)//中序遍历 中序遍历：左子树---> 根结点 ---> 右子树
    {//为了测试改成中后都行
        if (t != null)
        {
            inorder(t.left);
            System.out.print(t.value + " ");//访问完左节点访问当前节点
            inorder(t.right);
            //System.out.print(t.value+" ");//访问完左节点访问当前节点
        }
    }

    public void preorder(node t)//前序递归 前序遍历：根结点 ---> 左子树 ---> 右子树
    {
        if (t != null)
        {
            System.out.print(t.value + " ");//当前节点
            preorder(t.left);
            preorder(t.right);
        }
    }

    public void postorder(node t)//后序递归 后序遍历： 左子树 ---> 右子树 --->根结点
    {
        if (t != null)
        {
            postorder(t.left);
            postorder(t.right);
            System.out.print(t.value + " ");//当前节点
        }
    }

    public void insert(int value)
    {
        root = insert(value, root);
    }

    public node insert(int x, node t)//插入   t是root的引用
    {
        node a1 = new node(x);
        //if(root==null) {root=a1;return root;}
        if (t == null)
        {
            return a1;
        }
        //插入操作。递归实现
        else if (t != null)
        {
            if (x < t.value)
            {
                t.left = insert(x, t.left);
            } else
            {
                t.right = insert(x, t.right);
            }
        }
        /*
         * 更新当前节点的高度，因为整个插入只有被插入的一方有影响，
         * 所以递归会更新好最底层的，上层可直接调用
         */
        t.height = Math.max(getHeight(t.left), getHeight(t.right)) + 1;//不要写成递归， 递归效率低
        return balance(t);//因为java对象传参机制，需要克隆，不可直接t=xx 否则变换
    }

    private node balance(node t)
    {
        // TODO Auto-generated method stub
        //if(t==null)return null;
        int leftHeight = getHeight(t.left);
        int rightHeight = getHeight(t.right);
        if (Math.abs(leftHeight - rightHeight) <= 1)//不需要平衡滴
        {
            return t;
        } else if (leftHeight < rightHeight)//右侧大
        {
            if (getHeight(t.right.left) < getHeight(t.right.right))//RR需要左旋
            {
                return getRRbalance(t);
            } else
            {
                return getRLbanlance(t);
            }
        } else
        {
            if (getHeight(t.left.left) > getHeight(t.left.right))//ll 左左
            {
                return getLLbalance(t);
            } else
            {
                return getLRbanlance(t);
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

    private node getRRbalance(node oldroot)
    {//右右深，需要左旋
        // TODO Auto-generated method stub
        node newroot = oldroot.right;
        oldroot.right = newroot.left;
        newroot.left = oldroot;
        oldroot.height = Math.max(getHeight(oldroot.left), getHeight(oldroot.right)) + 1;
        newroot.height = Math.max(getHeight(newroot.left), getHeight(newroot.right)) + 1;//原来的root的高度需要从新计算
        return newroot;
    }

    /*
     * 右旋同理
     */
    private node getLLbalance(node oldroot)
    {//LL小，需要右旋转
        // TODO Auto-generated method stub
        node newroot = oldroot.left;
        oldroot.left = newroot.right;
        newroot.right = oldroot;
        oldroot.height = Math.max(getHeight(oldroot.left), getHeight(oldroot.right)) + 1;
        newroot.height = Math.max(getHeight(newroot.left), getHeight(newroot.right)) + 1;//原来的root的高度需要从新金酸
        return newroot;
    }

    private node getLRbanlance(node oldroot)
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

    private node getRLbanlance(node oldroot)
    {//右左深
        oldroot.right = getLLbalance(oldroot.right);
        oldroot.height = Math.max(getHeight(oldroot.left), getHeight(oldroot.right)) + 1;
        return getRRbalance(oldroot);
    }
}
