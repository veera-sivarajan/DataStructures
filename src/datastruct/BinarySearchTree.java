package datastruct;

public class BinarySearchTree<T extends Comparable<T>> {
  private BSTNode<T> root;
  
  public boolean isEmpty() {
    return root == null;
  }

  public int size() {
    return subTreeSize(root);
  }

  private int subTreeSize(BSTNode<T> node) {
    if(node == null)
      return 0;
    return 1 + subTreeSize(node.getLeft()) + subTreeSize(node.getRight());
  }

  public BSTNode<T> find(T data) throws Exception {
    if(root == null)
      throw new Exception("Empty Tree");
    if(data == null)
      throw new NullPointerException();
    return findHelper(data, root);
  }

  private BSTNode<T> findHelper(T data, BSTNode<T> node) {
    if(node == null)
      return null;
    else if(node.getData().compareTo(data) == 0) 
      return node;
    else if(data.compareTo(node.getData()) > 0) 
      return findHelper(data, node.getRight());
    else
      return findHelper(data, node.getLeft());
  }

  public void insert(T data) {
    if(data == null)
      throw new NullPointerException();
    root = insertHelper(root, new BSTNode<T>(data, null, null));
  }

  private BSTNode<T> insertHelper(BSTNode<T> node, BSTNode<T> toAdd) {
    if(node == null)
      return toAdd;
    int result = toAdd.getData().compareTo(node.getData());
    if(result <= 0) 
      node.setLeft(insertHelper(node.getLeft(), toAdd));
    else
      node.setRight(insertHelper(node.getRight(), toAdd));
    return node;
  }
  
  public static void main(String[] args) throws Exception {
    BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
    for(Integer num : new Integer[] {1, 2, 3, 4, 5, 6, 7})
      tree.insert(num);
    Integer num = Integer.valueOf(9);
    if(tree.find(num) != null) 
      System.out.println("Contains");
    System.out.println("Size: " + tree.size());
  }    
}
