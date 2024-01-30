package BinarySearchTree;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/1/29 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestBSTInt
{
    public static void main(String[] args)
    {
        BST<Integer> tree = new BST<>();
        tree.insert(30);
        tree.insert(67);
        tree.insert(78);
        tree.insert(35);
        tree.insert(46);
        tree.insert(33);
        tree.insert(23);
        tree.insert(13);
        tree.insert(11);
        tree.insert(12);
        tree.insert(14);
        printTree(tree);
        System.out.println(tree.binaryTreePaths(tree.root));
        System.out.println(tree.sumOfLeftLeaves(tree.root));
    }
    public static void printTree(BST<Integer> tree)
    {
        // Traverse tree
        System.out.print("Inorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());
        System.out.println();
    }
}
