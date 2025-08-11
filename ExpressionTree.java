import java.util.*;

/**
 * Expression Tree untuk evaluasi ekspresi matematika
 * Implementasi struktur data Binary Tree untuk evaluasi ekspresi matematika
 * 
 * Fitur:
 * - Parsing ekspresi matematika ke dalam tree structure
 * - Evaluasi ekspresi menggunakan postorder traversal
 * - Visualisasi struktur tree
 * - Support untuk operator: +, -, *, /, ^
 * - Support untuk parentheses
 */
public class ExpressionTree {
    private Node root;

    /**
     * Inner class untuk representasi node dalam tree
     */
    private static class Node {
        String value;
        Node left, right;

        Node(String value) {
            this.value = value;
        }
    }

    /**
     * Evaluasi ekspresi matematika
     * 
     * @param expression Ekspresi matematika dalam bentuk string
     * @return Hasil evaluasi ekspresi
     */
    public double evaluate(String expression) {
        // Parse dan build tree
        root = buildTree(expression);
        return evaluateNode(root);
    }

    /**
     * Membangun tree dari ekspresi matematika
     * 
     * @param expression Ekspresi matematika
     * @return Root node dari tree
     */
    private Node buildTree(String expression) {
        // Bersihkan whitespace
        expression = expression.replaceAll("\\s+", "");

        // Handle kasus sederhana: (a op b)
        if (expression.startsWith("(") && expression.endsWith(")")) {
            expression = expression.substring(1, expression.length() - 1);
        }

        // Cari operator dengan prioritas terendah
        int parenCount = 0;
        int lowestPriority = Integer.MAX_VALUE;
        int lowestPriorityIndex = -1;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(')
                parenCount++;
            else if (c == ')')
                parenCount--;
            else if (parenCount == 0 && isOperator(c)) {
                int priority = getPriority(c);
                if (priority <= lowestPriority) {
                    lowestPriority = priority;
                    lowestPriorityIndex = i;
                }
            }
        }

        if (lowestPriorityIndex != -1) {
            Node node = new Node(String.valueOf(expression.charAt(lowestPriorityIndex)));
            node.left = buildTree(expression.substring(0, lowestPriorityIndex));
            node.right = buildTree(expression.substring(lowestPriorityIndex + 1));
            return node;
        } else {
            // Leaf node (number)
            return new Node(expression);
        }
    }

    /**
     * Cek apakah karakter adalah operator
     * 
     * @param c Karakter yang akan dicek
     * @return true jika operator, false jika bukan
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    /**
     * Mendapatkan prioritas operator
     * 
     * @param op Operator
     * @return Prioritas operator (semakin tinggi semakin prioritas)
     */
    private int getPriority(char op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    /**
     * Evaluasi node dalam tree menggunakan postorder traversal
     * 
     * @param node Node yang akan dievaluasi
     * @return Hasil evaluasi
     */
    private double evaluateNode(Node node) {
        if (node.left == null && node.right == null) {
            return Double.parseDouble(node.value);
        }

        double leftVal = evaluateNode(node.left);
        double rightVal = evaluateNode(node.right);

        switch (node.value) {
            case "+":
                return leftVal + rightVal;
            case "-":
                return leftVal - rightVal;
            case "*":
                return leftVal * rightVal;
            case "/":
                if (rightVal == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return leftVal / rightVal;
            case "^":
                return Math.pow(leftVal, rightVal);
            default:
                throw new IllegalArgumentException("Unknown operator: " + node.value);
        }
    }

    /**
     * Menampilkan struktur tree secara visual
     */
    public void printTree() {
        if (root == null) {
            System.out.println("Tree kosong");
            return;
        }
        printTreeRecursive(root, "", true);
    }

    /**
     * Helper method untuk menampilkan tree secara rekursif
     * 
     * @param node   Node yang akan ditampilkan
     * @param prefix Prefix untuk formatting
     * @param isLeft Apakah node adalah child kiri
     */
    private void printTreeRecursive(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.value);
            printTreeRecursive(node.left, prefix + (isLeft ? "    " : "│   "), true);
            printTreeRecursive(node.right, prefix + (isLeft ? "    " : "│   "), false);
        }
    }

    /**
     * Mendapatkan ekspresi dalam bentuk infix (inorder traversal)
     * 
     * @return Ekspresi dalam bentuk infix
     */
    public String getInfixExpression() {
        if (root == null)
            return "";
        return getInfixRecursive(root);
    }

    /**
     * Helper method untuk inorder traversal
     * 
     * @param node Node yang akan diproses
     * @return Ekspresi dalam bentuk infix
     */
    private String getInfixRecursive(Node node) {
        if (node.left == null && node.right == null) {
            return node.value;
        }

        String left = getInfixRecursive(node.left);
        String right = getInfixRecursive(node.right);

        return "(" + left + " " + node.value + " " + right + ")";
    }

    /**
     * Mendapatkan ekspresi dalam bentuk postfix (postorder traversal)
     * 
     * @return Ekspresi dalam bentuk postfix
     */
    public String getPostfixExpression() {
        if (root == null)
            return "";
        return getPostfixRecursive(root);
    }

    /**
     * Helper method untuk postorder traversal
     * 
     * @param node Node yang akan diproses
     * @return Ekspresi dalam bentuk postfix
     */
    private String getPostfixRecursive(Node node) {
        if (node.left == null && node.right == null) {
            return node.value;
        }

        String left = getPostfixRecursive(node.left);
        String right = getPostfixRecursive(node.right);

        return left + " " + right + " " + node.value;
    }

    /**
     * Mendapatkan ekspresi dalam bentuk prefix (preorder traversal)
     * 
     * @return Ekspresi dalam bentuk prefix
     */
    public String getPrefixExpression() {
        if (root == null)
            return "";
        return getPrefixRecursive(root);
    }

    /**
     * Helper method untuk preorder traversal
     * 
     * @param node Node yang akan diproses
     * @return Ekspresi dalam bentuk prefix
     */
    private String getPrefixRecursive(Node node) {
        if (node.left == null && node.right == null) {
            return node.value;
        }

        String left = getPrefixRecursive(node.left);
        String right = getPrefixRecursive(node.right);

        return node.value + " " + left + " " + right;
    }

    /**
     * Menampilkan semua representasi ekspresi
     * 
     * @param expression Ekspresi matematika
     */
    public void displayAllRepresentations(String expression) {
        try {
            evaluate(expression); // Build tree first

            System.out.println("\n=== REPRESENTASI EKSPRESI ===");
            System.out.println("Infix (Inorder): " + getInfixExpression());
            System.out.println("Prefix (Preorder): " + getPrefixExpression());
            System.out.println("Postfix (Postorder): " + getPostfixExpression());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
