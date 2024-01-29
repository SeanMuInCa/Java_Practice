package BinarySearchTree;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/1/24 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 * Postorder: Jones Peter Tom Michael Daniel Adam
 * Preorder: Adam Daniel Michael Jones Tom Peter
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestBST
{
    public static void main(String[] args)
    {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        System.out.print("Inorder: ");
        tree.inorder();
        System.out.println();
        System.out.print("Postorder: ");
        tree.postorder();
        System.out.println();
        System.out.print("Preorder: ");
        tree.preorder();
        System.out.println();

        System.out.println(tree.getSize());

        ArrayList<BST.TreeNode<String>> path = tree.path("Peter");
        for (int i = 0; i < path.size() && path != null; i++)
        {
            System.out.print(path.get(i).data + " ");
        }
        System.out.println();
        Integer[] numbers = {2, 4, 1, 5, 7, 9, 6};
        BST<Integer> integerBST = new BST<>(numbers);
        System.out.print("Inorder: ");
        integerBST.inorder();
    }

    @Test
    public void test1()
    {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        printTree(tree);

        /*System.out.println("\nAfter delete George:");
        tree.root = tree.deleteNode(tree.root, "George");
        printTree(tree);
        System.out.println("\nAfter delete Adam:");
        tree.delete("Adam");
        printTree(tree);
        System.out.println("\nAfter delete Michael:");
        tree.delete("Michael");
        printTree(tree);*/
        System.out.println(tree.getDepth(tree.root));
        System.out.println(tree.getMinDepth(tree.root));
        System.out.println(tree.getNodes(tree.root));
        System.out.println(tree.isBalance(tree.root));
        System.out.println(tree.getRoot().data);
        ArrayList<BST.TreeNode<String>> michael = tree.path("Peter");
        for (BST.TreeNode<String> n : michael)
        {
            System.out.println(n.data);
        }
        System.out.println(tree.binaryTreePaths(tree.root));
    }

    public static void printTree(BST<String> tree)
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
