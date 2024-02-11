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
public class LeetCode654
{
    /**
     * You are given an integer array nums with no duplicates.
     * A maximum binary tree can be built recursively from nums using the following algorithm:
     *
     * Create a root node whose value is the maximum value in nums.
     * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
     * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
     * Return the maximum binary tree built from nums.
     */
    public TreeNode constructMaximumBinaryTree(int[] nums)
    {
        if(nums.length == 0) return null;
        int maxVal = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        int[] left = new int[index];
        int[] right = new int[nums.length - index - 1];
        System.arraycopy(nums,0,left,0,index);//cause slow
        System.arraycopy(nums,index + 1,right,0, right.length);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);

        return root;
    }
    public TreeNode constructMaximumBinaryTree1(int[] nums)
    {
        return build(nums,0,nums.length - 1);//better solution, don't need to create new array
    }

    private TreeNode build(int[] nums, int left, int right)
    {
        if(left > right) return null;
        int maxVal = Integer.MIN_VALUE;
        int index = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums,left,index - 1);
        root.right = build(nums, index + 1, right);

        return root;
    }

}
