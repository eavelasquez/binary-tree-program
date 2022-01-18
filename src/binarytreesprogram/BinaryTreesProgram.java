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
//        TextIO textIO = TextIoFactory.getTextIO();
//        TextTerminal<?> terminal = textIO.getTextTerminal();
//        TerminalProperties<?> props = terminal.getProperties();
//
//        props.setPromptBold(true);
//        props.setPromptUnderline(true);
//        props.setPromptColor("cyan");
//
//        terminal.println("*** MENÚ PRINCIPAL ***");
//
//        props.setPromptUnderline(false);
//        props.setPromptBold(false);
//
//        String[] options = {"Mostrar Árbol Binario - pre-order", "Mostrar Árbol Binario - in-order",
//            "Mostrar Árbol Binario - post-order", "Insertar un nuevo dato", "Buscar un dato", "Mostrar nivel de un dato", "Salir"};
//        props.setInputColor("red");
//
//        String option
//                = textIO.newStringInputReader().withNumberedPossibleValues(options).read("Opciones");
//        props.setPromptColor("white");
//
//        String option = "Salir";
//
//        BinaryTree A = new BinaryTree();
//        int dato;
//
//        do {
//            terminal.println();
//            option = textIO.newStringInputReader().withNumberedPossibleValues(options)
//                    .read("Opciones");
//            if (option.equals(options[0])) {
//            } else if (option.equals(options[1])) {
//                if (A.getRoot() == null) {
//                    System.out.println("Arbol vacío");
//                } else {
//                    System.out.println("\nDatos en Preorden");
//                    A.traversePreOrder(A.getRoot());
//                }
//            } else if (option.equals(options[2])) {
//                if (A.getRoot() == null) {
//                    System.out.println("Arbol vacío");
//                } else {
//                    System.out.println("\nDatos en Inorden");
//                    A.traverseInOrder(A.getRoot());
//                }
//            } else if (option.equals(options[3])) {
//                if (A.getRoot() == null) {
//                    System.out.println("Arbol vacío");
//                } else {
//                    System.out.println("\nDatos en posorden");
//                    A.traversePostOrder(A.getRoot());
//                }
//            } else if (option.equals(options[4])) {
//                dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato a insertar"));
//                A.insert(dato);
//            } else if (option.equals(options[5])) {
//                dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato a buscar"));
//                A.search(dato);
//            } else if (option.equals(options[6])) {
//                dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato a para encontrar el nivel"));
//                A.searchLevel(A.getRoot(), dato, 1);
//            } else {
//                System.exit(0);
//            }
//        } while (!"Salir".equalsIgnoreCase(option));
    }
}
