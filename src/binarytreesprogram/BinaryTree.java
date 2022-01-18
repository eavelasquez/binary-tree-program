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
    Node temp = root; // Temp Root of Binary Tree

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
    public Node getRoot() {
        return root;
    }

    /**
     *
     * @param root
     */
    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * This method show pre-order traversal of a binary tree.
     *
     * @param temp
     */
    public void traversePreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getKey() + " ");
        traversePreOrder(node.getLeft());
        traversePreOrder(node.getRight());
    }

    /**
     * This method show in-order traversal of a binary tree.
     *
     * @param node
     */
    void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.getLeft());
        System.out.println(node.getKey() + " ");
        traverseInOrder(node.getRight());
    }

    /**
     * This method show post-order traversal of a binary tree.
     *
     * @param node
     */
    void traversePostOrder(Node node) {
        if (node == null) {
            return;
        }

        traversePostOrder(node.getLeft());
        traversePostOrder(node.getRight());
        System.out.println(node.getKey() + " ");
    }

    /**
     * This method compute the "height" of a tree -- the number of nodes along
     * the longest path from the root node down to the farthest leaf node.
     *
     * @param root
     * @return
     */
    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            // compute height of each subtree
            int lheight = height(root.getLeft());
            int rheight = height(root.getRight());

            // use the larger one
            return lheight > rheight ? (lheight + 1) : (rheight + 1);
        }
    }

    void search(int key) {
        Node temp = this.root;
        boolean isExists = false;

        while (temp != null && isExists == false) {
            if (key > temp.getKey()) {
                temp = temp.getRight();
            } else if (key < temp.getKey()) {
                temp = temp.getLeft();
            } else {
                isExists = true;
            }
        }

        if (isExists) {
            System.out.println("The key was found: " + temp.getKey());
        } else {
            System.out.println("The key was not found in the binary tree.");
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
    void searchLevel(Node temp, int key, int level) {
        // return null if tree is empty
        if (temp == null) {
            return;
        }

        if (temp.getKey() == key) {
            System.out.println("The key " + key + "is at level " + level);
        } else {
            searchLevel(temp.getLeft(), key, level + 1);
            searchLevel(temp.getRight(), key, level + 1);
        }
    }

    /**
     * This method insert element in binary tree.
     *
     * @param key
     */
    public void insert(int key) {
        Node temp = this.root, previous = null;
        boolean isExists = false;

        while (temp != null && isExists == false) {
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

            if (this.root == null) {
                this.root = newNode;
            } else if (key < previous.getKey()) {
                previous.setLeft(newNode);
            } else {
                previous.setRight(newNode);
            }
        }
    }

    /**
     * This method delete given element in binary tree.
     *
     * @param root
     * @param key
     */
    public void delete(Node root, int key) {
        if (root == null) {
        }

    }

    /**
     * This method get the sum of values in tree with root as root
     *
     * @param node
     * @return
     */
    static int sum(Node node) {
        if (node == null) {
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
        if (node == null) {
            return 0;
        }

        // if left and right of the node is null it is leaf node
        if (node.getLeft() == null && node.getRight() == null) {
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
        if (node == null) {
            return true;
        }

        // Checking the children
        if (node.getLeft() == null && node.getRight() == null) {
            return true;
        }

        if (node.getLeft() != null && node.getRight() != null) {
            return (isFullBinaryTree(node.getLeft()) && isFullBinaryTree(node.getRight()));
        }

        return false;
    }

    boolean isPerfectBinaryTree(Node node, int d, int level) {
        if (node == null) {
            return true;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return (d == level + 1);
        }

        if (node.getLeft() == null || node.getRight() == null) {
            return false;
        }

        return (isPerfectBinaryTree(node.getLeft(), d, level + 1) && isPerfectBinaryTree(node.getRight(), d, level + 1));
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
    
    boolean isCompleteBinaryTree(Node node, int index, int numberNodes) {
        if (node == null) {
            return true;
        }
        
        return (isCompleteBinaryTree(node.getLeft(), 2 * index + 1, numberNodes)
                && isCompleteBinaryTree(node.getRight(), 2 * index + 2, numberNodes));
    }

    /**
     * This method calculate the depth
     *
     * @param node
     * @return
     */
    int depth(Node node) {
        int d = 0;

        while (node != null) {
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

    private int key;
    private Node left, right;

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
