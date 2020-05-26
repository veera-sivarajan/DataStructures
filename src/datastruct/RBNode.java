package datastruct;

public class RBNode<T> {
  private T data;
  private RBNode<T> left;
  private RBNode<T> right;
  private boolean color;

  public RBNode(T data, RBNode<T> left, RBNode<T> right, boolean color) {
    this.data = data;
    this.left = left;
    this.right = right;
    this.color = color;
  }
}
