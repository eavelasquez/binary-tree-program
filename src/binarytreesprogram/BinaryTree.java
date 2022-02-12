/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreesprogram;

/**
 *
 * @author ev
 */
public class BinaryTree {

    private Node root; // Root of Binary Tree

    /**
     *
     */
    public BinaryTree() {
        root = null;
    }

    /**
     *
     * @param key
     */
    public BinaryTree(int key) {
        root = new Node(key);
    }

    /**
     *
     * @return
     */
    Node getRoot() {
        return root;
    }

    /**
     *
     * @param root
     */
    void setRoot(Node root) {
        this.root = root;
    }

    /**
     * This method is used to check is empty a node.
     *
     * @param node
     * @return {@code true} if this node is empty; {@code true} otherwise;
     */
    boolean isEmpty(Node node) {
        return node == null;
    }

    /**
     * This method show pre-order traversal of a binary tree.
     *
     * @param temp
     */
    private void traversePreOrder(Node node) {
        if (isEmpty(node)) {
            return;
        }

        System.out.print(node.getKey() + " ");
        traversePreOrder(node.getLeft());
        traversePreOrder(node.getRight());
    }

    void traversePreOrder() {
        if (isEmpty(root)) {
            System.out.println("The binary tree is empty.");
        }
        traversePreOrder(root);
    }

    /**
     * This method show in-order traversal of a binary tree.
     *
     * @param node
     */
    private void traverseInOrder(Node node) {
        if (isEmpty(node)) {
            return;
        }

        traverseInOrder(node.getLeft());
        System.out.print(node.getKey() + " ");
        traverseInOrder(node.getRight());
    }

    void traverseInOrder() {
        if (isEmpty(root)) {
            System.out.println("The binary tree is empty.");
        }
        traverseInOrder(root);
    }

    /**
     * This method show post-order traversal of a binary tree.
     *
     * @param node
     */
    private void traversePostOrder(Node node) {
        if (isEmpty(node)) {
            return;
        }

        traversePostOrder(node.getLeft());
        traversePostOrder(node.getRight());
        System.out.print(node.getKey() + " ");
    }

    void traversePostOrder() {
        if (isEmpty(root)) {
            System.out.println("The binary tree is empty.");
        }
        traversePostOrder(root);
    }

    /**
     * This method compute the "height" of a tree -- the number of nodes along
     * the longest path from the root node down to the farthest leaf node.
     *
     * @param root
     * @return
     */
    int height(Node root) {
        if (isEmpty(root)) {
            return 0;
        } else {
            // compute height of each subtree
            int lheight = height(root.getLeft());
            int rheight = height(root.getRight());

            // use the larger one
            return lheight > rheight ? (lheight + 1) : (rheight + 1);
        }
    }

    /**
     * This method is used to find node for given key.
     *
     * @param key
     */
    void search(int key) {
        Node temp = this.root;
        boolean isExists = false;

        while (!isEmpty(temp) && isExists == false) {
            if (key > temp.getKey()) {
                temp = temp.getRight();
            } else if (key < temp.getKey()) {
                temp = temp.getLeft();
            } else {
                isExists = true;
            }
        }

        if (isExists && !isEmpty(temp)) {
            System.out.print("The key was found: " + temp.getKey());
        } else {
            System.out.print("The key was not found in the binary tree.");
        }
    }

    /**
     * This method find node for given node in same level in a binary tree by
     * using pre-order traversal
     *
     * @param temp
     * @param key
     * @param level
     * @return
     */
    void searchLevel(Node node, int key, int level) {
        // return if tree is empty
        if (isEmpty(node)) {
            return;
        }

        if (node.getKey() == key) {
            System.out.print("The key " + key + " is at level " + level + ".");
        } else {
            searchLevel(node.getLeft(), key, level + 1);
            searchLevel(node.getRight(), key, level + 1);
        }
    }

    void searchLevel(int key, int level) {
        searchLevel(root, key, level);
    }

    /**
     * This method insert element in binary tree.
     *
     * @param key
     */
    public void insert(int key) {
        Node temp = this.root, previous = null;
        boolean isExists = false;

        while (!isEmpty(temp) && isExists == false) {
            previous = temp;

            if (key > temp.getKey()) {
                temp = temp.getRight();
            } else if (key < temp.getKey()) {
                temp = temp.getLeft();
            } else {
                isExists = true;
            }
        }

        if (isExists) {
            System.out.println("This key already exists.");
        } else {
            Node newNode = new Node(key);

            if (isEmpty(root)) {
                this.root = newNode;
            } else if (key < previous.getKey()) {
                previous.setLeft(newNode);
            } else {
                previous.setRight(newNode);
            }
        }
    }

    /**
     * 
     * @param root
     * @return
     */
    int minKey(Node root) {
        int minKey = root.getKey();

        while (!isEmpty(root.getLeft())) {
            minKey = root.getLeft().getKey();
            root = root.getLeft();
        }

        return minKey;
    }

