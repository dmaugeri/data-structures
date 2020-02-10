package ca.dmaugeri.datastructures.bst;

import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private BinarySearchTreeNode<T> root;

    public BinarySearchTree() {
    }

    public void insert(T element) {
        root = insert(root, element);
    }

    private BinarySearchTreeNode<T> insert(BinarySearchTreeNode<T> subRoot, T value) {
        if (subRoot == null) {
            subRoot = new BinarySearchTreeNode<T>(value);
            return subRoot;
        }

        if (value.compareTo(subRoot.getValue()) < 0) {
            subRoot.setLeft(insert(subRoot.getLeft(), value));
        } else if (value.compareTo(subRoot.getValue()) >= 0) {
            subRoot.setRight(insert(subRoot.getRight(), value));
        }

        return subRoot;
    }

    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(root, consumer);
    }

    private void inOrderTraversal(BinarySearchTreeNode<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft(), consumer);
        consumer.accept(node.getValue());
        inOrderTraversal(node.getRight(), consumer);
    }
}