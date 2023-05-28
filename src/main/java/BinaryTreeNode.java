
// Binary tree node to represent nodes in Abstract Syntax Tree (AST)
public class BinaryTreeNode {

    private String nodeLabel;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    private int childCount;

    // Constructor to initialize the tree node with a label
    public BinaryTreeNode(String nodeLabel) {
        this.nodeLabel = nodeLabel;
    }

    // Setters for left, right children and child count
    public void setLeftChild(BinaryTreeNode node) {
        this.left = node;
    }

    public void setRightChild(BinaryTreeNode node) {
        this.right = node;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    // Preorder traversal of the tree with indented printing
    public void preOrderTraverse(int indentSize) {
        printIndentedNodeLabel(indentSize);
        if (this.left != null) {
            left.preOrderTraverse(indentSize + 1);
        }
        if (this.right != null) {
            right.preOrderTraverse(indentSize);
        }
    }

    // Helper method to print the node label indented
    private void printIndentedNodeLabel(int indentSize) {
        for (int i = 0; i < indentSize; i++) {
            System.out.print(". ");
        }
        System.out.println(this.nodeLabel + "(" + this.childCount + ")");
    }
}
