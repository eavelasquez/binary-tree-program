/** ****************************************************************************
 * Compilation: javac BinaryTreesProgram.java
 * Execution: java BinaryTreesProgram
 *
 * Binary Trees Program.
 *
 * % java BinaryTreesProgram
 *
 ***************************************************************************** */
package binarytreesprogram;

import java.util.Scanner;

/**
 * The {@code BinaryTreesProgram} class represents a binary trees program.
 *
 * @author ev
 * @author drestrepom
 */
public class BinaryTreesProgram {

    /**
     * Unit tests the binary trees data type.
     *
     * @param args the command-line arguments (none)
     */
    public static void main(String[] args) {
        int option, key;
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        /*
         * Binary Tree Search
         *       50
         *     /   \
         *    30    70
         *   / \   / \
         * 20 40  60 80
         */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.print("\n*** MENÚ PRINCIPAL ***");
        do {
            String[] options = { "\n1. Mostrar Árbol Binario - in-order", "2. Mostrar Árbol Binario - pre-order",
                    "3. Mostrar Árbol Binario - post-order", "4. Insertar un nuevo dato", "5. Eliminar un dato",
                    "6. Buscar un dato", "7. Mostrar nivel de un dato", "0. Salir" };

            for (String opt : options) {
                System.out.print("\n" + opt);
            }
            System.out.print("\n\nDigita una opción: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("\nInorder traversal of the given tree");
                    tree.traverseInOrder();
                }
                case 2 -> {
                    System.out.println("\nPreorder traversal of the given tree");
                    tree.traversePreOrder();
                }
                case 3 -> {
                    System.out.println("\nPostorder traversal of the given tree");
                    tree.traversePostOrder();
                }
                case 4 -> {
                    System.out.print("\nEnter the data to insert: ");
                    key = sc.nextInt();
                    tree.insert(key);
                }
                case 5 -> {
                    System.out.print("\nEnter the data to delete: ");
                    key = sc.nextInt();
                    tree.delete(key);
                }
                case 6 -> {
                    System.out.print("\nEnter the data to search: ");
                    key = sc.nextInt();
                    tree.search(key);
                }
                case 7 -> {
                    System.out.print("\nEnter the data to search level: ");
                    key = sc.nextInt();
                    tree.searchLevel(key, 1);
                }
                case 8 -> {
                    System.out.println("\nShow children of the given key node");
                    tree.showChildren(80);
                }
                default -> System.exit(0);
            }
        } while (option != 0);
    }
}
