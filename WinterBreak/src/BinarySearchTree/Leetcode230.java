package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/2/21 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Leetcode230
{
    //find the smallest k
    public int kthSmallest(TreeNode<Integer> root, int k) {
        List<TreeNode<Integer>> list = new ArrayList<>();
        traversal(root,list);
        return list.get(k - 1).val;
    }
    void traversal(TreeNode root, List list)
    {
        traversal(root.left,list);
        list.add(root);
        traversal(root.right,list);
    }
}
