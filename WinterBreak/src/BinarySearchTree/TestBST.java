package BinarySearchTree;

import java.util.ArrayList;

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
public class TestBST
{
    public static void main(String[] args)
    {
        BST<String> tree = new BST<>();tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        System.out.print("Inorder: ");
        tree.inorder();
        System.out.println();
        System.out.print("Preorder: ");
        tree.preorder();
        System.out.println();
        System.out.print("Postorder: ");
        tree.postorder();
        System.out.println();

        System.out.println(tree.getSize());

        ArrayList<BST.TreeNode<String>> path = tree.path("Peter");
        for (int i = 0; i < path.size() && path != null; i++)
        {
            System.out.print(path.get(i).data + " ");
        }
        System.out.println();
        Integer[] numbers = {2,4,1,5,7,9,6};
        BST<Integer> integerBST = new BST<>(numbers);
        System.out.print("Inorder: ");
        integerBST.inorder();
    }
}