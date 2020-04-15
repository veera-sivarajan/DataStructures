package datastruct;

public class Node<T> {
  private T data;
  private Node<T> link;
  
  public Node(T data, Node<T> link) {
    this.data = data;
    this.link = link;
  }
  
  public Node(T data) {
    this(data, null);
  }
  
  public T getData() {
    return this.data;
  }
  
  public Node<T> getLink() {
    return this.link;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public void setLink(Node<T> link) {
    this.link = link;
  }
  
  public String toString() {
    String result = "Data: " + (String)this.getData() + "\n" + "Link: " + this.getLink();
    return result; 
  }
}
