package datastruct;

import datastruct.Node;

public class LinkedList<T> {
  private Node<T> head;  
  
  public LinkedList() {
    this.head = null;
  }
  
  public int getSize() {
    if(head == null) 
      throw new NullPointerException("Empty List");
    return getSizeHelper(head);
  }
  
  private int getSizeHelper(Node<T> currNode) {
    if(currNode == null) 
      return 0;
    return 1 + getSizeHelper(currNode.getLink()); 
  }
  
  public void addToTail(Node<T> link) {
    Node<T> tail = head;
    while(tail != null) 
      tail = tail.getLink();
    tail.setLink(link);
  }

  public void addToHead(Node<T> link) {
    link.setLink(head);
    this.head = link;
  }
  
  public static void main(String[] args) {
    LinkedList list = new LinkedList<T>();
    Node ele1 = new Node<T>(5, null);
    list.addToTail(ele1);
  }  
}
