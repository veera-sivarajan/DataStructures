package datastruct;

public class BinarySearchTree<T> {
  private BSTNode<T> root;
  
  public boolean isEmpty() {
    return root == null;
  }

  public int size(BSTNode<T> node) {
    return subTreeSize(node);
  }

  private int subTreeSize(BSTNode<T> node) {
    if(node == null)
      return 0;
    return 1 + subTreeSize(node.getLeft()) + subTreeSize(node.getRight());
  }
}
