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
public class TreeNode<E> {
    E data;
    TreeNode<E> left;
    TreeNode<E> right;
    TreeNode(E data) { this.data = data; }
    TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
