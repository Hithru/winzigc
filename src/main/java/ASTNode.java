
import java.util.ArrayList;
import java.util.List;

/**
 * ASTNode represents a node in an Abstract Syntax Tree (AST).
 */
public class ASTNode {

    // Label representing the type of node
    private final String nodeLabel;

    // List to hold child nodes
    private final List<ASTNode> childNodes;

    // Parent node in the tree
    private ASTNode parent;

    /**
     * Constructor for the ASTNode.
     *
     * @param nodeLabel the label for the node.
     */
    public ASTNode(String nodeLabel) {
        this.nodeLabel = nodeLabel;
        this.childNodes = new ArrayList<>();
    }

    /**
     * Returns a defensive copy of the child nodes.
     *
     * @return a list of child nodes.
     */
    public List<ASTNode> getChildNodes() {
        return new ArrayList<>(childNodes);
    }

    /**
     * Adds a child node and sets the parent of the child node to the current node.
     *
     * @param child the node to be added as a child.
     */
    public void addChildNode(ASTNode child) {
        childNodes.add(child);
        child.parent = this;
    }

    /**
     * Inserts a child node at a specific index in the child node list and sets the parent of the child node to the current node.
     *
     * @param index the index at which to add the node.
     * @param child the node to be added as a child.
     */
    public void addChildAtIndex(int index, ASTNode child) {
        childNodes.add(index, child);
        child.parent = this;
    }

    /**
     * Removes a child node from the list of child nodes.
     *
     * @param index the index of the child node to be removed.
     * @return the removed child node.
     */
    public ASTNode removeChildNode(int index) {
        return childNodes.remove(index);
    }

    /**
     * Returns the parent node of the current node.
     *
     * @return the parent node.
     */
    public ASTNode getParent() {
        return parent;
    }

    /**
     * Returns the label of the node.
     *
     * @return the node label.
     */
    public String getNodeLabel() {
        return nodeLabel;
    }

    /**
     * Checks whether the node is a leaf node (i.e., it has no children).
     *
     * @return true if the node is a leaf node, false otherwise.
     */
    public boolean isLeafNode() {
        return childNodes.isEmpty();
    }

    /**
     * Traverses the tree in a depth-first manner, printing each node and its depth level in the process.
     *
     * @param depth the initial depth level.
     */
    public void depthFirstTraverse(int depth) {
        printNodeLabel(depth);
        if (!isLeafNode()) {
            for (ASTNode node : childNodes) {
                node.depthFirstTraverse(depth + 1);
            }
        }
    }

    /**
     * Prints the node's label and the number of child nodes it has, indented by the depth level.
     *
     * @param depth the depth level.
     */
    private void printNodeLabel(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(". ");
        }
        System.out.printf("%s(%d)%n", nodeLabel, childNodes.size());
    }
}
