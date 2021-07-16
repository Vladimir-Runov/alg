
public class Node {
    private int value;
    private Node left;
    private Node right;

    public static void PrintRecursie(Node root)
    {
        if (root == null)
            return;

        PrintRecursie(root.left);
        System.out.print(root.value + " ");
        PrintRecursie(root.right);
    }

    public static Node insert(Node root, int value)
    {
        Node yNode = null, newNode = new Node(value);
        for (Node x = root; x != null; ) {
            yNode = x;
            if (value < x.value)
                x = x.left;
            else
                x = x.right;
        }
        if (yNode == null)              yNode = newNode;
        else if (value < yNode.value)   yNode.left = newNode;
        else                            yNode.right = newNode;

        return yNode;
    }
    public static class BalancedResult {
        private boolean isBalanced;
        private int height;

        @Override
        public String toString() {
            return "Balanced " + isBalanced + " h=" + height;
        }

        private BalancedResult(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public static BalancedResult isBalancedRecursive(Node root, int depth) {
        if (root == null) {
            return new BalancedResult(true,-1);
        }
        BalancedResult leftSubtreeResult = isBalancedRecursive(root.left, depth + 1);
        BalancedResult rightSubtreeResult = isBalancedRecursive(root.right, depth + 1);

        boolean isBalanced = Math.abs(leftSubtreeResult.height - rightSubtreeResult.height) <= 1;
        boolean subtreesAreBalanced = leftSubtreeResult.isBalanced && rightSubtreeResult.isBalanced;
        int height = Math.max(leftSubtreeResult.height, rightSubtreeResult.height) + 1;

        return new BalancedResult(isBalanced && subtreesAreBalanced, height);
    }

    public static int countChildren(Node node)
    {
        if ( node == null )
            return 0;
        return 1 + countChildren(node.left) + countChildren(node.right);
    }
    public static int getHeight(Node root)
    {
        if(root!=null)
            return 1+ Math.max(getHeight(root.left),getHeight(root.right));
        return 0;
    }

    public static int MaxDepth(Node node) {
        if (node == null)
            return 0;
        // compute the depth of each subtree
        int leftDepth = MaxDepth(node.left);
        int rightDepth = MaxDepth(node.right);
        // use the larger one
        if (leftDepth > rightDepth )
            return (leftDepth + 1);
        else
            return (rightDepth + 1);

    }

    public static Node find(Node root, int key){
        Node current = root;
        while (current.value != key) {
            if (key < current.value)    current = current.left;
            else                        current = current.right;
            if (current == null)
                return null;
        }
        return current;
    }

    Node (int v) {
        this.value = v;
        right = null;
        left = null;
    }
    public void setValue(int v) {
        this.value = v;
    }
    public int getalue() {
        return value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getLeft() {
        return left;
    }
    public void setRight(Node right ) {
        this.right = right;
    }
    public Node getRight() {
        return right;
    }
}
