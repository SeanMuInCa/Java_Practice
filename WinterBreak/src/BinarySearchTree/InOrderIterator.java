package BinarySearchTree;

import java.util.Iterator;
import java.util.Stack;

class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
    }
}

public class InOrderIterator<T> implements Iterator<T> {
    private Stack<TreeNode<T>> stack;

    public InOrderIterator(TreeNode<T> root) {
        stack = new Stack<>();
        pushAll(root);
    }

    // 将节点及其右子节点一直压入栈中
    private void pushAll(TreeNode<T> node) {
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        TreeNode<T> node = stack.pop();
        pushAll(node.left); // 将弹出节点的左子节点及其右子节点一直压入栈中
        return node.val;
    }

    // 示例用法
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(6);
        root.left.left = new TreeNode<>(1);
        root.left.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(7);

        InOrderIterator<Integer> iterator = new InOrderIterator<>(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
