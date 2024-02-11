package BinarySearchTree;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/2/11 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class LeetCode116
{
    /**
     * Populate each next pointer to point to its next right node.
     * If there is no next right node, the next pointer should be set to NULL.
     * Initially, all next pointers are set to NULL.
     */
    public Node connect(Node root)
    {
        if(root == null) return null;
        connectTwoNodes(root.left, root.right);
        return root;
    }

    private void connectTwoNodes(Node left, Node right)
    {
        if(left == null || right == null) return;
        left.next = right;
        connectTwoNodes(left.left,left.right);
        connectTwoNodes(right.left, right.right);
        connectTwoNodes(left.right, right.left);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};