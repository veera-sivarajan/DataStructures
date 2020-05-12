package datastruct;

public class BSTNode<T> {
  private T data;
  private BSTNode<T> left;
  private BSTNode<T> right;
  private BSTNode<T> parent;

  public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public BSTNode<T> getParent() {
    return this.parent;
  }

  public void setParent(BSTNode<T> parent) {
    this.parent = parent;
  }

  public T getData() {
    return this.data;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public BSTNode<T> getRight() {
    return this.right;
  }

  public void setRight(BSTNode<T> right) {
    this.right = right;
    if(right != null)
      right.parent = this;
  }
  
  public BSTNode<T> getLeft() {
    return left;
  }
  
  public void setLeft(BSTNode<T> left) {
    this.left = left;
    if(left != null)
      left.parent = this;
  }
}
