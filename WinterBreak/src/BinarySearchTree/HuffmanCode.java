package BinarySearchTree;

/**
 * Purpose:             BinarySearchTree<br />
 * Data Submitted:      2024/1/27 <br />
 * Assignment Number:    BinarySearchTree<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          BinarySearchTree <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class HuffmanCode
{
    public static void main(String[] args)
    {
        String str = "welcome";
        int[] counts = getCharacterFrequency(str);

        System.out.printf("%-15s%-15s%-15s%-15s\n", "ASCII Code", "Character", "Frequency", "Code");

        Tree tree = getHuffmanTree(counts);
        String[] codes = getCode(tree.root);

        for (int i = 0; i < codes.length; i++)
        {
            if(counts[i] != 0)
                System.out.printf("%-15s%-15s%-15s%-15s\n", i , (char)i + "", counts[i], codes[i]);
        }
    }

    public static String[] getCode(Tree.Node root)
    {
        if(root == null) return null;
        String[] codes = new String[128];
        assignCode(root, codes);
        return codes;
    }
     private static void assignCode(Tree.Node root, String[] codes)
     {
         if (root.left != null)
         {
             root.left.code = root.code + "0";
             assignCode(root.left, codes);

             root.right.code = root.code + "1";
             assignCode(root.right, codes);
         } else
         {
             codes[(int) root.element] = root.code;
         }
     }

     public static Tree getHuffmanTree(int[] counts)
     {
         Heap<Tree> heap = new Heap<>();
         for (int i = 0; i < counts.length; i++)
         {
             if(counts[i] > 0)
                 heap.add(new Tree(counts[i], (char)i));
         }
         while (heap.getSize() > 1)
         {
             Tree t1 = heap.remove();
             Tree t2 = heap.remove();
             heap.add(new Tree(t1,t2));
         }
         return heap.remove();
     }
    private static int[] getCharacterFrequency(String str)
    {
    }
}