    /**
     * 
     * @param root
     * @return
     */
    int maxKey(Node root) {
        int maxKey = root.getKey();

        while (!isEmpty(root.getRight())) {
            maxKey = root.getRight().getKey();
            root = root.getRight();
        }

        return maxKey;
    }

    /**
     * This method delete given element in binary tree.
     *
     * @param root
     * @param key
     */
    Node delete(Node root, int key) {
        // return root if tree is empty
        if (isEmpty(root)) {
            return root;
        }

        // recursive calls for ancestors of node to be deleted
        if (root.getKey() > key) {
            root.setLeft(delete(root.getLeft(), key));
            return root;
        } else if (root.getKey() < key) {
            root.setRight(delete(root.getRight(), key));
            return root;
        }

        // we reach here when root is the node to be deleted
        if (isEmpty(root.getLeft())) { // if left child is empty
            return root.getRight();
        } else if (isEmpty(root.getRight())) { // if right child is empty
            return root.getLeft();
        } else { // if both children exist
            Node successorParent = root;

            // find successor
            Node successor = root.getRight();

            while (!isEmpty(successor.getLeft())) {
                successorParent = successor;
                successor = successor.getLeft();
            }

            // delete successor.
            // if there isn't successor, then successor parent right will
            // be the right successor.
            if (successorParent != root) {
                successorParent.setLeft(successor.getRight());
            } else {
                successorParent.setRight(successor.getLeft());
            }

            // copy successor data to root
            root.setKey(successor.getKey());

            return root;
        }
    }

    Node delete(int key) {
        return delete(root, key);
    }

    /**
     * This method get the sum of values in tree with root as root
     *
     * @param node
     * @return
     */
    int sum(Node node) {
        if (isEmpty(node)) {
            return 0;
        }

        return (sum(node.getLeft()) + node.getKey() + sum(node.getRight()));
    }

    /**
     * This method to count leaf nodes.
     *
     * @param node
     * @return
     */
    int countLeafNodes(Node node) {
        if (isEmpty(node)) {
            return 0;
        }

        // if left and right of the node is null it is leaf node
        if (isEmpty(node.getLeft()) && isEmpty(node.getRight())) {
            return 1;
        } else {
            return countLeafNodes(node.getLeft()) + countLeafNodes(node.getRight());
        }
    }

    /**
     * This method check for full Binary Tree
     *
     * @param node
     * @return
     */
    boolean isFullBinaryTree(Node node) {
        if (isEmpty(node)) {
            return true;
        }

        // Checking the children
        if (isEmpty(node.getLeft()) && isEmpty(node.getRight())) {
            return true;
        }

        if (!isEmpty(node.getLeft()) && !isEmpty(node.getRight())) {
            return (isFullBinaryTree(node.getLeft()) && isFullBinaryTree(node.getRight()));
        }

        return false;
    }

    /**
     * 
     * @param node
     * @param d
     * @param level
     * @return
     */
    boolean isPerfectBinaryTree(Node node, int d, int level) {
        if (isEmpty(node)) {
            return true;
        }

        if (isEmpty(node.getLeft()) && isEmpty(node.getRight())) {
            return (d == level + 1);
        }

        if (isEmpty(node.getLeft()) || isEmpty(node.getRight())) {
            return false;
        }

        return (isPerfectBinaryTree(node.getLeft(), d, level + 1)
                && isPerfectBinaryTree(node.getRight(), d, level + 1));
    }

    /**
     * This method is a wrapper function of isPerfectBinaryTree
     *
     * @param node
     * @return
     */
    boolean isPerfectBinaryTree(Node node) {
        int d = depth(node);

        return isPerfectBinaryTree(node, d, 0);
    }

    /**
     * This method is used
     *
     * @param node
     * @param index
     * @param numberNodes
     * @return
     */
    boolean isCompleteBinaryTree(Node node, int index, int numberNodes) {
        if (isEmpty(node)) {
            return true;
        }

        return (isCompleteBinaryTree(node.getLeft(), 2 * index + 1, numberNodes)
                && isCompleteBinaryTree(node.getRight(), 2 * index + 2, numberNodes));
    }

    /**
     * This method calculate the depth.
     *
     * @param node
     * @return
     */
    int depth(Node node) {
        int d = 0;

        while (!isEmpty(node)) {
            d += 1;
            node = node.getLeft();
        }

        return d;
    }
}

/**
 * A binary tree node has key, pointer to left child and a pointer to right
 * child.
 */
class Node {

    private int key; // key
    private Node left, right; // left and right subtrees

    /**
     *
     * @param key
     */
    public Node(int key) {
        this.key = key;
        left = right = null;
    }

    /**
     *
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     *
     * @param key
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     *
     * @return
     */
    public Node getLeft() {
        return left;
    }

    /**
     *
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     *
     * @return
     */
    public Node getRight() {
        return right;
    }

    /**
     *
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }
}
